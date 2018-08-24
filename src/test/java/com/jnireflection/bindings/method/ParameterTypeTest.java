package com.jnireflection.bindings.method;

import com.jnireflection.bindings.JNIReflection;
import org.junit.jupiter.api.Test;

public class ParameterTypeTest extends AbstractMethodTest {

    @Test
    void test() {
        Object a = JNIReflection.invokeStaticMethod(getClassName(), "integerParameter", "(I)Ljava/lang/String;", new Object[]{1});
        System.out.println(a);
    }

}
