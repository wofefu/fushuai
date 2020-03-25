package fushuai.repository;



import fushuai.entity.Member;
import fushuai.utils.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;


@Mapper
public interface MemberDao {
    /**
     * 实名注册用户
     * @param member
     * @return
     */
    int newMember(@Param("member") Member member);

    /**
     * 插入用户角色
     * @param memberId
     */
    void  insertrole(@Param("memberId") int memberId);

    /**
     * 用户登陆
     * @param tel  手机号
     * @param password  密码
     * @return   用户
     */
    Member selectByTelAndPassword(@Param("tel") String tel, @Param("password") String password);
    int selectPageListCount();
    List<Member> selectPageList(Page page);
    /**
     *  根据用户Id删除用户
     *  */
    void deleteMember(@Param("id") int id);
}
