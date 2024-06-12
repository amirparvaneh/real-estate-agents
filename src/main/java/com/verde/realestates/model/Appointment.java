package com.verde.realestates.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment extends BaseEntity{
    private Integer duration;
    private LocalDateTime date;
    @OneToOne
    @JoinColumn(name = "postalCodeId")
    private PostalCode postalCode;
}
