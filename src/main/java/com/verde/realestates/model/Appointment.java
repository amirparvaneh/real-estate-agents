package com.verde.realestates.model;


import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment extends BaseEntity{
    private Integer duration;
    private Address address;
}
