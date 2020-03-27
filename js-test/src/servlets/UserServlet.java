package servlets;

import com.alibaba.fastjson.JSON;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users/findAll")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在从数据库中检索所有用户....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<User> users = new ArrayList<>();
        User u1 = new User(1, "admin", "123", "110");
        User u2 = new User(2, "zhangsan", "111", "112");
        User u3 = new User(3, "李四", "222", "111");
        User u4 = new User(4, "王五", "333", "114");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);

        //Java对象 --> {"propName":propValue, ...}
        //List、Set、数组 --> [{"propName":propValue, ...}, ...]
        //Map --> {"propName":propValue, ...}
        //json 数字、字符串、布尔
        String usersJson = JSON.toJSONString(users);
        System.out.println("---------->" + usersJson);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(usersJson);
    }
}
