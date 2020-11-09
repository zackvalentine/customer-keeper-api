package com.zackvalentine.customerkeeper.customer;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @CrossOrigin
    @GetMapping
    public Iterable<Customer> findAll() {
        Customer customer = new Customer();
        customer.setId(UUID.fromString("df5b5b2e-86a5-40da-a555-0f18a8bdce93"));
        return Collections.singletonList(customer);
    }
}
