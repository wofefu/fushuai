package servlet;

import entity.User;
import service.VominiBlogService;
import service.impl.VominiBlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class RuanDeleteServlet extends HttpServlet {
    private VominiBlogService vominiBlogService=new VominiBlogServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("user");
        int blogId= Integer.parseInt(req.getParameter("blogId"));
        vominiBlogService.ruandelete(user.getId(),blogId);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("user");
        if (user!=null){
            resp.sendRedirect("myBlog");
        }else {
            resp.sendRedirect("login");
        }
    }
}
