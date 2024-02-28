package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    /**
     * MyBatis的各种查询功能：
     * 1、若查询出的数据只有一条
     * 1.1、可以通过实体类对象接收
     * 1.2、可以通过集合接收
     * 1.3、可以通过Map结合接收
     * 结果：{password=123456, sex=男, id=1, age=23, email=12345@qq.com, username=admin}
     * 2、若查询出的数据有多条
     * 2.1、可以通过实体类型的List集合接收
     * 2.2、可以通过Map类型的list集合接收
     * 2.3、可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换为map集合
     * ，以某个字段的值作为key,放在同一个map集合中
     * 注意：一定不能通实体类对象接收，此时会抛异常TooManyResultException
     * MyBatis中设置了默认的类型别名
     * 例如：java.lang.Integer 的别名 int,integer
     *  int -->_int, _integer
     *  Map--> map
     */
    @Test
    public void testGetAllUserToMap2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> allUserToMap2 = mapper.getAllUserToMap2();
        System.out.println(allUserToMap2);
    }
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(1);
        System.out.println(userByIdToMap);
    }
    @Test
    public void testGetUserCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count= mapper.getUserCount();
        System.out.println(count);
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        System.out.println(list);
    }
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
    }
}
