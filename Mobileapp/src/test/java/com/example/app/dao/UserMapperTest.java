package com.example.app.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

public class UserMapperTest {
    private static UserMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(UserMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/UserMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(UserMapper.class, builder.openSession(true));
    }

    @Test
    @Transactional  /*事务回滚*/
    public void testFindByPhoneAndPassword() throws FileNotFoundException {
        mapper.findByPhoneAndPassword("18756759293", "123456");
    }


}
