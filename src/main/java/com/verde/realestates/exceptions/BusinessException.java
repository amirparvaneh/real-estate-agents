package com.verde.realestates.exceptions;

import com.verde.realestates.global.ErrorResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class BusinessException extends RuntimeException{
    private ErrorResponse errorResponse;


    public BusinessException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }
}
