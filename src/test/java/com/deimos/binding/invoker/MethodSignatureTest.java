package com.deimos.binding.invoker;

import com.deimos.model.MethodSignature;
import com.deimos.error.MethodSignatureError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MethodSignatureTest {

    @Test
    void bracketMismatch() {
        assertThatExceptionOfType(MethodSignatureError.class).isThrownBy(
                () -> MethodSignature.parseSignature("I)V")
        );
    }

    @Test
    void invalidType() {
        assertThatExceptionOfType(MethodSignatureError.class).isThrownBy(
                () -> MethodSignature.parseSignature("(K)V")
        );
    }

    @Test
    void twoObjects() {
        MethodSignature methodSignature = new MethodSignature("LZL", 'V');
        assertThat(MethodSignature.parseSignature("(Ljava/lang/String;ZLjava/lang/NullPointerException;)V")).isEqualTo(methodSignature);
    }

    @Test
    void twoArrays() {
        MethodSignature methodSignature = new MethodSignature("LZL", 'V');
        assertThat(MethodSignature.parseSignature("([Ljava/lang/String;Z[Ljava/lang/NullPointerException;)V")).isEqualTo(methodSignature);
    }

    @Test
    void arrayAsReturnType() {
        MethodSignature methodSignature = new MethodSignature("", 'L');
        assertThat(MethodSignature.parseSignature("()Ljava/lang/String;")).isEqualTo(methodSignature);
    }

}
