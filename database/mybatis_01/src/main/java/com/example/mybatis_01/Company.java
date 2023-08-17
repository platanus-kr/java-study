package com.example.mybatis_01;

import java.util.List;
import lombok.Data;

@Data
public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList;
}
