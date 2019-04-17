package com.jnireflection.bindings.accessor;

import com.jnireflection.bindings.JNIAccessor;
import com.jnireflection.bindings.errors.ClassNotFoundError;
import com.jnireflection.bindings.errors.FieldNotFoundError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class AccessorErrorTest extends AbstractAccessorTest {

    @Test
    void getStaticObjectInvalidClass() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JNIAccessor.getStaticObject("invalidClass", "staticString", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIAccessor.getStaticObject(getClassName(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIAccessor.getStaticObject(getClassName(), "staticString", "I")
        );
    }

    @Test
    void getInstanceObjectNullInstance() {
        assertThatNullPointerException().isThrownBy(
                () -> JNIAccessor.getInstanceObject(null, "instanceString", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIAccessor.getInstanceObject(getAccessorTestObject(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JNIAccessor.getInstanceObject(getAccessorTestObject(), "instanceString", "I")
        );
    }

    @Test
    void getInstancesInvalidClass() {
        assertThatExceptionOfType(Error.class).isThrownBy(
                () -> JNIAccessor.getInstances("invalidClass")
        );
    }

}
