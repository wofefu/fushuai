package fushuai.service.impl;

import com.alibaba.fastjson.JSONObject;
import fushuai.dao.AnchorDao;
import fushuai.entity.Anchor;
import fushuai.service.KaiboService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KaiboServiceImpl implements KaiboService {
    private final AnchorDao anchorDao;
    private final RestTemplate restTemplate;

    public KaiboServiceImpl(RestTemplate restTemplate, AnchorDao anchorDao) {
        this.restTemplate = restTemplate;
        this.anchorDao = anchorDao;
    }

    @Override
    public JSONObject verify(String name, String phone, String idcard) {
        //url参数占位
        String host = "http://zphone.market.alicloudapi.com/efficient/cellphone?idCard={idCard}&mobile={mobile}&realName={realName}";
        String appcode = "9af4c2c2da884dd8b4c3a42d77ca6fca";

        //参数Map
        Map<String, String> querys = new HashMap<>();
        querys.put("idCard", idcard);
        querys.put("mobile", phone);
        querys.put("realName", name);

        //设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "APPCODE " + appcode);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(httpHeaders);

        //因为简单的getForObject方法 不支持添加头部信息 所以采用exchange方法
        try {
            ResponseEntity<String> e = restTemplate.exchange(host, HttpMethod.GET, httpEntity, String.class, querys);

            System.out.println(e);
            return JSONObject.parseObject(e.getBody());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insert(Anchor anchor) {
        anchor.setAddress("rtmp://up.chenchiding.com/kd27/" + anchor.getuId());
        anchor.setAddressload(" http://push.chenchiding.com/kd27/"+anchor.getuId()+".flv");
        System.out.println(anchor.getuId()+"用户id");
        return anchorDao.insert(anchor);
    }
}
