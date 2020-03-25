package servlet;

import com.alibaba.fastjson.JSONObject;
import entity.User;
import service.DiscussService;
import service.VominiBlogService;
import service.impl.DiscussServiceImpl;
import service.impl.VominiBlogServiceImpl;
import vo.VoDiscuss;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/discuss")
public class DiscussServlet extends HttpServlet {
    //private DiscussService discussService=new DiscussServiceImpl();
    private VominiBlogService vominiBlogService=new VominiBlogServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User user = (User) req.getSession().getAttribute("user");
       if (user!=null){
           resp.sendRedirect("index");
       }else {
           resp.sendRedirect("login");
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        //req.setCharacterEncoding("utf-8");
        //String content=req.getParameter("content");
        int blogId= Integer.parseInt(req.getParameter("blogId"));
        //System.out.println(content+blogId);
        //discussService.insert(blogId,user.getId(),content);
        //int uId= Integer.parseInt(req.getParameter("uId"));
        List<VoDiscuss> list=vominiBlogService.selectDis(blogId);
        resp.setContentType("application/json");
        String str=JSONObject.toJSONString(list);
        resp.getWriter().write(str);
    }
}
