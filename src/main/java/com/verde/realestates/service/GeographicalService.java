package com.verde.realestates.service;

import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.externalapi.dto.PostcodeResponse;

public interface GeographicalService {
    PostcodeResponse getRealtorLocation();
    void checkPostcode(AppointmentReqDto appointmentReqDto);
    Long getDistanceToOffice(String appointmentPostcode);
}
