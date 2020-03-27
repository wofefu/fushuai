package fushuai.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import fushuai.entity.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.client.RestTemplate;
import utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;


@Controller
public class sanfangController {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public sanfangController(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        String host = "https://yxidcard.market.alicloudapi.com/idcard?idcard={idcard}&realname={realname}";
        String appcode = "9af4c2c2da884dd8b4c3a42d77ca6fca";
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("idcard", "341124199601015619");
        querys.put("realname", "冯宁");


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "APPCODE " + appcode);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(httpHeaders);


        //因为简单的getForObject方法 不支持添加头部信息 所以采用exchange方法
        //  RestTemplate restTemplate=new RestTemplate();
        //JSONObject j=  restTemplate.getForObject(host, JSONObject.class,querys);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> e = restTemplate.exchange(host, HttpMethod.GET, httpEntity, String.class, querys);
        System.out.println(e);
        JSONObject.parseObject(e.getBody());
    }

    @GetMapping
    public String icard1() {
        return "icard";
    }

    @PostMapping("icard")
    public Object icard(User user) {
        String host = "https://yxidcard.market.alicloudapi.com";
        String path = "/idcard";
        String method = "GET";
        String appcode = "9af4c2c2da884dd8b4c3a42d77ca6fca";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("idcard", user.getIcard());
        querys.put("realname", user.getUsername());


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response;
            response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
            return objectMapper.readValue(EntityUtils.toString(response.getEntity()), Object.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
