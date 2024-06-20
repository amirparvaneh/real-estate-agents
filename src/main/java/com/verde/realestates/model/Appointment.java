package com.verde.realestates.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment extends BaseEntity {


    private String appointmentAddress;
    private String appointmentPostalCode;
    private LocalDateTime appointmentDate;
    private Long distanceToOffice;
    private LocalDateTime departureTime;
    private LocalDateTime returnTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
