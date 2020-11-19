package com.zackvalentine.customerkeeper.util;

import com.zackvalentine.customerkeeper.customer.Customer;

import java.util.UUID;

public class CustomerBuilder {
    private UUID id;
    private String firstName;
    private String lastName;

    public CustomerBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        return customer;
    }
}
