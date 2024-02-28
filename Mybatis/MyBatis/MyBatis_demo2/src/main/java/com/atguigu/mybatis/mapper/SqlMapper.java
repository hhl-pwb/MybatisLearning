package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlMapper {
    /**
     * 模糊查询
     */
    List<User> getUserByList(@Param("username") String username);
    /**
     * 批量删除
     */
    int deletMore(@Param("ids") String ids);
    /**
     * 表名
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 获取自增主键
     */
    void insertUser(User user);

}
