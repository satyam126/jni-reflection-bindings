package com.deimos.bindings.accessor;

import com.deimos.bindings.JniAccessor;
import com.deimos.bindings.errors.ClassNotFoundError;
import com.deimos.bindings.errors.FieldNotFoundError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class AccessorErrorTest extends AbstractAccessorTest {

    @Test
    void getStaticObjectInvalidClass() {
        assertThatExceptionOfType(ClassNotFoundError.class).isThrownBy(
                () -> JniAccessor.getStaticObject("invalidClass", "staticString", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JniAccessor.getStaticObject(getClassName(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getStaticObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JniAccessor.getStaticObject(getClassName(), "staticString", "I")
        );
    }

    @Test
    void getInstanceObjectNullInstance() {
        assertThatNullPointerException().isThrownBy(
                () -> JniAccessor.getInstanceObject(null, "instanceString", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidFieldName() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JniAccessor.getInstanceObject(getAccessorTestObject(), "invalidField", "Ljava/lang/String;")
        );
    }

    @Test
    void getInstanceObjectInvalidType() {
        assertThatExceptionOfType(FieldNotFoundError.class).isThrownBy(
                () -> JniAccessor.getInstanceObject(getAccessorTestObject(), "instanceString", "I")
        );
    }

    @Test
    void getInstancesInvalidClass() {
        assertThatExceptionOfType(Error.class).isThrownBy(
                () -> JniAccessor.getInstances("invalidClass")
        );
    }

}
