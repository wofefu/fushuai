package utils;


import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class MyDBUtil {
    public static DataSource ds;

    /**
     * 用来初始化数据库连接池
     */
    public static void init(Properties properties) {
        //初始化DBCP连接池
        try {
            ds = BasicDataSourceFactory.createDataSource(properties);
            System.out.println("数据源记载成功，可以从连接池中获取连接了");
        } catch (Exception e) {
            System.out.println("数据库连接池初始化失败");
            throw new RuntimeException("数据库连接池初始化失败", e);
        }
    }

}