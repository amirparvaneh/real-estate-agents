package com.verde.realestates.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String email;
    private String name;
    private String address;
    private String phoneNo;
}
