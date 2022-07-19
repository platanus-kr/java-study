package com.example.mybatis_01;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("")
    public Employee post(@RequestBody Employee employee){
        employeeMapper.insert(employee);
        return employee;
    }

    @GetMapping("")
    public List<Employee> getAll(){
        return employeeMapper.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id){
        return employeeMapper.getById(id);
    }
}
