package com.jnireflection.bindings.errors;

public class ConstructorNotFoundError extends Error {

    public ConstructorNotFoundError() {
    }

    public ConstructorNotFoundError(String message) {
        super(message);
    }

}
