package fushuai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import fushuai.dto.StudentClass;
import fushuai.dto.StudentDetail;
import fushuai.entity.Classes;
import fushuai.entity.Student;
import fushuai.service.ClassesService;
import fushuai.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class StudentController {
    //实现查询所有学员信息、查询所有班级信息、根据学员编号查询学员信息、修改学员信息功能
    private final StudentService studentService;
    private final ClassesService classesService;

    public StudentController(StudentService studentService, ClassesService classesService) {
        this.studentService = studentService;
        this.classesService = classesService;
    }
     @GetMapping("selectByclassname")
     public PageInfo<StudentDetail> selectByclassname(Integer pageIndex,Integer pageMax,Integer classId){
        if (pageIndex<0) pageIndex=1;
        if (pageMax>20||pageMax<=0) pageMax=10;
        return new PageInfo<StudentDetail>(studentService.selectByclassname(classId));
     }
    /**
     * 实现查询所有学员信息
     * @param
     * @return
     */
     @GetMapping("/allinfoStudent")
    public List<StudentClass> aClass(Integer pageIndex,Integer pageMax){
         System.out.println(pageMax+"asdfafasdfasdfasdf");
         if (pageIndex<0)pageIndex=1;
         if (pageMax>20||pageMax<=0)pageMax=10;
         PageHelper.startPage(pageIndex,pageMax);
         return studentService.selectall();
     }

     @GetMapping("/alldetail")
     public PageInfo<StudentDetail> alldetail(Integer pageIndex,Integer pageMax){
         System.out.println(pageMax+"asdfafasdfasdfasdf");
         if (pageIndex<0) pageIndex=1;
         if (pageMax>20||pageMax<=0) pageMax=10;
         PageHelper.startPage(pageIndex,pageMax);
         return new PageInfo<>(studentService.selectallDetail());
     }
    /**
     *根据学员编号查询学员信息
     * @param response
     * @param id
     * @return
     */
    @GetMapping("/OneStudent/{id}")
    public StudentDetail studentClass(HttpServletResponse response,@PathVariable Integer id){
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        Long id1= Long.valueOf(id);
        StudentDetail studentDetail= studentService.selectallbyId(Long.valueOf(id1));
        studentDetail.setClassid(0L);
        return studentDetail;
    }

    /**
     * 修改学员信息功能
     * @param
     * @return
     */
    @PostMapping("/update")
    public int update(@RequestBody Student student){
        System.out.println(student+"修改学生信息");
        return studentService.updateByPrimaryKeySelective(student);
    }
    /**
     * 查询所有班级信息
     * @param response
     * @return
     */
     @GetMapping("/allclass")
     public List<Classes> classesList(HttpServletResponse response){
         response.setContentType("application/json");
         response.setCharacterEncoding("utf-8");
         return classesService.selectAll();
     }

}
