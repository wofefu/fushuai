package com.kd27.feng.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作工具类
 */
public class FileUtil {


    private static final String ACCESS_KEY = "4r3kJMZ7RvDKxhZE3t-sv_sAL4_-UWLa-qdH7wFt";
    private static final String SECRET_KEY = "RpLA9YRG31aJqJZf65UEvbns1JXxCCnSlTbzYf4B";
    private static final String BUCKET_NAME = "fengn";
    private static final  String domainOfBucket=   "http://q33q03qad.bkt.clouddn.com";
    private static Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
	/**
	 * 读取文件内容为二进制数组
	 * 
	 * @param filePath 路径
	 * @return
	 * @throws IOException
	 */
	public static byte[] read(String filePath) throws IOException {

		InputStream in = new FileInputStream(filePath);
		byte[] data = inputStream2ByteArray(in);
		in.close();

		return data;
	}

	/**
	 * 流转二进制数组
	 * 
	 * @param in 输入流
	 * @return
	 * @throws IOException
	 */
	private static byte[] inputStream2ByteArray(InputStream in) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024 * 4];
		int n = 0;
		while ((n = in.read(buffer)) != -1) {
			out.write(buffer, 0, n);
		}
		return out.toByteArray();
	}

	/**
	 * 保存文件
	 * 
	 * @param filePath
	 * @param fileName
	 * @param content
	 */
	public static void save(String filePath, String fileName, byte[] content) {
		try {
			File filedir = new File(filePath);
			if (!filedir.exists()) {
				filedir.mkdirs();
			}
			File file = new File(filedir, fileName);
			OutputStream os = new FileOutputStream(file);
			os.write(content, 0, content.length);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


    public static void upload(String filepath){
        File file =new File(filepath);
        if (file.exists()){
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            //保存到服务器后的文件名 (保证唯一)
            String key=file.getName();
            //文件的本地地址
            String localFilePath=filepath;
            String upToken=auth.uploadToken(BUCKET_NAME);

            Configuration cfg=new Configuration(Region.region2());
            UploadManager upload=new UploadManager(cfg);

            try {
                Response response=upload.put(localFilePath,key,upToken);
                System.out.println();
                DefaultPutRet putRet =new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
                response.close();
                System.out.println(FileUtil.domainOfBucket+"/"+key);;
            } catch (QiniuException e) {
                Response r = e.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
