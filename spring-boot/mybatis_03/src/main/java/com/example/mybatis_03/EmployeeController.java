package com.example.mybatis_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping
    public Employee post(@RequestBody Employee employee){
        employeeMapper.insert(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeMapper.getAll();
    }

    @GetMapping("/{id}")
    public Employee getBtId(@PathVariable("id") int id){
        return employeeMapper.getById(id);
    }
}
