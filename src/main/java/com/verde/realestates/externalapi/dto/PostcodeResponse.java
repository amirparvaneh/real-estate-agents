package com.verde.realestates.externalapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostcodeResponse {
    @JsonProperty
    private Integer status;
    @JsonProperty
    private PostCode result;
}
