package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicSQLMapperTest {
    /**
     * MyBatis动态sql
     * 1、if：根据标签中的test属性所对应的表达式决定标签中的内容是否需要拼接到sql中
     * 2、weher
     *  当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and 或 or去掉
     *  当where标签中没有内容时，此时where标签没有任何效果
     *  注意：where标签不能将其中内容后对于的and 或 or去掉
     */
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpList(new Emp(null, "张三"
                 , null, null, null));
        System.out.println(empList);
    }
}
