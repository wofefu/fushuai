package com.kd27.feng.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kd27.feng.entity.User;
import com.kd27.feng.entity.VerifyResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.client.RestTemplate;

/**
 *身份证识别 WebAPI 接口调用示例 接口文档（必看）：https://doc.xfyun.cn/rest_api/%E8%BA%AB%E4%BB%BD%E8%AF%81%E8%AF%86%E5%88%AB.html
 *webapi OCR服务参考帖子（必看）：http://bbs.xfyun.cn/forum.php?mod=viewthread&tid=39111&highlight=OCR
 *(Very Important)创建完webapi应用添加身份证识别之后一定要设置ip白名单，找到控制台--我的应用--设置ip白名单，如何设置参考：http://bbs.xfyun.cn/forum.php?mod=viewthread&tid=41891
 *图片属性：仅支持jpg格式，推荐 jpg 文件设置为：尺寸 1024×768，图像质量 75 以上，位深度 24。base64位编码之后大小不超过4M
 *错误码链接：https://www.xfyun.cn/document/error-code (code返回错误码时必看)
 *OCR错误码400开头请在接口文档底部查看
 */
public class idcard {

		
		// 图片地址
		private static final String AUDIO_PATH = "C:\\Users\\feng\\Documents\\Tencent Files\\614570051\\FileRecv\\MobileFile\\b.jpg";
		/**
		 * OCR WebAPI 调用示例程序
		 * 
		 * @param args
		 * @throws IOException
		 */


		/**
		 * 组装http请求头
		 */
        public static void main(String[] args) {
            System.out.println(System.currentTimeMillis());
        }
}