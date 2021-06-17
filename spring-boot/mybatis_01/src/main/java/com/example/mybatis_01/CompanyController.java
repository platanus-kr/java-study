package com.example.mybatis_01;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    @PostMapping("")
    public int post(@RequestBody Company company){
        return companyMapper.insert(company);
    }

    @GetMapping("")
    public List<Company> getAll(){
        return companyMapper.getAll();
    }
}
