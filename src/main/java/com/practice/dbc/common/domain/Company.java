package com.practice.dbc.common.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {

    @Id
    private Long no;
    private String name;
    private String country;
    private String city;

}
