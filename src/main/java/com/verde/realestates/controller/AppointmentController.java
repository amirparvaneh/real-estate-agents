package com.verde.realestates.controller;


import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.dto.response.AppointmentResDto;
import com.verde.realestates.dto.response.BaseResponse;
import com.verde.realestates.externalapi.dto.PostcodeResponse;
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

    @GetMapping(value = "/validate-postcode/{postcode}")
    public ResponseEntity<BaseResponse<PostcodeResponse>> getPostCode(@PathVariable String postcode){
        PostcodeResponse postCodeResponse = postcodeService.callExternalPostcode(postcode);
        BaseResponse<PostcodeResponse> response = BaseResponse.<PostcodeResponse>builder()
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
