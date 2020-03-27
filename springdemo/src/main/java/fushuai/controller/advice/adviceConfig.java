package fushuai.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class adviceConfig {
    //处理视图，不同的异常统一处理 到同一个视图里面
    //@ExceptionHandler(RuntimeException.class)
    //public String text(RuntimeException e){
    //    System.out.println(e.toString());
    //    e.getMessage();
    //    return "error";
    //}
    //@ExceptionHandler(SQLException.class)
    //public String shuju(SQLException e){
    //    System.out.println(e.toString());
    //    e.getMessage();
    //    return "shujulu";
    //}
}
