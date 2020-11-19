package com.zackvalentine.customerkeeper.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService = new CustomerServiceImpl();

    @CrossOrigin
    @GetMapping
    public Iterable<Customer> findAll() {
        return customerService.findAll();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer) {
        System.out.println(customer.toString());
        if (customer.getId() == null) {
            customer.setId(UUID.randomUUID());
        }
        System.out.println(customer.toString());
        Customer createdCustomer = customerService.create(customer);
        return new ResponseEntity(createdCustomer, HttpStatus.CREATED);
    }
}
