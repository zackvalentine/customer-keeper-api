package com.zackvalentine.customerkeeper.customer;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(EasyMockRunner.class)
public class CustomerServiceTest extends EasyMockSupport {
    @Mock
    private CustomerRepository customerRepository;
    
    @TestSubject
    private CustomerService customerService = new CustomerServiceImpl();

    @Test
    public void findAll() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        List<Customer> customers = Arrays.asList(customer1, customer2);
        expect(customerRepository.findAll()).andReturn(customers);
        replayAll();

        assertThat(customerService.findAll(), is(equalTo(customers)));
        verifyAll();
    }

    @Test
    public void create() {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setFirstName("Test");
        customer.setLastName("Customer");
        expect(customerRepository.save(customer)).andReturn(customer);
        replayAll();

        assertThat(customerService.create(customer), is(equalTo(customer)));
        verifyAll();
    }
}
