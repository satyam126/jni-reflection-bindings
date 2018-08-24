package com.jnireflection.bindings.method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractMethodTest {

    private static String className;
    private MethodTestObject methodTestObject;

    @BeforeAll
    static void initializeLibrary() {
        className = MethodTestObject.class.getName().replace(".", "/");
    }

    @BeforeEach
    void initializeObject() {
        methodTestObject = new MethodTestObject();
    }

    static String getClassName() {
        return className;
    }

    MethodTestObject getMethodTestObject() {
        return methodTestObject;
    }

}
