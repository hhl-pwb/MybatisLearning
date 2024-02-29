package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    Dept getEmpAndDeptStepTwo(@Param("did") Integer did);

    /**
     * 查询部门里的员工信息，使用collect标签
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分步查询--查询部门及部门中所有的员工信息
     * 分步查询的第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") String did);
}
