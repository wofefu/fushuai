package com.example.app.filter;

import com.example.app.token.MyAppToken;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/**")
@Component
public class LoginFilter implements Filter {
    private final MyAppToken myAppToken;

    public LoginFilter(MyAppToken myAppToken) {
        this.myAppToken = myAppToken;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String token = req.getParameter("token");
        if (!request.getServletPath().equals("/login")) {

            if (myAppToken.checkedToken(token)){
                chain.doFilter(req, resp);
            }else {
                request.getRequestDispatcher("/error").forward(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
