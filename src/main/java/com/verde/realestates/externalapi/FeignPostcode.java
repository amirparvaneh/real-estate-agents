package com.verde.realestates.externalapi;


import com.verde.realestates.externalapi.dto.PostcodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "postalCodeService", url = "${uk.postcode.api.url}")
public interface FeignPostcode {

    @GetMapping(value = "/{postcode}")
    PostcodeResponse getPostalCode(@PathVariable(value = "postcode") String postcode);

    @GetMapping(value = "/{realtor}")
    PostcodeResponse getRealtorLocation(@PathVariable(value = "realtor") String realtor);
}
