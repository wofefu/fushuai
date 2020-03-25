package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns ="/*" )
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpServletRequest request= (HttpServletRequest) req;
        String uri=request.getRequestURI();
        if (uri.equals("/a/login")||uri.equals("/a/")||uri.equals("/a/regist")){
            chain.doFilter(req, resp);
        }else {
            if (request.getSession().getAttribute("user")!=null) {
                chain.doFilter(req, resp);
            }else {
                HttpServletResponse response= (HttpServletResponse) resp;
                response.sendRedirect("login");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
