package com.smart.integ.infrastructure.exception;

import lombok.Data;

@Data
public class ApiErrorDesc {
    private String error, error_description, message;
}