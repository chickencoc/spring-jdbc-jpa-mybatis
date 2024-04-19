package com.practice.dbc.jpa.repository;

import com.practice.dbc.common.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByNo(Long no);
    Optional<Company> findByName(String name);
}
