package com.deimos.error;

public class ClassNotFoundError extends Error {

    public ClassNotFoundError() {
    }

    public ClassNotFoundError(String message) {
        super(message);
    }

}
