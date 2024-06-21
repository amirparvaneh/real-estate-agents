package com.verde.realestates.externalapi.service;

import com.verde.realestates.externalapi.dto.PostcodeResponse;

public interface PostcodeService {
    PostcodeResponse callExternalPostcode(String postcode);
}
