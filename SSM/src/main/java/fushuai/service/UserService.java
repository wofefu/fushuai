package fushuai.service;



import com.alibaba.fastjson.JSONObject;
import fushuai.entity.FsMember;
import fushuai.entity.Member;

import java.util.Map;

public interface UserService {
    JSONObject verify(Member member);
    Member selectByTelAndPassword(String tel, String password);
    Map<String, Object> UserList(int pageon);
    /**
     * 通过ID删除指定用户
     * */
    boolean dropMember(int id);
    int updateByPrimaryKey(FsMember record);
}
