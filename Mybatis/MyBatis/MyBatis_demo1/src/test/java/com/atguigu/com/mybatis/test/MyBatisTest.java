package com.atguigu.com.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    @Test
    public void testInsertUser() throws IOException {
        /**
         * SqlSession默认不自动提交事务，若需要自动提交事务
         * 可以使用SqlSessionFactory.openSession(true)
         */
        // 读取MyBatis核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 通过核心配置文件所对应的字节输入流创建工场类SqlSessionFactory,生成sqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = mapper.insertUser();
        //提交事务
//        sqlSession.commit();
        System.out.println("result:" + result);
    }

    /**
     * 测试修改
     *
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
    }

    /**
     * 测试删除
     *
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delteUser();
    }

    @Test
    public void testselect() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById();
        List<User> allUser = mapper.getAllUser();
        System.out.println(user);
        System.out.println(allUser);
    }
}
