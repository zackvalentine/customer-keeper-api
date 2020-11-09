package com.zackvalentine.customerkeeper.health;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;

public class HealthControllerTest {
    private HealthController healthController = new HealthController();

    @Test
    public void healthCheckShouldReturnHealthy() {
        ResponseEntity<String> result = healthController.healthCheck();

        assertThat(result.getBody(), is(equalTo("Healthy")));
    }
}
