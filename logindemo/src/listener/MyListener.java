package listener;

import utils.MyDBUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Properties propertie = new Properties();
        String realPath = sce.getServletContext().getRealPath("/WEB-INF/db.properties");
        try {
            propertie.load(new FileReader(realPath));
            System.out.println("加载数据库配置文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyDBUtil.init(propertie);
    }
}
