package com.deimos.binding.accessor;

import com.deimos.binding.Accessor;
import com.deimos.error.ClassNotFoundError;
import com.deimos.error.FieldNotFoundError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class AccessorErrorTest extends AbstractAccessorTest {

    @Test
    void getStaticObjectInvalidClass() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> Accessor.getStaticObject("invalidClass", "staticString", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> Accessor.getStaticObject(getClassName(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> Accessor.getStaticObject(getClassName(), "staticString", "I")
        );
    }

    @Test
    void getInstanceObjectNullInstance() {
        assertThatNullPointerException().isThrownBy(
                () -> Accessor.getInstanceObject(null, "instanceString", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> Accessor.getInstanceObject(getAccessorTestObject(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> Accessor.getInstanceObject(getAccessorTestObject(), "instanceString", "I")
        );
    }

    @Test
    void getInstancesInvalidClass() {
        assertThatExceptionOfType(Error.class).isThrownBy(
                () -> Accessor.getInstances("invalidClass")
        );
    }

}
