package com.kd27.feng.service.impl;

import com.kd27.feng.service.FileService;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void keepFileByInputStream(InputStream inputStream,String partPath ,String realPath) {
        try {
            File file = new File(realPath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                FileOutputStream fos = new FileOutputStream(file);
                int result;
                while ((result = inputStream.read()) != -1) {
                    fos.write(result);
                }
                inputStream.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
