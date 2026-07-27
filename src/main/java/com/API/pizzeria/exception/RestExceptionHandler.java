package com.API.pizzeria.exception;

import com.API.pizzeria.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PizzaDoesNotExistException.class)
    public ResponseEntity<ErrorDTO> handleException(PizzaDoesNotExistException pde) {
        ErrorDTO error = new ErrorDTO("Pizza does not exist", pde.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
