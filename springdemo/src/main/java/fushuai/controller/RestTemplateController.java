package fushuai.controller;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RestTemplateController {
    private final RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        String host = "http://poetry.nlpai.cn";
        String path = "/zidongxieshi";
        String method = "POST";
        String appcode = "9af4c2c2da884dd8b4c3a42d77ca6fca";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("cangtou", "true");
        bodys.put("text", "我爱鲁玲");
        bodys.put("type", "7");


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
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writerPoem(String cangtou,String text,String type){
        String host = "http://poetry.nlpai.cn/zidongxieshi";
        String appcode = "9af4c2c2da884dd8b4c3a42d77ca6fca";


        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("cangtou", cangtou);
        bodys.put("text", text);
        bodys.put("type", type);

        //设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "APPCODE " + appcode);
        httpHeaders.set("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<Map<String, String>>(bodys,httpHeaders);
        ResponseEntity<Map> response2 = restTemplate.postForEntity(host, httpEntity, Map.class);




        System.out.println(response2);
    }

}
