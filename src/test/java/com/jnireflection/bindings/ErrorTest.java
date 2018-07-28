package com.jnireflection.bindings;

import com.jnireflection.bindings.errors.ClassNotFoundError;
import com.jnireflection.bindings.errors.FieldNotFoundError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ErrorTest extends AbstractJNIReflectionTest {

    @Test
    void getStaticObjectInvalidClass() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticObject("invalidClass", "staticString", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticObject(getClassName(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticObject(getClassName(), "staticString", "I")
        );
    }

    @Test
    void getInstanceObjectInvalidObject() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(
                () -> JNIReflection.getInstanceObject(null, "instanceString", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getInstanceObject(getTestObject(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getInstanceObject(getTestObject(), "instanceString", "I")
        );
    }

}
