package com.verde.realestates.externalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostcodeResponse {
    private Integer status;
    private List<PostCode> result;
}
