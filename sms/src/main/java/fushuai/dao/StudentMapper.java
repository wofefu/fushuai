package fushuai.dao;

import fushuai.dto.StudentClass;
import fushuai.dto.StudentDetail;
import fushuai.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<StudentClass> selectall();

    StudentDetail selectallbyId(@Param("id") Long id);

    List<StudentDetail> selectByclassname(@Param("cid") Integer classId);
    List<StudentDetail> selectallDetail();
}