package com.verde.realestates.exceptions;

import com.verde.realestates.global.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ExternalApiCallException extends BusinessException{

    public ExternalApiCallException(String postcode){
        super(new ErrorResponse(
                "calling the api is confront with error",
                HttpStatus.CONFLICT,
                postcode
        ));
    }
}
