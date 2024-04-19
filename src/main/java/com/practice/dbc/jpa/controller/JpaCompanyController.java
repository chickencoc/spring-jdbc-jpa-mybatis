package com.practice.dbc.jpa.controller;

import com.practice.dbc.common.controller.CompanyController;
import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.jpa.service.JpaCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa")
public class JpaCompanyController implements CompanyController {

    private final JpaCompanyService jpaCompanyService;

    @Override
    public ResponseEntity<Company> save(CompanyRequest companyRequest) {
        return ResponseEntity.ok(jpaCompanyService.save(companyRequest));
    }

    @Override
    public ResponseEntity<Company> findByNo(Long no) {
        return ResponseEntity.ok(jpaCompanyService.findByNo(no));
    }

    @Override
    public ResponseEntity<Company> findByName(String name) {
        return ResponseEntity.ok(jpaCompanyService.findByName(name));
    }

    @Override
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(jpaCompanyService.findAll());
    }

    @Override
    public ResponseEntity<Integer> countAll() {
        return ResponseEntity.ok(jpaCompanyService.countAll());
    }

    @Override
    public ResponseEntity<Company> updateCompany(CompanyRequest companyRequest) {
        return ResponseEntity.ok(jpaCompanyService.updateCompany(companyRequest));
    }

    @Override
    public ResponseEntity<Integer> deleteByNo(Long no) {
        return ResponseEntity.ok(jpaCompanyService.deleteByNo(no));
    }
}
