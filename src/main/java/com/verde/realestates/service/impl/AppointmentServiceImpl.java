package com.verde.realestates.service.impl;


import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.dto.response.AppointmentResDto;
import com.verde.realestates.mapper.AppointmentMapper;
import com.verde.realestates.model.Customer;
import com.verde.realestates.model.User;
import com.verde.realestates.repository.AppointmentRepository;
import com.verde.realestates.service.AppointmentService;
import com.verde.realestates.service.UserService;
import com.verde.realestates.service.ValidationPostcode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ValidationPostcode validationPostcode;
    private final UserService userService;

    @Override
    public AppointmentResDto addNewAppointment(AppointmentReqDto appointmentReqDto) {

        User user = appointmentReqDto.getUserEmail();
        Customer customer = appointmentReqDto.getCustomerEmail();
        validationPostcode.checkPostcode(appointmentReqDto.getAppointmentPostalCode());
        validationPostcode.checkPostcode(appointmentReqDto.getUserPostalCode());
    }

    @Override
    public List<AppointmentResDto> getAllAppointment() {
        return AppointmentMapper.INSTANCE.listOfAppointmentToListOfAppointmentResDto(appointmentRepository.findAll());
    }
}
