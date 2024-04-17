package com.practice.dbc.common.repository;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Object save(CompanyRequest companyRequest);
    Optional<Company> findByNo(Long no);
    Optional<Company> findByName(String name);
    List<Company> findAll();
    Integer countAll();
    Object updateCompany(CompanyRequest companyRequest);
    Integer deleteByNo(Long no);
}