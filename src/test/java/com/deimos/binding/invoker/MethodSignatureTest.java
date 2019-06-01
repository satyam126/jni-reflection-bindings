package com.deimos.binding.invoker;

import com.deimos.error.MethodSignatureError;
import com.deimos.model.MethodSignature;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MethodSignatureTest {

    @Test
    void bracketMismatch() {
        assertThatExceptionOfType(MethodSignatureError.class).isThrownBy(
                () -> MethodSignature.parse("I)V")
        );
    }

    @Test
    void invalidType() {
        assertThatExceptionOfType(MethodSignatureError.class).isThrownBy(
                () -> MethodSignature.parse("(K)V")
        );
    }

    @Test
    void twoObjects() {
        MethodSignature methodSignature = new MethodSignature(
                "(Ljava/lang/String;ZLjava/lang/NullPointerException;)V", "LZL", 'V'
        );
        assertThat(MethodSignature.parse("(Ljava/lang/String;ZLjava/lang/NullPointerException;)V")).isEqualTo(methodSignature);
    }

    @Test
    void twoArrays() {
        MethodSignature methodSignature = new MethodSignature(
                "([Ljava/lang/String;Z[Ljava/lang/NullPointerException;)V", "LZL", 'V'
        );
        assertThat(MethodSignature.parse("([Ljava/lang/String;Z[Ljava/lang/NullPointerException;)V")).isEqualTo(methodSignature);
    }

    @Test
    void arrayAsReturnType() {
        MethodSignature methodSignature = new MethodSignature(
                "()Ljava/lang/String;", "", 'L'
        );
        assertThat(MethodSignature.parse("()Ljava/lang/String;")).isEqualTo(methodSignature);
    }

}
