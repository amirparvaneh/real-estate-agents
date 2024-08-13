package com.verde.realestates.service.impl;


import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.exceptions.ExternalApiCallException;
import com.verde.realestates.externalapi.FeignPostcode;
import com.verde.realestates.externalapi.dto.PostcodeResponse;
import com.verde.realestates.service.GeographicalService;
import com.verde.realestates.service.ValidationPostcode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeographicalServiceImpl implements GeographicalService {

    private final ValidationPostcode validationPostcode;
    private final FeignPostcode feignPostcode;

    @Value("${realtor.postcode}")
    private String realtorPostCode;

    @Override
    public PostcodeResponse getRealtorLocation() {
        try {
            return feignPostcode.getRealtorLocation(realtorPostCode);
        } catch (Exception e) {
            throw new ExternalApiCallException(realtorPostCode);
        }
    }

    @Override
    public void checkPostcode(AppointmentReqDto appointmentReqDto) {
        validationPostcode.checkPostcode(appointmentReqDto.getUserPostalCode());
        validationPostcode.checkPostcode(appointmentReqDto.getAppointmentPostalCode());
    }

    @Override
    public Long getDistanceToOffice(String appointmentPostcode) {
        PostcodeResponse appointmentLocation;
        PostcodeResponse realtorLocation = getRealtorLocation();
        try {
            appointmentLocation = feignPostcode.getPostalCode(appointmentPostcode);
        } catch (Exception e) {
            throw new ExternalApiCallException(appointmentPostcode);
        }
    }


}
