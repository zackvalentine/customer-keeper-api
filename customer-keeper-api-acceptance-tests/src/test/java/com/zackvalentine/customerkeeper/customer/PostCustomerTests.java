package com.zackvalentine.customerkeeper.customer;

import com.zackvalentine.customerkeeper.util.ApiHelper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.jackson.JacksonObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PostCustomerTests {
    @Test
    public void givenCustomerData_whenIPostToCustomer_thenIReceive201AndTheCreatedCustomer() {
        JSONObject customer = new JSONObject();
        String customerId = UUID.randomUUID().toString();
        customer.put("id", customerId);
        customer.put("firstName", "Test");
        customer.put("lastName", "Customer");
        Unirest.config().setObjectMapper(new JacksonObjectMapper());
        HttpResponse response = Unirest.post("http://localhost:8080/customers")
                .header("Content-Type", "application/json")
                .body(customer)
                .asJson();

        assertThat(response.getStatus(), is(equalTo(201)));
        assertThat(response.getBody().toString(), is(equalTo(customer.toString())));
    }

    @Test
    public void givenMissingCustomerData_whenIPostToCustomer_thenIReceive400() {
        JSONObject customer = new JSONObject();
        customer.put("id", UUID.randomUUID().toString());
        HttpResponse response = ApiHelper.post("/customers", customer.toMap());

        assertThat(response.getStatus(), is(equalTo(400)));
    }
}
