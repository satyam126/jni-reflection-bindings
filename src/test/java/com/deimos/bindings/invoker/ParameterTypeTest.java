package com.deimos.bindings.invoker;

import com.deimos.bindings.JniInvoker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ParameterTypeTest extends AbstractMethodTest {

    @Test
    void staticEmptyParameter() {
        String o = JniInvoker.invoke(
                getClassName(), "staticEmptyParameter",
                "()Ljava/lang/String;");
        assertThat(o).isEqualTo("ok");
    }

    @Test
    void staticObjectParameter() {
        String o = JniInvoker.invoke(
                getClassName(), "staticObjectParameter",
                "(Ljava/lang/String;)Ljava/lang/String;", "ok"
        );
        assertThat(o).isEqualTo("ok");
    }

    @Test
    void staticArrayParameter() {
        int[] argument = {1, 2, 3};
        String o = JniInvoker.invoke(
                getClassName(), "staticArrayParameter",
                "([I)Ljava/lang/String;", (Object) argument
        );
        assertThat(o).isEqualTo(Arrays.toString(argument));
    }

    @Test
    void staticByteParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticByteParameter",
                "(B)Ljava/lang/String;", (byte) 1
        );
        assertThat(s).isEqualTo("1");
    }

    @Test
    void staticCharParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticCharParameter",
                "(C)Ljava/lang/String;", 'a'
        );
        assertThat(s).isEqualTo("a");
    }

    @Test
    void staticDoubleParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticDoubleParameter",
                "(D)Ljava/lang/String;", 3.14
        );
        assertThat(s).isEqualTo("3.14");
    }

    @Test
    void staticFloatParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticFloatParameter",
                "(F)Ljava/lang/String;", 3.14f
        );
        assertThat(s).isEqualTo("3.14");
    }

    @Test
    void staticIntegerParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticIntegerParameter",
                "(I)Ljava/lang/String;", 1
        );
        assertThat(s).isEqualTo("1");
    }

    @Test
    void staticLongParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticLongParameter",
                "(J)Ljava/lang/String;", 3L
        );
        assertThat(s).isEqualTo("3");
    }

    @Test
    void staticShortParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticShortParameter",
                "(S)Ljava/lang/String;", (short) 3
        );
        assertThat(s).isEqualTo("3");
    }

    @Test
    void staticBooleanParameter() {
        String s = JniInvoker.invoke(
                getClassName(), "staticBooleanParameter",
                "(Z)Ljava/lang/String;", true
        );
        assertThat(s).isEqualTo("true");
    }

}
