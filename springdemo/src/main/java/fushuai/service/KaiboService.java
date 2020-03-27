package fushuai.service;

import com.alibaba.fastjson.JSONObject;
import fushuai.entity.Anchor;
import org.springframework.stereotype.Service;


public interface KaiboService {
    /**
     * 实名认证  引用三方api
     * @param name  真实姓名
     * @param phone  真实手机号
     * @param idcard  真实身份证号
     * @return   三方api提供的返回信息
     */
    JSONObject verify(String name,String phone,String idcard);

    /**
     * 注册昵称，直播的推流地址 ，当前用户id
     * @param anchor
     * @return
     */
    int insert(Anchor anchor);
}
