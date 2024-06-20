package com.verde.realestates.externalapi;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "postalCodeService", url = "${uk.postcode.api.url}")
public interface PostCodeService {
}
