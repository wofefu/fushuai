package fushuai.service;

import fushuai.entity.FsMember;

public interface FsMemberService {


    int deleteByPrimaryKey(Integer id);

    int insert(FsMember record);

    int insertSelective(FsMember record);

    FsMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsMember record);

    int updateByPrimaryKey(FsMember record);

}

