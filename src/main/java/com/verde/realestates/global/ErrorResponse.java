package com.verde.realestates.global;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Data
@Builder
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private final Map<String, Object> errorDetail = new HashMap<>();
    @JsonIgnore
    private Object[] params;

    public ErrorResponse(String message, HttpStatus status, Object... params){
        this.message = message;
        this.status = status;
        if (Objects.nonNull(params)){
            setErrorDetail(params);
        }
    }


    public void setErrorDetail(Object... params) {
        for (Object param : params) {
            this.errorDetail.put("request input : ", String.valueOf(param));
        }
    }
}
