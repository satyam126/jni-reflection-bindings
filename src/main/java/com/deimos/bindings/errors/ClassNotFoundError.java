package com.deimos.bindings.errors;

public class ClassNotFoundError extends Error {

    public ClassNotFoundError() {
    }

    public ClassNotFoundError(String message) {
        super(message);
    }

}
