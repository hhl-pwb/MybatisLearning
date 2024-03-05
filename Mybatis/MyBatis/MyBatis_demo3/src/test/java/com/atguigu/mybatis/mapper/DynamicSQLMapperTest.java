package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    /**
     * MyBatis动态sql
     * 1、if：根据标签中的test属性所对应的表达式决定标签中的内容是否需要拼接到sql中
     * 2、weher
     *  当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and 或 or去掉
     *  当where标签中没有内容时，此时where标签没有任何效果
     *  注意：where标签不能将其中内容后对于的and 或 or去掉
     *  3、trim
     *  若标签中有内容时：
     *  prefix、suffix:将trim标签中内容前面或后面添加指定内容
     *  prefixOverrides、suffixOverides：将trim标签中内容前面或者后面去掉指定内容
     *  若标签中没有内容时:trim标签也没有任何效果
     *  4、choose、when 、otherwise 相当于java中的 if....else if ... else
     *  when至少要有一个，otherwise至多智能有一个
     *  5、froeach
     *  collection：设置需要循环的数组或集合
     *  item：表示属猪或集合中的每一个数据
     *  separator：循环体之江的分割符
     *  open:foreach标签所循环的所有内容的开始符
     *  close:foreach标签所循环的所有内容的结束符
     *  6、sql标签
     * 设置sql片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用sql片段：<include refid="empColumns"></include>
     *
     */
    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp2 = new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp3 = new Emp(null,"a1",23,"男","123@qq.com");
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        int i = mapper.insertMoreByList(list);
        System.out.println(i);
    }
   @Test
   public void testDeleteMoreByArray(){
       SqlSession sqlSession = SqlSessionUtils.getSqlSession();
       DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
       int i = mapper.deleteMoreByArray(new Integer[]{6, 7, 8, 9});
       System.out.println(i);
   }
    @Test
    public void testGetAllEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "张三"
                , 23, null, null));
        System.out.println(list);
    }
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpList(new Emp(null, "张三"
                 , 23, null, null));
        System.out.println(empList);
    }
}
