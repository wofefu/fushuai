package servlet;

import com.alibaba.fastjson.JSONObject;
import entity.User;
import service.VominiBlogService;
import service.impl.VominiBlogServiceImpl;
import vo.VominiBlog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myBlog")
public class MyBlogServlet extends HttpServlet {
    private VominiBlogService vominiBlogService = new VominiBlogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Integer minId;
        if (user != null) {

            Integer minBlogId = Integer.parseInt(req.getParameter("minBlogId"));
            if (minBlogId!=-1){
                minId=minBlogId;

            }else {
               minId=null;
            }
            System.out.println(minId);
            List<VominiBlog> list = vominiBlogService.selectMyBlog(minId, user.getId());
            String result = JSONObject.toJSONString(list);
            System.out.println(result);
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            resp.getWriter().write(result);
        } else {
            resp.sendRedirect("login");
        }
    }
}
