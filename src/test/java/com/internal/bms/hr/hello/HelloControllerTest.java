package com.internal.bms.hr.hello;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest {

    @Test
    void testHelloGet() {
        HelloController helloController = new HelloController();
        ResponseEntity<String> response = helloController.helloGet();
        
        // Check if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        // Check if the response body contains the expected message
        assertEquals("Welcome to the HR Portal", response.getBody());
    }
}
