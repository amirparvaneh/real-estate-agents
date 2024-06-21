package com.verde.realestates.externalapi;


import com.verde.realestates.externalapi.dto.PostCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "postalCodeService", url = "${uk.postcode.api.url}")
public interface FeignPostcode {

    @GetMapping(value = "/{postcode}")
    PostCodeResponse getPostalCode(@PathVariable(value = "postcode") String postcode);
}
