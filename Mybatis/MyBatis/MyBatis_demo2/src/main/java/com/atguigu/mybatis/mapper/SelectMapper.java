package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface SelectMapper {
    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);
    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户总数
     */
    Integer getUserCount();

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);
    /**
     * 查询所有数据
     */
    List<Map<String ,Object>> getAllUserToMap();

    /**
     * 通过@MapKey查询所有用户信息
     * @mapKey中的value值必须是唯一的
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap2();
}
