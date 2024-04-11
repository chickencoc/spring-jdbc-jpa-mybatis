package com.practice.dbc.common.controller;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CompanyController {
    @PostMapping("/save")
    ResponseEntity<Company> save(@RequestBody Company company);

    @GetMapping("/find/id/{no}")
    ResponseEntity<Company> findByNo(@PathVariable Long no);

    @GetMapping("/find/name/{name}")
    ResponseEntity<Company> findByName(@PathVariable String name);

    @GetMapping("/list")
    ResponseEntity<List<Company>> findAll();

    @GetMapping("/count")
    ResponseEntity<Integer> countAll();

    @PutMapping("/update")
    ResponseEntity<Company> updateCompany(@RequestBody CompanyRequest companyRequest);

    @DeleteMapping("/delete/{no}")
    ResponseEntity<Integer> deleteByNo(@PathVariable Long no);
}
