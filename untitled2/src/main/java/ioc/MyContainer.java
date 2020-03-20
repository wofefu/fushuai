package ioc;

import annotation.Handler;
import annotation.Important;
import annotation.Need;
import annotation.ReqPath;
import dao.TestDao;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import service.TestService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 迷你版ioc容器
 */
public class MyContainer {

    public static Map<String, Object> beans = new HashMap<String, Object>();
    public static Map<String, Method> urlMappings = new HashMap<>();


    //控制台项目 由main方法启动时，容器需要启动
    public static void start() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //容器启动时 帮我创建这个项目中所有干活的类
        //要想创建，我总得告诉容器 哪些是需要创建的
        //怎么告诉容器？一是使用配置文件，二是使用注解
        //使用反射 项目启动后 读 有指定注解的类 并帮我创建对象

        Reflections reflections = new Reflections();
        //要创建 标注了 @Important注解的类 那我们应该先找到这些类 找到它们的信息
        //通过reflections提供的方法 获取标注了Important注解的所有类
        Set<Class<?>> set = reflections.getTypesAnnotatedWith(Important.class);
        //先遍历 看看能不能拿到 标了指定注解的类的信息
        for (Class<?> c : set) {
            System.out.println(c.getName());
            //如果拿到了类的完全限定名 就可以通过反射 直接创建实例
            beans.put(c.getName(), c.newInstance());
        }
        //实例已在上面创建完毕 剩下的工作是 看看这些实例里面 有哪些是需要去为成员变量赋值的
        //找到这些 为它赋值
        //寻找要赋值的成员变量的过程 依然要用到Class对象

        //这一次for循环的目的 是去找每个要创建的类中 是否有要赋值（注入）的成员变量
        for (Class<?> c : set) {

            //获取 这个类所有自定义的成员变量
            Field[] fields = c.getDeclaredFields();
            if (fields.length > 0)
                System.out.println("为"+c.getSimpleName()+"寻找成员变量");
                for (Field f : fields) {
                    //遍历成员变量 看看哪些是需要赋值的
                    if(f.isAnnotationPresent(Need.class)){
                        System.out.println(f.getName()+"上有@Need注解，需要为其进行注入");
                        //想办法 在man beans里面 找到 实现了该接口的实现类
                        //先获取 该成员变量的类型

                        //得到类型之后 想办法 寻找map中实现了该接口类型的实现类
                        Class implClass = Class.forName(f.getGenericType().getTypeName());
                        System.out.println("通过反射找到接口名"+implClass.getName());
                        Set impls =
                                reflections.getSubTypesOf(implClass);
                        System.out.println("找到的实现类个数"+impls.size());
                        //现在 已经找到了接口的实现类 我需要做的就是 找到已经创建好的接口的实现类的实例
                        //并把它赋值给 当前需要赋值的成员变量
                        for(Object impl:impls){
                            //赋值完 直接break
                            Class cl = (Class) impl;
                            f.setAccessible(true);
                            //Field的set方法 第一个参数是 需要为哪个实例进行赋值
                            //哪个是创建好的实例 beans.get(c.getName())
                            f.set(beans.get(c.getName()),beans.get(cl.getName()));
                            break;

                        }
                    }
                }
        }

        System.out.println(beans);

        System.out.println("开始处理url映射");
        //处理完对象的创建、注入之后，要想办法处理用户请求
        //还是按照上面的思路 把可以处理请求的方法 全都加上我自己的注解
        Set<Class<?>> handlerClasses =  reflections.getTypesAnnotatedWith(Handler.class);
        //找到了所有handler注解的类 就去看看 它的哪些方法 有 @ReqPath注解 找出来存到内存里去
        for(Class<?> cl: handlerClasses){
            Method[] methods  = cl.getDeclaredMethods();
            for(Method m:methods){
                if(m.isAnnotationPresent(ReqPath.class)){
                    ReqPath r = m.getAnnotation(ReqPath.class);
                    //找了就存到内存里去
                    urlMappings.put(r.value(),m);
                    //m.getDeclaringClass来获取是什么类的实例
                }
            }
        }

        System.out.println(urlMappings);

    }




}
