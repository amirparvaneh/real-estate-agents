package com.verde.realestates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RealestatesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealestatesApplication.class, args);
    }

}
