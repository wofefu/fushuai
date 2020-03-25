package com.kd27.feng.service;

        import java.io.InputStream;

public interface FileService {
    void keepFileByInputStream(InputStream inputStream,String partPath ,String realPath);

}
