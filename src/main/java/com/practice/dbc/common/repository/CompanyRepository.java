package com.practice.dbc.common.repository;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    Optional<Company> findByNo(Long no);
    Optional<Company> findByName(String name);
    List<Company> findAll();
    Integer countAll();
    Company updateCompany(CompanyRequest companyRequest);
    Integer deleteByNo(Long no);
}