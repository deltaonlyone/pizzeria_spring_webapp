package com.lpnu.spring.pizzeria_spring_webapp.exeprion;

import com.lpnu.spring.pizzeria_spring_webapp.exeption.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    public void testHandleException() {
        Exception testException = new Exception("Test Exception");

        ResponseEntity<String> responseEntity = globalExceptionHandler.handleException(testException);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Internal Server Error", responseEntity.getBody());
    }
}
