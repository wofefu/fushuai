package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/icon")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            req.getRequestDispatcher("WEB-INF/jsp/upload.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Part part = req.getPart("icons");
        InputStream in = part.getInputStream();
        String shotpath = "user_resources/img/" + user.getId() + "/" + part.getSubmittedFileName();
        String filePath = req.getServletContext().getRealPath(shotpath);
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(file);
        int result;
        while ((result = in.read()) != -1) {
            out.write(result);
        }
        in.close();
        out.close();
        int num = userService.Picture(shotpath, user.getId());
        if (num == 1) {
            user.setIcon(shotpath);
            req.getSession().setAttribute("user",user);
            resp.getWriter().write("<a href='index'>back</a>");
        } else {
            resp.getWriter().write("程序维护中");
        }
    }
}
