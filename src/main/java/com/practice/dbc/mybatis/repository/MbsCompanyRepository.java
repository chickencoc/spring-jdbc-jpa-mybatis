package com.practice.dbc.mybatis.repository;

import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.common.repository.CompanyRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MbsCompanyRepository extends CompanyRepository {
    @Override
    Integer save(CompanyRequest companyRequest);

    @Override
    Integer updateCompany(CompanyRequest companyRequest);
}
