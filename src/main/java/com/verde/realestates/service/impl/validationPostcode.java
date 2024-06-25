package com.verde.realestates.service.impl;

import com.verde.realestates.exceptions.ExternalApiCallException;
import com.verde.realestates.externalapi.FeignPostcode;
import com.verde.realestates.service.ValidationPostcode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class validationPostcode implements ValidationPostcode {

    private final FeignPostcode feignPostcode;

    @Override
    public void checkPostcode(String postcode) {
        try {
            feignPostcode.getPostalCode(postcode);
        } catch (Exception e) {
            throw new ExternalApiCallException(postcode);
        }
    }
}
