package com.practice.dbc.jdbc.controller;

import com.practice.dbc.common.controller.CompanyController;
import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.jdbc.service.JdbcCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jdbc")
public class JdbcCompanyController implements CompanyController {

    private final JdbcCompanyService jdbcCompanyService;

    @Override
    public ResponseEntity<Company> save(Company company) {
        return ResponseEntity.ok(jdbcCompanyService.save(company));
    }

    @Override
    public ResponseEntity<Company> findByNo(Long no) {
        return ResponseEntity.ok(jdbcCompanyService.findByNo(no));
    }

    @Override
    public ResponseEntity<Company> findByName(String name) {
        return ResponseEntity.ok(jdbcCompanyService.findByName(name));
    }

    @Override
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(jdbcCompanyService.findAll());
    }

    @Override
    public ResponseEntity<Integer> countAll() {
        return ResponseEntity.ok(jdbcCompanyService.countAll());
    }

    @Override
    public ResponseEntity<Company> updateCompany(CompanyRequest companyRequest) {
        return ResponseEntity.ok(jdbcCompanyService.updateCompany(companyRequest));
    }

    @Override
    public ResponseEntity<Integer> deleteByNo(Long no) {
        return ResponseEntity.ok(jdbcCompanyService.deleteByNo(no));
    }
}
