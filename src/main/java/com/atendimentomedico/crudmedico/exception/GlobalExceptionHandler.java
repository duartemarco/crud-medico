package com.atendimentomedico.crudmedico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({PacienteNotFoundException.class})
    public ResponseEntity<Object> handlePacienteNotFoundException(PacienteNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    @ExceptionHandler({MedicoNotFoundException.class})
    public ResponseEntity<Object> handleMedicoNotFoundException(MedicoNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

}
