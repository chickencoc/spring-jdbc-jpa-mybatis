package com.practice.dbc.jdbc.service;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.common.repository.CompanyRepository;
import com.practice.dbc.common.service.CompanyService;
import com.practice.dbc.jdbc.repository.JdbcCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JdbcCompanyService implements CompanyService {

    private final JdbcCompanyRepository jdbcCompanyRepository;

    @Override
    public Company save(CompanyRequest companyRequest) {
        return jdbcCompanyRepository.save(companyRequest);
    }

    @Override
    public Company findByNo(Long no) {
        return jdbcCompanyRepository.findByNo(no).orElseGet(Company::new);
    }

    @Override
    public Company findByName(String name) {
        return jdbcCompanyRepository.findByName(name).orElseGet(Company::new);
    }

    @Override
    public List<Company> findAll() {
        return jdbcCompanyRepository.findAll();
    }

    @Override
    public Integer countAll() {
        return jdbcCompanyRepository.countAll();
    }

    @Override
    public Company updateCompany(CompanyRequest companyRequest) {
        return jdbcCompanyRepository.updateCompany(companyRequest);
    }

    @Override
    public Integer deleteByNo(Long no) {
        return jdbcCompanyRepository.deleteByNo(no);
    }
}
