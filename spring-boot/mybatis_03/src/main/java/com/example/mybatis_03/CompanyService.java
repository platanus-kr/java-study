package com.example.mybatis_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Company> getAll(){
        List<Company> companyList = companyMapper.getAll();
        if (companyList != null && companyList.size() > 0){
            for(Company company : companyList){
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
            }
        }
        return companyList;
    }

    @Transactional(rollbackFor = Exception.class)
    public Company add(Company company){
        companyMapper.insert(company);
        if (true){
            throw new RuntimeException("LegacyException");
        }
        return company;
    }
}
