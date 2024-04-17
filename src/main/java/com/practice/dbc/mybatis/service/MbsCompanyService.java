package com.practice.dbc.mybatis.service;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.common.service.CompanyService;
import com.practice.dbc.mybatis.repository.MbsCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MbsCompanyService implements CompanyService {

    private final MbsCompanyRepository mbsCompanyRepository;

    @Override
    public Company save(CompanyRequest companyRequest) {
        mbsCompanyRepository.save(companyRequest);

        Company company = new Company();
        company.setNo(companyRequest.getNo());
        company.setName(companyRequest.getName());
        company.setCity(companyRequest.getCity());
        company.setCountry(companyRequest.getCountry());
        return company;
    }

    @Override
    public Company findByNo(Long no) {
        return mbsCompanyRepository.findByNo(no).orElseGet(Company::new);
    }

    @Override
    public Company findByName(String name) {
        return mbsCompanyRepository.findByName(name).orElseGet(Company::new);
    }

    @Override
    public List<Company> findAll() {
        return mbsCompanyRepository.findAll();
    }

    @Override
    public Integer countAll() {
        return mbsCompanyRepository.countAll();
    }

    @Override
    public Company updateCompany(CompanyRequest companyRequest) {
        mbsCompanyRepository.updateCompany(companyRequest);
        return mbsCompanyRepository.findByNo(companyRequest.getNo()).get();
    }

    @Override
    public Integer deleteByNo(Long no) {
        return mbsCompanyRepository.deleteByNo(no);
    }
}
