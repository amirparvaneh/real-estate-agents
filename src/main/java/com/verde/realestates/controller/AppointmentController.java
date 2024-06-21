package com.verde.realestates.controller;


import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.dto.response.AppointmentResDto;
import com.verde.realestates.dto.response.BaseResponse;
import com.verde.realestates.externalapi.dto.PostCodeResponse;
import com.verde.realestates.externalapi.service.PostcodeService;
import com.verde.realestates.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PostcodeService postcodeService;

    @PostMapping
    public ResponseEntity<BaseResponse<AppointmentResDto>> addNewAppointment(@RequestBody AppointmentReqDto appointmentReqDto) {
        AppointmentResDto appointmentResDto = appointmentService.addNewAppointment(appointmentReqDto);
        BaseResponse<AppointmentResDto> response = BaseResponse.<AppointmentResDto>builder()
                .message("appointment created successfully")
                .result(appointmentResDto)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/validate-postcode/{postcode}")
    public ResponseEntity<BaseResponse<PostCodeResponse>> getPostCode(@PathVariable String postcode){
        PostCodeResponse postCodeResponse = postcodeService.callExternalPostcode(postcode);
        BaseResponse<PostCodeResponse> response = BaseResponse.<PostCodeResponse>builder()
                .message("return response of postcode")
                .result(postCodeResponse)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<AppointmentResDto>> getAllAppointment() {
        return ResponseEntity.ok(appointmentService.getAllAppointment());
    }
}
