package servlet;

import com.alibaba.fastjson.JSON;
import entity.Praise;
import entity.User;
import service.PraiseService;
import service.VominiBlogService;
import service.impl.PraiseServiceImpl;
import service.impl.VominiBlogServiceImpl;
import utils.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/praise")
public class PraiseServlet extends HttpServlet {
    private PraiseService praiseService=new PraiseServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        User user = (User) req.getSession().getAttribute("user");
        int blogid = Integer.parseInt(req.getParameter("blogId"));
        //System.out.println(req.getParameter("blogId"));
        int num = praiseService.update(blogid,user.getId());
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("login");
        } else {
            resp.sendRedirect("index");
        }
    }
}
