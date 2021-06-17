package com.example.mybatis_01;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CompanyMapper {

    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    int insert(@Param("company") Company company);
    // 반환되는 결과는 입력된 갯수가 반환된다. 실패할 경우 0 반환.

    @Select("SELECT * FROM company")
    @Results({
        @Result(property="name", column="company_name"),
        @Result(property="address", column="compnay_address")
    }) // id의 경우는 자동으로 매핑이 된다.
    List<Company> getAll();
}
