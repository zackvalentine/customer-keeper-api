package com.zackvalentine.customerkeeper.customer;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void getId() {
        Customer customer = new Customer();
        UUID customerId = UUID.randomUUID();
        customer.setId(customerId);
        assertThat(customer.getId(), is(equalTo(customerId)));
    }

    @Test
    public void getFirstName() {
        Customer customer = new Customer();
        customer.setFirstName("Test");
        assertThat(customer.getFirstName(), is(equalTo("Test")));
    }

    @Test
    public void getLastName() {
        Customer customer = new Customer();
        customer.setLastName("Customer");
        assertThat(customer.getLastName(), is(equalTo("Customer")));
    }

    @Test
    public void equalsReturnsTrueIfAllFieldsMatch() {
        UUID randomId = UUID.randomUUID();
        Customer firstCustomer = new Customer();
        firstCustomer.setId(randomId);
        firstCustomer.setFirstName("Test");
        firstCustomer.setLastName("Customer");
        Customer secondCustomer = new Customer();
        secondCustomer.setId(randomId);
        secondCustomer.setFirstName("Test");
        secondCustomer.setLastName("Customer");

        assertThat(firstCustomer.equals(secondCustomer), is(true));
    }

    @Test
    public void equalsReturnsFalseIfIdDoesNotMatch() {
        Customer firstCustomer = new Customer();
        firstCustomer.setId(UUID.randomUUID());
        firstCustomer.setFirstName("Test");
        firstCustomer.setLastName("Customer");
        Customer secondCustomer = new Customer();
        secondCustomer.setId(UUID.randomUUID());
        secondCustomer.setFirstName("Test");
        secondCustomer.setLastName("Customer");

        assertThat(firstCustomer.equals(secondCustomer), is(false));
    }
}
