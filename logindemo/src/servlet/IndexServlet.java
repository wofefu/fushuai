package servlet;

import com.alibaba.fastjson.JSONObject;
import entity.User;
import service.VominiBlogService;
import service.impl.VominiBlogServiceImpl;
import vo.VoDiscuss;
import vo.VominiBlog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private VominiBlogService vominiBlogService=new VominiBlogServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user= (User) req.getSession().getAttribute("user");

        if(req.getSession().getAttribute("user")!=null){
            String page=req.getParameter("page");
            if (page==null){
                page="1";
            }
         List<VominiBlog> list= vominiBlogService.select(6,Integer.parseInt(page),user.getId());
            System.out.println(list.get(0));
            req.setAttribute("page",page);
            req.setAttribute("list",list);
            req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
