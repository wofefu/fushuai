package servlet;

import entity.MiniBlog;
import entity.User;
import service.VominiBlogService;
import service.impl.VominiBlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {
    private VominiBlogService vominiBlogService = new VominiBlogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            resp.sendRedirect("index");
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String content = req.getParameter("content");
        MiniBlog miniBlog = new MiniBlog();
        miniBlog.setContent(content);
        miniBlog.setUserId(user.getId());
        int num = vominiBlogService.insertContent(miniBlog);
        if (num == 1) {
            resp.sendRedirect("index");
        } else {
            resp.getWriter().print("程序维护中");
        }
    }
}
