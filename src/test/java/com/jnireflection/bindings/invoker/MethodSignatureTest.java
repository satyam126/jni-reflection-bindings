package com.jnireflection.bindings.invoker;

import com.jnireflection.bindings.MethodSignature;
import com.jnireflection.bindings.errors.MethodSignatureError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MethodSignatureTest {

    @Test
    void invalidSignature() {
        assertThatExceptionOfType(MethodSignatureError.class).isThrownBy(
                () -> MethodSignature.parseSignature("I)V")
        );
    }

    @Test
    void twoObjects() {
        MethodSignature methodSignature = new MethodSignature("LZL", 'V');
        assertThat(MethodSignature.parseSignature("(Ljava/lang/String;ZLjava/lang/NullPointerException;)V")).isEqualTo(methodSignature);
    }

}
