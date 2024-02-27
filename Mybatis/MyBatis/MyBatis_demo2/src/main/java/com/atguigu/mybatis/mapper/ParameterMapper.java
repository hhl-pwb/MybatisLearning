package com.atguigu.mybatis.mapper;


import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ParameterMapper {

    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
    int insertUser(User user);
    User checkLoginByMap(Map<String, Object> map);
    User checkLogin(String username,String password);
    /**
     * 通过用户名称获取用户信息
     */
    User getUserByUsername(String username);
    /**
     * 查询所有的员工
     */
    List<User> getAllUser();

}
