package servlet;

import entity.User;
import service.CountService;
import service.impl.CountServiceImpl;
import vo.Count;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/count")
public class CountServlet extends HttpServlet {
    private CountService countService=  new CountServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("user");
        if (user!=null){
            Count count =countService.count(user.getId());
            req.setAttribute("count",count);
            req.getRequestDispatcher("WEB-INF/jsp/userdata.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
