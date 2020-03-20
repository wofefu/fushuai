package servlet;

import ioc.MyContainer;
import mv.MyMV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class CoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletPath());
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //所有的请求 都是发到这来的 我怎么样 让它能执行不同的逻辑呢？

        //Spring怎么做的？ 可以把Url映射到类的方法上

        //我们怎么做 我们把某些可以处理url请求的方法 进行 映射 存到内存里
        //给它标识  按照用户请求的地址 根据标识 去找 到底执行什么方法
        String path = req.getServletPath();
        //path拿到 去容器的urlMappings里去寻找指定的方法 和 实例

        Method m = MyContainer.urlMappings.get(path);
        if (m == null) {
            resp.sendError(404, "没找到对应的urlMapping");
            return;
        }
        //invoke方法 才能调用 它还需要 具体的一个 拥有此方法的对象实例
        //从容器的beans map里找到 拥有此方法的实例

        Object o = MyContainer.beans.get(m.getDeclaringClass().getName());
        try {
            //请求时可能传递的参数如何处理
            //先把用户请求时带来的参数打出来看看 遍历
            Map<String, String[]> requestParams = req.getParameterMap();


            //能拿到参数之后  怎样确保 每个参数 可以绑定到 具有@ReqPath注解的方法上的对应参数里去呢？

            //思路：通过反射 看看这个方法的参数 名字叫啥 是什么类型
            //与请求携带的参数 进行比较 请求过来的参数 都是String类型的 如果两边名字一致 类型不一致 我还得进行类型转换
            //获取Method对象的参数列表
            Parameter[] params = m.getParameters();
            Object[] objects = new Object[params.length];
            //我去看看 这里面要的参数 都叫什么名字 都是什么类型 然后去请求的参数里找能匹配上的
            for (int i = 0; i < params.length; i++) {
                //看一下请求携带的参数中 谁和Method对象所需要的参数相匹配
                String[] values = requestParams.get(params[i].getName());
                if (values == null) {
                    objects[i] = null;
                } else if (values.length == 0) {
                    objects[i] = "";
                } else {
                    objects[i] = values[0];
                }
            }

            Object result = m.invoke(o, objects);

            //要解决的问题是：如果参数给多了？给少了？给的名字不对 怎么办？
            //拿到结果 直接返回给浏览器也行


            //如果想搭配视图呢？
            //在方法映射上 如果返回类型 是 MyMV类型的 则应该去找视图
            if (!(result instanceof MyMV)) {
                resp.getWriter().write((String) result);
            } else {
                //是MyMV类型 则应该处理视图
                //可以使用请求转发
                MyMV myMV = (MyMV) result;
                String tmp = "/WEB-INF/pages/" + myMV.getName();
                //处理要携带的数据
                Map<String, Object> data = myMV.getMap();
                for (Map.Entry<String, Object> e : data.entrySet()) {
                    //遍历的过程中 就是map中有一个要携带的数据，我就在req里
                    //放一个同名的数据 这个名字 map里也有 就是k值
                    req.setAttribute(e.getKey(), e.getValue());
                }
                req.getRequestDispatcher(tmp).forward(req, resp);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        //当此核心Servlet被创建时 应该同时启动 项目的容器
        try {
            MyContainer.start();
            System.out.println("容器创建对象创建完毕");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
