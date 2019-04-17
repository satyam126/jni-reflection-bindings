package com.jnireflection.bindings.invoker;

import com.jnireflection.bindings.JNIInvoker;
import com.jnireflection.bindings.ParameterizedTypeReference;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ParameterTypeTest extends AbstractMethodTest {

    @Test
    void staticEmptyParameter() {
        String o = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticEmptyParameter",
                "()Ljava/lang/String;", new ParameterizedTypeReference<>() {
                });
        assertThat(o).isEqualTo("ok");
    }

    @Test
    void staticObjectParameter() {
        String o = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticObjectParameter",
                "(Ljava/lang/String;)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, "ok"
        );
        assertThat(o).isEqualTo("ok");
    }

    @Test
    void staticArrayParameter() {
        int[] argument = {1, 2, 3};
        String o = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticArrayParameter",
                "([I)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, (Object) argument
        );
        assertThat(o).isEqualTo(Arrays.toString(argument));
    }

    @Test
    void staticByteParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticByteParameter",
                "(B)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, (byte) 1
        );
        assertThat(s).isEqualTo("1");
    }

    @Test
    void staticCharParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticCharParameter",
                "(C)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, 'a'
        );
        assertThat(s).isEqualTo("a");
    }

    @Test
    void staticDoubleParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticDoubleParameter",
                "(D)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, 3.14
        );
        assertThat(s).isEqualTo("3.14");
    }

    @Test
    void staticFloatParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticFloatParameter",
                "(F)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, 3.14f
        );
        assertThat(s).isEqualTo("3.14");
    }

    @Test
    void staticIntegerParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticIntegerParameter",
                "(I)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, 1
        );
        assertThat(s).isEqualTo("1");
    }

    @Test
    void staticLongParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticLongParameter",
                "(J)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, 3L
        );
        assertThat(s).isEqualTo("3");
    }

    @Test
    void staticShortParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticShortParameter",
                "(S)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, (short) 3
        );
        assertThat(s).isEqualTo("3");
    }

    @Test
    void staticBooleanParameter() {
        String s = JNIInvoker.invokeStaticMethodAs(
                getClassName(), "staticBooleanParameter",
                "(Z)Ljava/lang/String;",
                new ParameterizedTypeReference<>() {
                }, true
        );
        assertThat(s).isEqualTo("true");
    }

}
