package servlet;

import com.mysql.jdbc.Driver;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        User user = userService.findUser(name, pwd);
        if (user==null){
            req.setAttribute("msg","用户名或密码错误");
            //resp.sendRedirect("login");
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
            //req.getRequestDispatcher("user").forward(req,resp);//死循环
        }else {
            req.getSession().setAttribute("user",user);
            //System.out.println(user.getGender());
            resp.sendRedirect("index");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      User user= (User) req.getSession().getAttribute("user");
      if (user!=null){
          resp.sendRedirect("index");
      } else {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);}
    }

    @Override
    public void init() throws ServletException {
        try {
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
