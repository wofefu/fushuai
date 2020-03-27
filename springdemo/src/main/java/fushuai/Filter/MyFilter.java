package fushuai.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        //resp.setCharacterEncoding("utf-8");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        chain.doFilter(request,response);
        //
        //if (path.startsWith("/public/")) {
        //    chain.doFilter(req, resp);
        //} else if (path.startsWith("/admin/")) {
        //    User user = (User) session.getAttribute("user");
        //    if (user != null && user.getRoles().contains("superadmin")) {
        //        chain.doFilter(req, resp);
        //    } else {
        //        response.getWriter().write("无权访问");
        //    }
        //} else if (path.startsWith("/all")) {
        //    User user = (User) session.getAttribute("user");
        //    System.out.println(user);
        //    System.out.println(user.getRoles());
        //    if (user != null && user.getRoles().contains("COMMON")) {
        //        chain.doFilter(req, resp);
        //    } else {
        //        response.getWriter().write("无权访问");
        //    }
        //} else if (path.startsWith("/resources")) {
        //    chain.doFilter(request, response);
        //} else {
        //    response.sendRedirect(request.getContextPath() + "/public/login");
        //}
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
