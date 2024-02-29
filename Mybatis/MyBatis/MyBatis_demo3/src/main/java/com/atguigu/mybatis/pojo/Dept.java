package com.atguigu.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    private Integer did;
    private String deptName;

    private List<Emp> emps;

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Dept() {
    }
}
