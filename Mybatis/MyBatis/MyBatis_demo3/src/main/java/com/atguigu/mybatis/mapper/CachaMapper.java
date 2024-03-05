package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CachaMapper {
    /**
     * 测试一级缓存
     */
    Emp getEmpById(@Param("eid") Integer eid);
}
