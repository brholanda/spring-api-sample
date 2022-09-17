package com.sample.config;

import com.sample.exception.EntityNotFoundException;
import com.sample.http.BasicResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<BasicResponse<Object>> handleNotFound(final EntityNotFoundException entityNotFoundException) {
        final BasicResponse<Object> basicResponse = BasicResponse.fail(HttpStatus.NO_CONTENT.value(), entityNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(basicResponse);
    }

}
