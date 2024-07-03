package com.verde.realestates.service.impl;


import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.dto.response.AppointmentResDto;
import com.verde.realestates.externalapi.dto.PostcodeResponse;
import com.verde.realestates.mapper.AppointmentMapper;
import com.verde.realestates.model.Customer;
import com.verde.realestates.model.User;
import com.verde.realestates.repository.AppointmentRepository;
import com.verde.realestates.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final GeographicalService geographicalService;
    private final UserService userService;
    private final CustomerService customerService;

    @Override
    public AppointmentResDto addNewAppointment(AppointmentReqDto appointmentReqDto) {
        User user = userService.findUserByEmail(appointmentReqDto.getCustomerEmail());
        Customer customer = customerService.findCustomerByEmail(appointmentReqDto.getCustomerEmail());
        geographicalService.checkPostcode(appointmentReqDto);
        geographicalService.getDistanceToOffice(appointmentReqDto.getAppointmentPostalCode());
    }

    @Override
    public List<AppointmentResDto> getAllAppointment() {
        return AppointmentMapper.INSTANCE.listOfAppointmentToListOfAppointmentResDto(appointmentRepository.findAll());
    }
}
