package com.verde.realestates.externalapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCode {
    private String postcode;
    private String country;
    private Float longitude;
    private Float latitude;
    private String region;
}
