package com.practice.dbc.common.service;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;

import java.util.List;

public interface CompanyService {
    Company save(Company company);
    Company findByNo(Long no);
    Company findByName(String name);
    List<Company> findAll();
    Integer countAll();
    Company updateCompany(CompanyRequest companyRequest);
    Integer deleteByNo(Long no);
}
