package fushuai.service.impl;


import com.alibaba.fastjson.JSONObject;
import fushuai.entity.FsMember;
import fushuai.entity.Member;
import fushuai.repository.FsMemberMapper;
import fushuai.repository.MemberDao;
import fushuai.service.UserService;
import fushuai.utils.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final FsMemberMapper fsMemberMapper;
    private final RestTemplate restTemplate;

    private final MemberDao memberDao;

    public UserServiceImpl(MemberDao memberDao, RestTemplate restTemplate, FsMemberMapper fsMemberMapper) {
        this.memberDao = memberDao;
        this.restTemplate = restTemplate;
        this.fsMemberMapper = fsMemberMapper;
    }

    @Override
    public JSONObject verify(Member member) {
        //url参数占位
        String host = "http://zphone.market.alicloudapi.com/efficient/cellphone?idCard={idCard}&mobile={mobile}&realName={realName}";
        String appcode = "9af4c2c2da884dd8b4c3a42d77ca6fca";

        //参数Map
        Map<String, String> querys = new HashMap<>();
        querys.put("idCard", member.getCarNo());
        querys.put("mobile", member.getTel());
        querys.put("realName", member.getTrueName());

        //设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "APPCODE " + appcode);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(httpHeaders);

        //因为简单的getForObject方法 不支持添加头部信息 所以采用exchange方法
        try {
            ResponseEntity<String> e = restTemplate.exchange(host, HttpMethod.GET, httpEntity, String.class, querys);
            JSONObject res = (JSONObject) JSONObject.parseObject(e.getBody()).get("result");
            String s = res.getString("VerificationResult");
            if (s.equals("1")) {
                memberDao.newMember(member);
                System.out.println(member.getId() + "-----------------");
                memberDao.insertrole(member.getId());
                System.out.println(e);

            }
            return JSONObject.parseObject(e.getBody());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Member selectByTelAndPassword(String tel, String password) {
        Member member = memberDao.selectByTelAndPassword(tel, password);
        return member;
    }

    @Override
    public Map<String, Object> UserList(int pageon) {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String, Object>();
        Page page = new Page(pageon);
        page.setRowcountAndCompute(memberDao.selectPageListCount());
        map.put("page", page);
        map.put("list", memberDao.selectPageList(page));
        return map;
    }

    @Override
    public boolean dropMember(int id) {
        try {
            memberDao.deleteMember(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int updateByPrimaryKey(FsMember record) {
        try {
            fsMemberMapper.updateByPrimaryKey(record);
            return 1;
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return -1;
        }
    }
}
