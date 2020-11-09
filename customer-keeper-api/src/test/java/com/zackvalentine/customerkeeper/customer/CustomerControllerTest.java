package com.zackvalentine.customerkeeper.customer;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.UUID;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;

@RunWith(EasyMockRunner.class)
public class CustomerControllerTest extends EasyMockSupport {
    @TestSubject
    private CustomerController customerController = new CustomerController();

    @Test
    public void findAll() {
        Customer customer = new Customer();
        customer.setId(UUID.fromString("df5b5b2e-86a5-40da-a555-0f18a8bdce93"));
        Iterable<Customer> expected = Collections.singletonList(customer);

        assertThat(customerController.findAll(), is(equalTo(expected)));
    }
}
