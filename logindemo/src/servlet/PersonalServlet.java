package servlet;

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

@WebServlet("/update")
public class PersonalServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/personal.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        User user = new User();
        User user1 ;
        HttpSession session = req.getSession();
        user1 = (User) session.getAttribute("user");
        user.setNickName(req.getParameter("nickName"));
        //System.out.println(req.getParameter("nickName"));
        String birthday=req.getParameter("birthday");
        if (birthday.equals(" ")){
            birthday=null;
        }
        user.setBirthday(birthday);
        user.setHometown(req.getParameter("hometown"));
        user.setGender(req.getParameter("gender"));
        user.setJob(req.getParameter("job"));
        user.setId(user1.getId());
        user.setIcon(user1.getIcon());
        int num = userService.UpdateUser(user);
        if (num == 1) {
            req.setAttribute("msg","修改成功");
            System.out.println(user.getIcon());
            session.setAttribute("user",user);
            req.getRequestDispatcher("/WEB-INF/jsp/personal.jsp").forward(req, resp);
        } else {
            System.out.println("程序维护中");
        }
    }
}
