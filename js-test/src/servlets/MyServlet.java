package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/s")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        /*out.write("<h2>用户注册</h2>");
        out.write("<form action='/s1'>username:<input type='text' name='username' value=' " + username + "'><br/>...<br/><input type='submit' value='注册'></form>");*/

        //检查用户名是否重复
        if("admin".equals(username)){
            out.write("用户名不可用");
        }else {
            out.write("用户名可用");
        }

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        out.close();

        //resp.sendRedirect(req.getContextPath() + "/js01.html");
    }
}
