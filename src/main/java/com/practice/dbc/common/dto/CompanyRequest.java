package com.practice.dbc.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

    private Long no;
    private String name;
    private String country;
    private String city;

}
