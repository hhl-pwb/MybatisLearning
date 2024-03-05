package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 条件查询
     * @param emp
     * @return
     */
    List<Emp> getEmpList(Emp emp);
    /**
     * 条件查询 choose when otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量删除 foreach
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);
    /**
     * 通过list集合添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
