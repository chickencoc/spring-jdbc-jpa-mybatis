package com.practice.dbc.jpa.service;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.common.service.CompanyService;
import com.practice.dbc.jpa.repository.JpaCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaCompanyService implements CompanyService {

    private final JpaCompanyRepository jpaCompanyRepository;

    @Override
    public Company save(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setCity(companyRequest.getCity());
        company.setCountry(companyRequest.getCountry());
        return jpaCompanyRepository.save(company);
    }

    @Override
    public Company findByNo(Long no) {
        return jpaCompanyRepository.findByNo(no).orElseGet(Company::new);
    }

    @Override
    public Company findByName(String name) {
        return jpaCompanyRepository.findByName(name).orElseGet(Company::new);
    }

    @Override
    public List<Company> findAll() {
        return jpaCompanyRepository.findAll();
    }

    @Override
    public Integer countAll() {
        return (int) jpaCompanyRepository.count();
    }

    @Override
    public Company updateCompany(CompanyRequest companyRequest) {

        Optional<Company> optionalCompany = jpaCompanyRepository.findByNo(companyRequest.getNo());

        Company company = optionalCompany.orElseThrow(() -> new IllegalArgumentException("Cant find Company :: " + companyRequest.getNo()));
        company.setName(companyRequest.getName());
        company.setCity(companyRequest.getCity());
        company.setCountry(companyRequest.getCountry());

        return company;
    }

    @Override
    public Integer deleteByNo(Long no) {
        jpaCompanyRepository.deleteById(no);
        return 1;
    }
}
