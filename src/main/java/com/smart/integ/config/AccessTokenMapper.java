package com.smart.integ.config;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccessTokenMapper {
    private String access_token;
    private Integer id;
    private String status;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private List<String> authorities = new ArrayList<>();
}
