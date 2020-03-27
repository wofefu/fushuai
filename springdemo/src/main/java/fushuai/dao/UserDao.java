package fushuai.dao;

import fushuai.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface UserDao {
    User login(@Param("username") String username, @Param("password") String password);
    User selectUser(int id);
    void register(@Param("u") User user);
    void insertRole(@Param("id") int id);
}
