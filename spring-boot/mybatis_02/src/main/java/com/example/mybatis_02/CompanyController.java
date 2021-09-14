package com.example.mybatis_02;

import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company post(@RequestBody Company company){
        companyMapper.insert(company);
        return company;
    }

    @GetMapping
    public List<Company> getAll(){
//        return companyService.getAll();
        return companyMapper.getAll();
    }

    @GetMapping("/{id}")
    public Company getBtId(@PathVariable("id") int id){
        return companyMapper.getById(id);
    }

}
