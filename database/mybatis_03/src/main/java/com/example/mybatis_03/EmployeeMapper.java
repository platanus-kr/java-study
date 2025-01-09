package com.example.mybatis_03;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
//    @Insert("INSERT INTO employee(company_id, employee_name, employee_address) VALUES(#{employee.companyId}, #{employee.name}, #{employee.address})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("employee") Employee employee);

//    @Select("SELECT * FROM employee")
//    @Results(id = "EmployeeMap", value = {
//            @Result(property = "companyId", column = "company_id"),
//            @Result(property = "name", column = "employee_name"),
//            @Result(property = "address", column = "employee_address")
//    })
    List<Employee> getAll();

//    @Select("SELECT * FROM employee WHERE id=#{id}")
//    @ResultMap("EmployeeMap")
    Employee getById(@Param("id") int id);

//    @Select("SELECT * FROM employee WHERE company_id=#{companyId}")
//    @ResultMap("EmployeeMap")
    List<Employee> getByCompanyId(@Param("companyId") int companyId);
}
