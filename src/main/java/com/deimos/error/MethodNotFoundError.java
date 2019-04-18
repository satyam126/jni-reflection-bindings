package com.deimos.error;

public class MethodNotFoundError extends Error {

    public MethodNotFoundError() {
    }

    public MethodNotFoundError(String message) {
        super(message);
    }

}
