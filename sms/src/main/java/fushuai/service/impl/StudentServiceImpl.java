package fushuai.service.impl;

import fushuai.dto.StudentClass;
import fushuai.dto.StudentDetail;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import fushuai.entity.Student;
import fushuai.dao.StudentMapper;
import fushuai.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    public List<StudentClass> selectall() {
        return studentMapper.selectall();
    }


    public List<StudentDetail> selectallDetail() {
        return studentMapper.selectallDetail();
    }

    public StudentDetail selectallbyId(Long id) {
        return studentMapper.selectallbyId(id);
    }

    public List<StudentDetail> selectByclassname(Integer classId) {
        return studentMapper.selectByclassname(classId);
    }
}
