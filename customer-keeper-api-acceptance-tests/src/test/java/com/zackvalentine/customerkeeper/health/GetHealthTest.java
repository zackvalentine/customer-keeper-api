package com.zackvalentine.customerkeeper.health;

import org.junit.Test;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class GetHealthTest {
    @Test
    public void whenICallHealth_thenReturns200AndHealthy() {
        HttpResponse<String> response = Unirest.get("http://localhost:8080/health").asString();

        assertThat(response.getStatus(), is(equalTo(200)));
        assertThat(response.getBody(), is(equalTo("Healthy")));
    }
}
