package fushuai.service;

import fushuai.entity.Classes;

import java.util.List;

public interface ClassesService{


    int deleteByPrimaryKey(Long id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    List<Classes> selectAll();

    Classes selectByCname(String cname);
}
