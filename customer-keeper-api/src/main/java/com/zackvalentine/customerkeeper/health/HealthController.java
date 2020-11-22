package com.zackvalentine.customerkeeper.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Healthy", HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testStatus() {
        return new ResponseEntity<>("Test passed", HttpStatus.OK);
    }
}
