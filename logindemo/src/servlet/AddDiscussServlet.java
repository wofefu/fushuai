package servlet;

import entity.User;
import service.DiscussService;
import service.impl.DiscussServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDiscuss")
public class AddDiscussServlet extends HttpServlet {
    private DiscussService discussService=new DiscussServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String content=req.getParameter("content");
        System.out.println(req.getParameter("blogId"));
        int blogId= Integer.parseInt(req.getParameter("blogId").trim());
        discussService.insert(blogId,user.getId(),content);
    }
}
