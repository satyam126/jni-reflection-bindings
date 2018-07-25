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

    @Test
    void getStaticByte() {
        TestObject.staticByte = 17;
        byte readByte = JNIReflection.getStaticByte(className, "staticByte", "B");
        assertThat(readByte).isEqualTo((byte) 17);
    }

    @Test
    void getStaticByteClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticByte("invalidClass", "staticByte", "B")
        );
    }

    @Test
    void getStaticByteFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticByte(className, "invalidField", "B")
        );
    }

    @Test
    void setStaticByte() {
        JNIReflection.setStaticByte((byte) 19, className, "staticByte", "B");
        assertThat(TestObject.staticByte).isEqualTo((byte) 19);
    }

    @Test
    void setStaticByteClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticByte((byte) 19, "invalidClass", "staticByte", "B")
        );
    }

    @Test
    void setStaticByteFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticByte((byte) 19, className, "invalidField", "B")
        );
    }

}
