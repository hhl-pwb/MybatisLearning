package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致：
     * 1、映射文件的namespace要和mapper接口的全类名保持一致
     * 2、映射文件中的sql语句的id要和mapper接口中的方法名一致
     */
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void delteUser();

    /**
     * 查询客户信息
     *
     * @return
     */
    User selectUserById();

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
}
