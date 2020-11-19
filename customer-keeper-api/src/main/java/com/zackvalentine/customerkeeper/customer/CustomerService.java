package com.zackvalentine.customerkeeper.customer;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Customer> findAll();

    Customer create(Customer customer);
}
