package com.example.demo.interceptor;

import com.example.demo.annotation.HasRole;
import com.example.demo.entity.User;
import com.example.demo.exception.ToViewException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {



        //只要权限不通过 我就return false 不让请求的方法执行
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Method m = hm.getMethod();

            //拿到方法之后 判断session里 user的role 是不是和方法上的匹配

            if (m.isAnnotationPresent(HasRole.class)) {
                if (request.getSession().getAttribute("user") == null) {
                    throw new ToViewException("未登录");
                }

                HasRole hr = m.getAnnotation(HasRole.class);
                String[] str = hr.value();

                User u = (User) request.getSession().getAttribute("user");
                String userRole = u.getRole().name();
                if (!Arrays.asList(str).contains(userRole)) {
                    throw new ToViewException("403非法闯入");
                }

                if (!hr.id().isEmpty()) {
                    //说明 是需要id访问的资源 校验传参id是否和session用户相同
                    String id = hr.id();
//                    if (id.startsWith("#")) {
//                        //找到对应id要求的参数
//                        //从实际的方法参数里拿
//                        int uId = Integer.parseInt(request.getParameter(id.replace("#", "")));
//                        if (uId != u.getId()) {
//                            throw new ToViewException("只能访问自己的资源");
//                        }
//                    }

                    //restful改进
                    Map<String,String> map = (Map<String, String>) request
                            .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
                    if (id.startsWith("#")) {
                        //找到对应id要求的参数
                        //从实际的方法参数里拿
                        int uId =  Integer.parseInt(map.get(id.replace("#", "")));
                        if (uId != u.getId()) {
                            throw new ToViewException("只能访问自己的资源");
                        }
                    }
                }



            }
        }




        return true;
    }


}
