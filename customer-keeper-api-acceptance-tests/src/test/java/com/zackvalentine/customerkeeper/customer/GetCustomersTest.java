package com.zackvalentine.customerkeeper.customer;

import com.zackvalentine.customerkeeper.util.ApiHelper;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import kong.unirest.HttpResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class GetCustomersTest {
    private Map<String, Object> customer = new HashMap<>();

    @Before
    public void setup() {
        String customerId = UUID.randomUUID().toString();
        customer.put("id", customerId);
        customer.put("firstName", "Test");
        customer.put("lastName", "Customer");
        HttpResponse response = ApiHelper.post("/customers", customer);
        assertThat(response.getStatus(), is(equalTo(201)));
    }

    @Test
    public void givenCustomersExist_whenICallGetCustomers_thenReturns200AndAnArrayOfCustomers() {
        JSONArray results = ApiHelper.get("/customers")
                .getBody()
                .getArray();
        Map<String, Object> lastCustomer = results.getJSONObject(results.length()-1).toMap();

        assertThat(results.length(), is(not(equalTo(0))));
        assertThat(lastCustomer,
                is(equalTo(customer)));
    }
}
