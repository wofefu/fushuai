package com.cdchen.auth.service.impl;

import com.cdchen.auth.entity.Role;
import com.cdchen.auth.repository.RoleRepository;
import com.cdchen.auth.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }


}
