package fushuai.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import fushuai.entity.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Long id);

    List<Classes> selectAll();

    Classes selectByCname(@Param("cname") String cname);


    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}