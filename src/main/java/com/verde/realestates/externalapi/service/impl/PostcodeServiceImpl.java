package com.verde.realestates.externalapi.service.impl;

import com.verde.realestates.externalapi.FeignPostcode;
import com.verde.realestates.externalapi.dto.PostCodeResponse;
import com.verde.realestates.externalapi.service.PostcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostcodeServiceImpl implements PostcodeService {

    private final FeignPostcode feignPostcode;

    @Override
    public PostCodeResponse callExternalPostcode(String postcode) {
        return feignPostcode.getPostalCode(postcode);
    }
}
