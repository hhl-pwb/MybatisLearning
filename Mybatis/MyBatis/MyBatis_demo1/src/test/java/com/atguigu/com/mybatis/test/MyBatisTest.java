package com.atguigu.com.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisTest {

    @Test
    public void testInsertUser() throws IOException {
        // 读取MyBatis核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder  = new SqlSessionFactoryBuilder();
        // 通过核心配置文件所对应的字节输入流创建工场类SqlSessionFactory,生成sqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = mapper.insertUser();
        //提交事务
        sqlSession.commit();
        System.out.println("result:" + result);
    }

}
