package com.jnireflection.bindings.accessor;

import com.jnireflection.bindings.JNIReflection;
import com.jnireflection.bindings.errors.ClassNotFoundError;
import com.jnireflection.bindings.errors.FieldNotFoundError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class ErrorTest extends AbstractAccessorTest {

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
        assertThatNullPointerException().isThrownBy(
                () -> JNIReflection.getInstanceObject(null, "instanceString", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getInstanceObject(getAccessorTestObject(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getInstanceObject(getAccessorTestObject(), "instanceString", "I")
        );
    }

}
