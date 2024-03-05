package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacharMapperTest {
    @Test
    public void testGetEmpByIdCacha(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CachaMapper mapper1 = sqlSession1.getMapper(CachaMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CachaMapper mapper2 = sqlSession2.getMapper(CachaMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testCacheTwo(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CachaMapper mapper1 = sqlSession1.getMapper(CachaMapper.class);
            Emp emp1 = mapper1.getEmpById(1);
            System.out.println(emp1);
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CachaMapper mapper2 = sqlSession2.getMapper(CachaMapper.class);
            Emp emp2 = mapper2.getEmpById(1);
            sqlSession2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
