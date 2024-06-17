package com.verde.realestates.service;

import com.verde.realestates.dto.request.AppointmentReqDto;
import com.verde.realestates.dto.response.AppointmentResDto;
import com.verde.realestates.model.Appointment;

import java.util.List;


public interface AppointmentService {
    AppointmentResDto addNewAppointment(AppointmentReqDto appointmentDto);
    List<Appointment> getAllAppointment();
}
