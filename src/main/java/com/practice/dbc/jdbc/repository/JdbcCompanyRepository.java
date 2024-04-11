package com.practice.dbc.jdbc.repository;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.common.repository.CompanyRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcCompanyRepository implements CompanyRepository {

    private final JdbcTemplate jdbcTemplate;


    // 생성자가 딱 하나만 있으면 되므로 @Autowired 생략 가능
    public JdbcCompanyRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Company save(Company company) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("company")
                .usingGeneratedKeyColumns("no");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", company.getName());
        parameters.put("city", company.getCity());
        parameters.put("country", company.getCountry());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        company.setNo(key.longValue());

        return company;
    }

    @Override
    public Optional<Company> findByNo(Long no) {
        List<Company> result = jdbcTemplate.query("SELECT * FROM COMPANY WHERE NO = ?", companyRowMapper(), no);
        return result.stream().findAny();
    }

    @Override
    public Optional<Company> findByName(String name) {
        List<Company> result = jdbcTemplate.query("SELECT * FROM COMPANY WHERE NAME = ?", companyRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Company> findAll() {
        return jdbcTemplate.query("SELECT * FROM COMPANY", companyRowMapper());
    }

    @Override
    public Integer countAll() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM COMPANY", Integer.class);
    }

    @Override
    public Company updateCompany(CompanyRequest companyRequest) {
        jdbcTemplate.update("UPDATE COMPANY SET NAME = ?, COUNTRY = ?, CITY = ? WHERE NO = ?",
                companyRequest.getName(), companyRequest.getCountry(), companyRequest.getCity(), companyRequest.getNo());

        return findByNo(companyRequest.getNo()).get();
    }

    @Override
    public Integer deleteByNo(Long no) {
        // 적용된 row 개수를 반환
        return jdbcTemplate.update("DELETE FROM COMPANY WHERE NO = ?", no);
    }

    private RowMapper<Company> companyRowMapper() {
        // Lambda Expression으로 변경 가능
        // 익명 클래스로 정의해 사용 (일회용)
        // 인터페이스로 선언한 익명 구현 객체만 람다식으로 표현 가능
        // 람다 표현이 가능한 인터페이스를 '함수형 인터페이스'라고 부름
        // 함수형 인터페이스 : 딱 하나의 추상 메소드가 선언된 인터페이스
        return new RowMapper<Company>() {
            @Override
            public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
                Company company = new Company();
                company.setNo(rs.getLong("no"));
                company.setName(rs.getString("name"));
                company.setCity(rs.getString("city"));
                company.setCountry(rs.getString("country"));
                return company;
            }
        };
    }
}
