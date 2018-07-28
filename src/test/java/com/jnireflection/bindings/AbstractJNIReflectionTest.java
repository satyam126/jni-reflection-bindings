package com.jnireflection.bindings;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractJNIReflectionTest {

    private static String className;
    private TestObject testObject;

    @BeforeAll
    static void initializeLibrary() {
        JNIReflection.loadLibrary();
        className = TestObject.class.getName().replace(".", "/");
    }

    @BeforeEach
    void initializeObject() {
        testObject = new TestObject();
        TestObject.staticByte = 0;
        TestObject.staticShort = 0;
        TestObject.staticInt = 0;
        TestObject.staticLong = 0;
        TestObject.staticFloat = 0;
        TestObject.staticDouble = 0;
        TestObject.staticBoolean = false;
        TestObject.staticChar = 0;
        TestObject.staticString = null;
    }

    static String getClassName() {
        return className;
    }

    TestObject getTestObject() {
        return testObject;
    }

}
