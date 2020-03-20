package com.cdchen.auth.service.impl;

import com.cdchen.auth.entity.Role;
import com.cdchen.auth.entity.User;
import com.cdchen.auth.exception.BusinessException;
import com.cdchen.auth.repository.RoleRepository;
import com.cdchen.auth.repository.UserRepository;
import com.cdchen.auth.service.UserService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User login(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, encode(password));

    }

    @Override
    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encode(password));
        userRepository.save(user);
    }

    @Override
    public User buyRole(Long userId, Long[] roleIds) {
        if (roleIds.length > 0) {
            roleIds = Arrays.copyOf(roleIds, roleIds.length + 1);
            roleIds[roleIds.length - 1] = 4L;
        }
        List<Role> roles = roleRepository.findByIdIn(roleIds);
        User u = userRepository.findById(userId).orElseThrow(() -> new BusinessException("用户信息错误"));

//        u.getRoles().clear();
        u.setRoles(roles);

        userRepository.save(u);
        return u;

    }


    private String encode(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("无法进行加密");
        }
        //生成的哈希值的字节数组
        byte[] md5Bytes = md.digest(password.getBytes());
        return bytes2Hex(md5Bytes);
    }

    private String bytes2Hex(byte[] bytes) {
        StringBuffer result;
        result = new StringBuffer();
        int temp;
        try {

            for (byte aByte : bytes) {
                temp = aByte;
                if (temp < 0) {
                    temp += 256;
                }
                if (temp < 16) {
                    result.append("0");
                }
                result.append(Integer.toHexString(temp));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
