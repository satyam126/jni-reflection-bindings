package com.deimos.error;

public class ConstructorNotFoundError extends Error {

    public ConstructorNotFoundError() {
    }

    public ConstructorNotFoundError(String message) {
        super(message);
    }

}
