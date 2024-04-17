package com.practice.dbc.config;

import com.practice.dbc.jdbc.repository.JdbcCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

    private final DataSource dataSource;

    @Bean
    public JdbcCompanyRepository jdbcCompanyRepository() {
        return new JdbcCompanyRepository(dataSource);
    }
}
