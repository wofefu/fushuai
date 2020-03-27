package fushuai.service.impl;

import fushuai.dao.AnchorDao;
import fushuai.entity.Anchor;
import fushuai.service.ZhiBoService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ZhiBoServiceImpl implements ZhiBoService {
    private final AnchorDao anchorDao;

    public ZhiBoServiceImpl(AnchorDao anchorDao) {
        this.anchorDao = anchorDao;
    }

    @Override
    public void keepFileByInputStream(InputStream inputStream, String partPath, String realPath, Anchor anchor) {
        System.out.println(anchor.getTitle());
        anchorDao.updateTitle(anchor.getTitle(),anchor.getIcon(),anchor.getuId());
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
