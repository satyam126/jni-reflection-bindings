package com.deimos.binding.accessor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractAccessorTest {

    private static String className;
    private AccessorTestObject accessorTestObject;

    @BeforeAll
    static void initializeClassName() {
        className = AccessorTestObject.class.getName().replace(".", "/");
    }

    @BeforeEach
    void initializeObject() {
        accessorTestObject = new AccessorTestObject();
        AccessorTestObject.staticByte = 0;
        AccessorTestObject.staticShort = 0;
        AccessorTestObject.staticInt = 0;
        AccessorTestObject.staticLong = 0;
        AccessorTestObject.staticFloat = 0;
        AccessorTestObject.staticDouble = 0;
        AccessorTestObject.staticBoolean = false;
        AccessorTestObject.staticChar = 0;
        AccessorTestObject.staticString = null;
    }

    static String getClassName() {
        return className;
    }

    AccessorTestObject getAccessorTestObject() {
        return accessorTestObject;
    }

}
