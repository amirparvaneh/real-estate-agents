package com.verde.realestates.global;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private Object[] params;
}
