package com.fushuai.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration //表示该类提供的是配置信息，同时也会注册为ioc容器中的bean
@PropertySource("classpath:dataSource.properties")//引入外部properties文件
@ComponentScan(basePackages = {"com.fushuai.service.impl"})//spring扫包
@MapperScan(basePackages = {"com.fushuai.dao"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String passsword;
    @Value("${db.initialSize}")
    private int initialSize;
    @Value("${db.maxActive}")
    private int maxActive;
    @Value("${db.maxWait}")
    private int maxWait;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(passsword);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }

    /*
        如果需要引用容器中的其他bean，直接声明为对应类型的方法形参即可
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.kd27.ssm1.entity");
        Resource configLocation = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        /*Resource userMapper = new ClassPathResource("mapper/UserMapper.xml");
        Resource[] resources = new Resource[]{userMapper};*/
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = pathMatchingResourcePatternResolver.getResources("classpath:mapper/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    /*@Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.kd27.ssm1.dao");
        return mapperScannerConfigurer;
    }*/

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
