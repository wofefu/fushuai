package fushuai.service;

import fushuai.dto.StudentClass;
import fushuai.dto.StudentDetail;
import fushuai.entity.Student;

import java.util.List;

public interface StudentService{


    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<StudentClass> selectall();

    StudentDetail selectallbyId(Long id);

    List<StudentDetail> selectallDetail();

    List<StudentDetail> selectByclassname(Integer classId);
}
