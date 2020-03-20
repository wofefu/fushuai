package com.cdchen.auth.aop;

import com.cdchen.auth.auth.annotation.AuthId;
import com.cdchen.auth.auth.annotation.HasAuth;
import com.cdchen.auth.entity.Role;
import com.cdchen.auth.entity.User;
import com.cdchen.auth.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class AuthAspect {


    @Pointcut("execution(public * com.cdchen.auth.controller.*.*(..))")
    public void jp() {
    }

    @Before("jp()")
    public void checkAuth(JoinPoint joinPoint) {
        //获取拦截到的处理请求的方法的Method对象
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        if (method.isAnnotationPresent(HasAuth.class)) {
            //从session中取出user对象
            User u = (User) RequestContextHolder.
                    currentRequestAttributes().
                    getAttribute("user", RequestAttributes.SCOPE_SESSION);
            if (u == null) {
                throw new BusinessException("未登录");
            }
            HasAuth hasAuth = method.getAnnotation(HasAuth.class);
            String[] roles = hasAuth.roles();
            //使用StreamApi去更优雅的操作集合
            //用数组构建Stream得到List<String>
//            List<String> l1 = new ArrayList<>(Arrays.asList(roles));
            //Stream之collect 可以对生成的流 进行 收集操作
            List<String> annoRoles = Arrays.stream(roles).collect(Collectors.toList());
            //用List<Role>构建Stream使用map操作得到Stream<String>再collect操作得到List<String>
            //List<Role>--Stream<Role>---> map=>Stream<String>--->collect变成List<String>
            List<String> userRoles = u.getRoles().stream().map(Role::getName).collect(Collectors.toList());
            //需要权限 且 所需权限 与 用户已有权限并无交集 则说明无权限访问
            if (annoRoles.size() > 0 && Collections.disjoint(annoRoles, userRoles)) {
                throw new BusinessException("无对应权限");
            }

            //有权限的情况下 要保证部分请求只能访问私人信息
//            //方式一 新定义了一个注解 @AuthId 放到 请求参数上 代表 这个参数 要被我用来进行个人身份检查
//            Object[] args = joinPoint.getArgs();//真实参数
//            Parameter[] parameters = method.getParameters();//方法的参数反射对象
//            for (int i = 0; i < parameters.length; i++) {
//                if(parameters[i].isAnnotationPresent(AuthId.class)){
//                    //我需要记住 这是这个方法的 第几个参数 因为aop里 joinpoint只能拿到参数的值 而拿不到参数的名字
//                    //i拿到之后 去真实参数里 找对应的参数
//                    if(!String.valueOf(args[i]) .equals( String.valueOf(u.getId()) )){
//                        throw new BusinessException("只能访问自己的资源");
//                    }
//
//                }
//            }




            String idInfo = hasAuth.id();//得到类似 #userId 或者 2
            Object[] args = joinPoint.getArgs();//该方法 获取 方法调用时 实际传递的参数
            //比如方法定义是 int add(int a,int b)
            //如果你正在准备调用add(1,2) 当切入这个方法是 joinPoint.getArgs()得到的就是 [1,2]
            //反射参数 method.getParameters() 得到的 是封装了两个参数特征的对象 而不是真实的值
            //add方法 对应的Method对象 如果去getParameters()   [int a这个参数 参数名称是啥，类型是啥。。。,
            // int b这个参数 参数名称是啥，类型是啥。。。  ]
            if(!idInfo.isEmpty()){
                //说明要求用户只能访问自己的资源
                if(idInfo.startsWith("#")){
                    String paramName = idInfo.replace("#","");
                    Parameter[] parameters = method.getParameters();
                    for (int i = 0; i < parameters.length; i++) {
                        if(parameters[i].getName().equals(paramName)){
                            idInfo = String.valueOf(args[i]);//这是用户传递的真实参数
                            System.out.println("id是:"+idInfo);
                            if(!String.valueOf(u.getId()).equals(idInfo)){
                                throw new BusinessException("只能访问自己的资源");
                            }
                        }
                    }

                }else{
                    if(!String.valueOf(u.getId()).equals(idInfo)){
                        throw new BusinessException("该资源只有指定的用户可以访问");
                    }
                }
            }





        }

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","java","world","pubg","lol","dota2");
        //如果想过滤出其中 长度>=4的字符串  以前想到的遍历  如果使用java8 Stream API
        list  = list.stream().filter(s -> s.length()>4).collect(Collectors.toList());
        System.out.println(list);
    }
}
