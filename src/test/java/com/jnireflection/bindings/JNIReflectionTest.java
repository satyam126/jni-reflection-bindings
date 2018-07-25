package com.jnireflection.bindings;

import com.jnireflection.bindings.errors.ClassNotFoundError;
import com.jnireflection.bindings.errors.FieldNotFoundError;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class JNIReflectionTest {

    private static String className;
    private TestObject testObject;

    @BeforeAll
    static void initializeLibrary() {
        JNIReflection.loadLibrary();
        className = TestObject.class.getName().replace(".", "/");
    }

    @BeforeEach
    void initialize() {
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

    @Test
    void getStaticObject() {
        TestObject.staticString = "some text";
        String readString = (String) JNIReflection.getStaticObject(className, "staticString", "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void getStaticObjectClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticObject("invalidClass", "staticString", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticObject(className, "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void setStaticObject() {
        JNIReflection.setStaticObject("some new text", className, "staticString", "Ljava/lang/String;");
        assertThat(TestObject.staticString).isEqualTo("some new text");
    }

    @Test
    void setStaticObjectClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticObject("text", "invalidClass", "staticString", "Ljava/lang/String;")
        );
    }

    @Test
    void setStaticObjectFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticObject("text", className, "invalidField", "Ljava/lang/String;")
        );
    }

}
