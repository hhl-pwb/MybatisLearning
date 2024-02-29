import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致情况：
     * 1、为字段起别名，保持和属性名的一致
     * 2、设置全局配置,将 _ 自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * 3、使用resultMap设置自定义的映射关系
     *   <resultMap id="empResultMap" type="Emp">
     *         <!--使用 id标签设置主键映射关系-->
     *         <id property="eid" column="eid"/>
     *         <!--使用result设置普通字段映射关系-->
     *         <result property="empName" column="emp_name"/>
     *         <result property="age" column="age"/>
     *         <result property="sex" column="sex"/>
     *         <result property="email" column="email"/>
     *     </resultMap>
     *
     * 处理多对一关系
     * 1、级联属性赋值
     * 2、使用association
     * 3、分步查询
     *处理一对多关系
     * 1、collection
     * 2、分步查询
     */
    @Test
    public void testGetDepAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(deptAndEmp);
    }
    @Test
    public void testDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }
    @Test
    public void testEmpAndDeptStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDeptStepOne = mapper.getEmpAndDeptStepOne(1);
        System.out.println(empAndDeptStepOne.getEmpName());
        System.out.println("===============================");
        System.out.println(empAndDeptStepOne.getDept());
    }
    @Test
    public void testEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
    }
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(System.out::println);
    }
}
