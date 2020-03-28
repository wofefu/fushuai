package fushuai.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import fushuai.dao.ClassesMapper;
import fushuai.entity.Classes;
import fushuai.service.ClassesService;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService{

    @Resource
    private ClassesMapper classesMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return classesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Classes record) {
        return classesMapper.insert(record);
    }

    @Override
    public int insertSelective(Classes record) {
        return classesMapper.insertSelective(record);
    }

    @Override
    public Classes selectByPrimaryKey(Long id) {
        return classesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classes record) {
        return classesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classes record) {
        return classesMapper.updateByPrimaryKey(record);
    }

    public List<Classes> selectAll() {
        return classesMapper.selectAll();
    }

    public Classes selectByCname(String cname) {
        return classesMapper.selectByCname(cname);
    }
}
