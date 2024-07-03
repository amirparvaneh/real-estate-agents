package com.verde.realestates.service;

import com.verde.realestates.model.Customer;

public interface CustomerService {
    Customer findCustomerByEmail(String email);
}
