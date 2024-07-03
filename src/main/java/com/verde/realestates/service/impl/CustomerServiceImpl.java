package com.verde.realestates.service.impl;

import com.verde.realestates.model.Customer;
import com.verde.realestates.repository.CustomerRepository;
import com.verde.realestates.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findCustomerByEmail(String email) {
        return null;
    }
}
