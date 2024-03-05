package com.atguigu.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Emp implements Serializable {

    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;

    private Dept dept;

    public Emp(Integer eid, String empName, Integer age, String sex, String email) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Emp() {
    }
}
