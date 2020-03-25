package fushuai.repository;

import fushuai.entity.FsMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FsMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FsMember record);

    int insertSelective(FsMember record);

    FsMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsMember record);

    int updateByPrimaryKey(FsMember record);
}