package com.atendimentomedico.crudmedico.exception;

public class MedicoNotFoundException extends RuntimeException {
    public MedicoNotFoundException(String message) {
        super(message);
    }
}
