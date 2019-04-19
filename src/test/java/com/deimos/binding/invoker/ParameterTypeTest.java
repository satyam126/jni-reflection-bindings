package com.deimos.binding.invoker;

import com.deimos.binding.Invoker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ParameterTypeTest extends AbstractMethodTest {

    @Test
    void staticEmptyParameter() {
        String o = Invoker.invoke(
                getClassName(), "staticEmptyParameter",
                "()Ljava/lang/String;");
        assertThat(o).isEqualTo("ok");
    }

    @Test
    void staticObjectParameter() {
        String o = Invoker.invoke(
                getClassName(), "staticObjectParameter",
                "(Ljava/lang/String;)Ljava/lang/String;", "ok"
        );
        assertThat(o).isEqualTo("ok");
    }

    @Test
    void staticArrayParameter() {
        int[] argument = {1, 2, 3};
        String o = Invoker.invoke(
                getClassName(), "staticArrayParameter",
                "([I)Ljava/lang/String;", (Object) argument
        );
        assertThat(o).isEqualTo(Arrays.toString(argument));
    }

    @Test
    void staticByteParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticByteParameter",
                "(B)Ljava/lang/String;", (byte) 1
        );
        assertThat(s).isEqualTo("1");
    }

    @Test
    void staticCharParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticCharParameter",
                "(C)Ljava/lang/String;", 'a'
        );
        assertThat(s).isEqualTo("a");
    }

    @Test
    void staticDoubleParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticDoubleParameter",
                "(D)Ljava/lang/String;", 3.14
        );
        assertThat(s).isEqualTo("3.14");
    }

    @Test
    void staticFloatParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticFloatParameter",
                "(F)Ljava/lang/String;", 3.14f
        );
        assertThat(s).isEqualTo("3.14");
    }

    @Test
    void staticIntegerParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticIntegerParameter",
                "(I)Ljava/lang/String;", 1
        );
        assertThat(s).isEqualTo("1");
    }

    @Test
    void staticLongParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticLongParameter",
                "(J)Ljava/lang/String;", 3L
        );
        assertThat(s).isEqualTo("3");
    }

    @Test
    void staticShortParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticShortParameter",
                "(S)Ljava/lang/String;", (short) 3
        );
        assertThat(s).isEqualTo("3");
    }

    @Test
    void staticBooleanParameter() {
        String s = Invoker.invoke(
                getClassName(), "staticBooleanParameter",
                "(Z)Ljava/lang/String;", true
        );
        assertThat(s).isEqualTo("true");
    }

    @Test
    void staticCombinationParameter() {
        int[] a = {1, 2, 3};
        String b = "b";
        int[] c = {4, 5, 6};
        int d = 7;
        String e = "e";
        String s = Invoker.invoke(
                getClassName(), "staticCombinationParameter",
                "([ILjava/lang/String;[IILjava/lang/String;)Ljava/lang/String;",
                a, b, c, d, e
        );
        assertThat(s).isEqualTo(Arrays.toString(a) + b + Arrays.toString(c) + d + e);
    }

    @Test
    void instanceCombinationParameter() {
        int[] a = {1, 2, 3};
        String b = "b";
        int[] c = {4, 5, 6};
        int d = 7;
        String e = "e";
        String s = Invoker.invoke(
                getObject(), "instanceCombinationParameter",
                "([ILjava/lang/String;[IILjava/lang/String;)Ljava/lang/String;",
                a, b, c, d, e
        );
        assertThat(s).isEqualTo(Arrays.toString(a) + b + Arrays.toString(c) + d + e);
    }

}
