package com.zackvalentine.customerkeeper.customer;

import com.zackvalentine.customerkeeper.util.CustomerBuilder;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.UUID;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;

@RunWith(EasyMockRunner.class)
public class CustomerControllerTest extends EasyMockSupport {
    @Mock
    private CustomerService customerService = new CustomerServiceImpl();

    @TestSubject
    private CustomerController customerController = new CustomerController();

    @Test
    public void findAll() {
        Customer firstCustomer = new Customer();
        Customer secondCustomer = new Customer();
        Iterable<Customer> customers = Arrays.asList(firstCustomer, secondCustomer);
        expect(customerService.findAll()).andReturn(customers);
        replayAll();

        assertThat(customerController.findAll(), is(equalTo(customers)));
        verifyAll();
    }

    @Test
    public void create() {
        Customer customer = new CustomerBuilder()
                .withId(UUID.randomUUID())
                .withFirstName("Test")
                .withLastName("Customer")
                .build();
        expect(customerService.create(customer)).andReturn(customer);
        replayAll();

        ResponseEntity<Customer> response = customerController.create(customer);

        assertThat(response.getStatusCodeValue(), is(equalTo(201)));
        assertThat(response.getBody(), is(equalTo(customer)));
        verifyAll();
    }

    @Test
    public void givenCustomerWithNullId_whenCalled_thenGeneratesId() {
        Customer customerWithoutId = new CustomerBuilder()
                .withFirstName("Unidentified")
                .withLastName("Customer")
                .withId(null)
                .build();
        Customer expectedCustomer = new CustomerBuilder()
                .withId(UUID.randomUUID())
                .withFirstName(customerWithoutId.getFirstName())
                .withLastName(customerWithoutId.getLastName())
                .build();
        expect(customerService.create(customerWithoutId)).andReturn(expectedCustomer);
        replayAll();

        ResponseEntity<Customer> response = customerController.create(customerWithoutId);

        assertThat(response.getBody().getId(), is(notNullValue()));
        assertThat(response.getStatusCodeValue(), is(equalTo(201)));
        verifyAll();
    }
}
