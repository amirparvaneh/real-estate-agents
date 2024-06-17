package com.verde.realestates.model;


import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment extends BaseEntity {

    private final Integer duration = 1;
    private LocalDateTime date;
    private String address;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhoneNumber;
}
