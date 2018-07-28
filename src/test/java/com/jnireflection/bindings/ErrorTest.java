package com.jnireflection.bindings;

import com.jnireflection.bindings.errors.ClassNotFoundError;
import com.jnireflection.bindings.errors.FieldNotFoundError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ErrorTest extends AbstractJNIReflectionTest {

    @Test
    void getStaticObjectClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticObject("invalidClass", "staticString", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticObject(getClassName(), "invalidField", "Ljava/lang/String;")
        );
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
                () -> JNIReflection.setStaticObject("text", getClassName(), "invalidField", "Ljava/lang/String;")
        );
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
                () -> JNIReflection.getStaticByte(getClassName(), "invalidField", "B")
        );
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
                () -> JNIReflection.setStaticByte((byte) 19, getClassName(), "invalidField", "B")
        );
    }

    @Test
    void getStaticShortClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticShort("invalidClass", "staticShort", "S")
        );
    }

    @Test
    void getStaticShortFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticShort(getClassName(), "invalidField", "S")
        );
    }

    @Test
    void setStaticShortClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticShort((short) 13, "invalidClass", "staticShort", "S")
        );
    }

    @Test
    void setStaticShortFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticShort((short) 19, getClassName(), "invalidField", "S")
        );
    }

    @Test
    void getStaticIntClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticInt("invalidClass", "staticShort", "I")
        );
    }

    @Test
    void getStaticIntFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticInt(getClassName(), "invalidField", "I")
        );
    }

    @Test
    void setStaticIntClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticInt(11, "invalidClass", "staticInt", "I")
        );
    }

    @Test
    void setStaticIntFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticInt(11, getClassName(), "invalidField", "I")
        );
    }

    @Test
    void getStaticLongClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticLong("invalidClass", "staticLong", "J")
        );
    }

    @Test
    void getStaticLongFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.getStaticLong(getClassName(), "invalidField", "J")
        );
    }

    @Test
    void setStaticLongClassNotFound() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticLong(1173, "invalidClass", "staticLong", "J")
        );
    }

    @Test
    void setStaticLongFieldNotFound() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIReflection.setStaticLong(1173, getClassName(), "invalidField", "J")
        );
    }

}
