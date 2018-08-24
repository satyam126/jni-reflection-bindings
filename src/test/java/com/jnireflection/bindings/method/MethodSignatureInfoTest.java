package com.jnireflection.bindings.method;

import com.jnireflection.bindings.MethodSignatureInfo;
import com.jnireflection.bindings.errors.MethodSignatureError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MethodSignatureInfoTest {

    @Test
    void invalidSignature() {
        assertThatExceptionOfType(MethodSignatureError.class).isThrownBy(
                () -> MethodSignatureInfo.parseSignature("I)V")
        );
    }

    @Test
    void twoObjects() {
        MethodSignatureInfo methodSignatureInfo = new MethodSignatureInfo("LZL", 'V');
        assertThat(MethodSignatureInfo.parseSignature("(Ljava/lang/String;ZLjava/lang/NullPointerException;)V")).isEqualTo(methodSignatureInfo);
    }

}
