package com.jnireflection.bindings.errors;

public class FieldNotFoundError extends Error {

    public FieldNotFoundError() {
    }

    public FieldNotFoundError(String message) {
        super(message);
    }

}