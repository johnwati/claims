package com.finaccess.groboxcooperative.infrastructure.exception;

import lombok.Data;

@Data
public class ApiErrorDesc {
    private String error, error_description, message;
}