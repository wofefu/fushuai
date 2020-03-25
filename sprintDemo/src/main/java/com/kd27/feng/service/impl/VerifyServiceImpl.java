package com.kd27.feng.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kd27.feng.entity.VerifyInfo;
import com.kd27.feng.entity.VerifyResult;
import com.kd27.feng.service.VerifyService;
import com.kd27.feng.util.FileUtil;
import com.kd27.feng.util.HttpUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
@Service
public class VerifyServiceImpl implements VerifyService {
    // OCR webapi 接口地址
    private static final String WEBOCR_URL = "http://webapi.xfyun.cn/v1/service/v1/ocr/idcard";
    // 应用APPID（必须为webapi类型应用，并开通身份证识别服务，参考帖子如何创建一个webapi应用：http://bbs.xfyun.cn/forum.php?mod=viewthread&tid=36481）
    private static final String APPID = "5e1ef6ae";
    // 接口密钥（webapi类型应用开通身份证识别服务后，控制台--我的应用---身份证识别---相应服务的apikey）
    private static final String API_KEY = "3bae0e85a14fea4166839ad6fc2629f6";
    // 引擎类型
    private static final String ENGINE_TYPE = "idcard";
    // 是否返回头像图片
    private static final String HEAD_PORTRAIT = "0";
    // 是否返回切片图
    //private static final String CROP_IMAGE = "0";

    // 是否返回身份证号码区域截图
    private static final String ID_NUMBER_IMAGE = "0";
    public VerifyResult verify(String paths){
        VerifyResult verify=new VerifyResult();
        VerifyInfo verifyInfo =new VerifyInfo();
            Map<String, String> header = buildHttpHeader();
            byte[] imageByteArray = new byte[0];
            try {
                imageByteArray = FileUtil.read(paths);

                String imageBase64 = new String(Base64.encodeBase64(imageByteArray), "UTF-8");
                String result = HttpUtil.doPost1(WEBOCR_URL, header, "image=" + URLEncoder.encode(imageBase64, "UTF-8"));
                System.out.println("WEB card 接口调用结果：" + result);//错误码链接：https://www.xfyun.cn/document/error-code (code返回错误码时必看)

                JSONObject s= JSON.parseObject(result);
                JSONObject res=s.getJSONObject("data");
                System.out.println(res.getString("type"));
                System.out.println("===============================");
                verifyInfo.setName(res.getString("name"));
                verifyInfo.setBorder_covered((res.getString("border_covered")));
                verifyInfo.setComplete(res.getString("complete"));
                verifyInfo.setGray_image(res.getString("gray_image"));
                verifyInfo.setHead_blurred(res.getString("head_covered"));
                verifyInfo.setId_number(res.getString("id_number"));
                verifyInfo.setValidity(res.getString("validity"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        verify.setData(verifyInfo);
        System.out.println(verify);
        return verify;
    }




    public Map<String, String> buildHttpHeader() {

        String curTime = System.currentTimeMillis() / 1000L + "";
        String param = "{\"engine_type\":\"" + ENGINE_TYPE + "\",\"head_portrait\":\"" + HEAD_PORTRAIT + "\",\"id_number_image\":\"" + ID_NUMBER_IMAGE +"\"}";
        String paramBase64 = null;
        try {
            paramBase64 = new String(Base64.encodeBase64(param.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String checkSum = DigestUtils.md5Hex(API_KEY + curTime + paramBase64);
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        header.put("X-Param", paramBase64);
        header.put("X-CurTime", curTime);
        header.put("X-CheckSum", checkSum);
        header.put("X-Appid", APPID);
        return header;
    }

    public static void main(String[] args) {
        VerifyService verifyService=new VerifyServiceImpl();
//        String[] path = new String[]{,"C:\\Users\\feng\\Documents\\Tencent Files\\614570051\\FileRecv\\MobileFile\\b.jpg"};
        verifyService.verify("C:\\Users\\feng\\Documents\\Tencent Files\\614570051\\FileRecv\\MobileFile\\b.jpg");
    }
}
