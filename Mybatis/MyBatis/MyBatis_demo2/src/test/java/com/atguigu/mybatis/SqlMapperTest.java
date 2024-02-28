package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SqlMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SqlMapperTest {
    @Test
    public void testUserTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> t_user = mapper.getUserByTableName("t_user");
        System.out.println(t_user);
    }

    @Test
    public void testDeleteMoer() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        int res = mapper.deletMore("3,4,5");
        System.out.println(res);
    }

    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> a = mapper.getUserByList("a");
        System.out.println(a);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        User user = new User(null, "张三", "123", 34, "男", "123@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
