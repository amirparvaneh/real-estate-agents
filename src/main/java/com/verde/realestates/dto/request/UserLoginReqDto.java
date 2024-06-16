package com.verde.realestates.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginReqDto implements Serializable {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
