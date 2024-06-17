package com.verde.realestates.service.impl;


import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.dto.response.AppointmentResDto;
import com.verde.realestates.mapper.AppointmentMapper;
import com.verde.realestates.model.Appointment;
import com.verde.realestates.repository.AppointmentRepository;
import com.verde.realestates.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public AppointmentResDto addNewAppointment(AppointmentReqDto appointmentReqDto) {
        Appointment appointment = AppointmentMapper.INSTANCE.appointmentReqDtoToAppointment(appointmentReqDto);
        Appointment addedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.INSTANCE.appointmentToAppointmentResDto(addedAppointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }
}
