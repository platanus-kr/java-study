package com.example.mybatis_02;

import lombok.Data;

import java.util.List;

@Data
public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList;
}
