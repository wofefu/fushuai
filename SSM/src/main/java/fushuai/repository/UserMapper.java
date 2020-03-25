package fushuai.repository;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import fushuai.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByUsername(@Param("username")String username);

    int insertList(@Param("list")List<User> list);



}