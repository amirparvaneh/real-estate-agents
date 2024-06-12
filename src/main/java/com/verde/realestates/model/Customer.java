package com.verde.realestates.model;


import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends BaseEntity{
    private String email;
    private String name;
    private String address;
    private String phoneNo;
}
