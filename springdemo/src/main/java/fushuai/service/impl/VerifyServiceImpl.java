package fushuai.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import fushuai.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyServiceImpl implements VerifyService {
    private final ObjectMapper objectMapper;

    public VerifyServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void verify(String name, String phoneNumber, String icard) {
        JSONObject o= JSON.parseObject("sadf");
        JSONObject res= (JSONObject) o.get("result");
        String s=res.getString("verificationresult");

    }
}
