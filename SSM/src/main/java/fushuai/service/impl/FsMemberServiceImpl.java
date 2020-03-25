package fushuai.service.impl;

import org.springframework.stereotype.Service;
import fushuai.repository.FsMemberMapper;
import fushuai.entity.FsMember;
import fushuai.service.FsMemberService;

@Service
public class FsMemberServiceImpl implements FsMemberService {

    private final FsMemberMapper fsMemberMapper;

    public FsMemberServiceImpl(FsMemberMapper fsMemberMapper) {
        this.fsMemberMapper = fsMemberMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return fsMemberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FsMember record) {
        return fsMemberMapper.insert(record);
    }

    @Override
    public int insertSelective(FsMember record) {
        return fsMemberMapper.insertSelective(record);
    }

    @Override
    public FsMember selectByPrimaryKey(Integer id) {
        return fsMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FsMember record) {
        return fsMemberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FsMember record) {
        return fsMemberMapper.updateByPrimaryKey(record);
    }

}

