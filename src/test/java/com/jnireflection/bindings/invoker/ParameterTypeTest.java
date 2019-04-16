package com.jnireflection.bindings.invoker;

import com.jnireflection.bindings.JNIInvoker;
import org.junit.jupiter.api.Test;

class ParameterTypeTest extends AbstractMethodTest {

    @Test
    void test() {
        Object a = JNIInvoker.invokeStaticMethod(getClassName(), "integerParameter", "(I)Ljava/lang/String;", new Object[]{1});
        System.out.println(a);
    }

}
