package com.verde.realestates.externalapi.service;

import com.verde.realestates.externalapi.dto.PostCodeResponse;

public interface PostcodeService {
    PostCodeResponse callExternalPostcode(String postcode);
}
