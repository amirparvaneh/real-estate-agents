package com.verde.realestates.externalapi.service.impl;

import com.verde.realestates.exceptions.ExternalApiCallException;
import com.verde.realestates.externalapi.FeignPostcode;
import com.verde.realestates.externalapi.dto.PostcodeResponse;
import com.verde.realestates.externalapi.service.PostcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostcodeServiceImpl implements PostcodeService {

    private final FeignPostcode feignPostcode;

    @Override
    public PostcodeResponse callExternalPostcode(String postcode) {
        PostcodeResponse postcodeResponse ;
        try {
            postcodeResponse = feignPostcode.getPostalCode(postcode);
        }catch (Exception e){
            throw new ExternalApiCallException(postcode);
        }
        return postcodeResponse;
    }
}
