package com.practice.dbc.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

    private Long no;
    @NotBlank(message = "빈값 안됨")
    @Size(max = 5, message = "5자 이하")
    private String name;
    @NotBlank(message = "빈값 안됨")
    private String country;
    @NotBlank(message = "빈값 안됨")
    private String city;
    // @Pattern (regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8.20}", message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8 ~20자의 비밀번호여야 합니다.")

}
