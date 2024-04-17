package com.practice.dbc.mybatis.controller;

import com.practice.dbc.common.controller.CompanyController;
import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.mybatis.service.MbsCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mybatis")
public class MbsCompanyController implements CompanyController {

    private final MbsCompanyService mbsCompanyService;

    @Override
    public ResponseEntity<Company> save(CompanyRequest companyRequest) {
        return ResponseEntity.ok(mbsCompanyService.save(companyRequest));
    }

    @Override
    public ResponseEntity<Company> findByNo(Long no) {
        return ResponseEntity.ok(mbsCompanyService.findByNo(no));
    }

    @Override
    public ResponseEntity<Company> findByName(String name) {
        return ResponseEntity.ok(mbsCompanyService.findByName(name));
    }

    @Override
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(mbsCompanyService.findAll());
    }

    @Override
    public ResponseEntity<Integer> countAll() {
        return ResponseEntity.ok(mbsCompanyService.countAll());
    }

    @Override
    public ResponseEntity<Company> updateCompany(CompanyRequest companyRequest) {
        return ResponseEntity.ok(mbsCompanyService.updateCompany(companyRequest));
    }

    @Override
    public ResponseEntity<Integer> deleteByNo(Long no) {
        return ResponseEntity.ok(mbsCompanyService.deleteByNo(no));
    }
}
