package controller;

import annotation.Handler;
import annotation.Important;
import annotation.Need;
import annotation.ReqPath;
import mv.MyMV;
import service.TestService;

import javax.jws.WebParam;

@Handler
@Important
public class MyHandler {
    @Need
    private TestService testService;

    @ReqPath("/test")
    public String veryVeryLongMethodName(String name,String age,String add){
        return "姓名:"+name+"\n年龄:"+age+"\n地址:"+add;
    }

    @ReqPath("/noParam")
    public String noParams(){
        return "这是一个没有参数的url映射";
    }

    @ReqPath("/ioc")
    public String iocTest(){
        return testService.serviceTest();
    }


    //如果想让请求 搭配视图和数据进行展示 我应该告诉Servlet我这个方法 是要和视图建立联系的
    //通过设置返回值为具体类型 告诉servlet这是一个特殊的方法映射 你要帮我找视图
    //具体得告诉它 和什么视图建立联系 带什么数据模型过去（比如request.setAttribute(k,v)）
    @ReqPath("/testMV")
    public MyMV test(String name,String age,String add){
        MyMV myMV = new MyMV();
        myMV.setName("index.jsp");
        //把所有要带过去的数据 装在这map里
        myMV.getMap().put("name",name);
        myMV.getMap().put("age",age);
        myMV.getMap().put("add",add);
        return myMV;
    }
}
