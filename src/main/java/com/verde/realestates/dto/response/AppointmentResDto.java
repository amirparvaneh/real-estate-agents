package com.verde.realestates.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResDto implements Serializable {
    private LocalDateTime date;
    private String address;
    private String customerAddress;
    private String customerPhoneNumber;
}
