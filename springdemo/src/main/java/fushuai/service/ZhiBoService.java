package fushuai.service;

import fushuai.entity.Anchor;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface ZhiBoService {
    /**
     * 保存上传的图片到target中
     * @param inputStream    图片转换成字节放入流中 变成这个对象inputStream就代表图片的字节流文件形式
     * @param partPath    要存放的地址
     * @param realPath    项目地址
     * @param anchor      主播这个对象  传的是直播标题
     */
    void keepFileByInputStream(InputStream inputStream,String partPath,String realPath,Anchor anchor);
}
