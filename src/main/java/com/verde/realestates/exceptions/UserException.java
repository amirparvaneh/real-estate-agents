package com.verde.realestates.exceptions;

import com.verde.realestates.global.ErrorResponse;
import org.springframework.http.HttpStatus;

public class UserException extends BusinessException{

    public UserException(String message,String userName){
        super(new ErrorResponse(
                message,
                HttpStatus.NOT_FOUND,
                userName
        ));
    }
}
