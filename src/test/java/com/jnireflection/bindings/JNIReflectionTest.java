package com.jnireflection.bindings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JNIReflectionTest extends AbstractJNIReflectionTest {

    @Test
    void getStaticObject() {
        TestObject.staticString = "some text";
        String readString = (String) JNIReflection.getStaticObject(getClassName(), "staticString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setStaticObject() {
        JNIReflection.setStaticObject("some new text", getClassName(), "staticString", "Ljava/lang/String;");
        assertThat(TestObject.staticString).isEqualTo("some new text");
    }

    @Test
    void getStaticByte() {
        TestObject.staticByte = 17;
        byte readByte = JNIReflection.getStaticByte(getClassName(), "staticByte", "B");
        assertThat(readByte).isEqualTo((byte) 17);
    }

    @Test
    void setStaticByte() {
        JNIReflection.setStaticByte((byte) 19, getClassName(), "staticByte", "B");
        assertThat(TestObject.staticByte).isEqualTo((byte) 19);
    }

    @Test
    void getStaticShort() {
        TestObject.staticShort = 13;
        short readShort = JNIReflection.getStaticShort(getClassName(), "staticShort", "S");
        assertThat(readShort).isEqualTo((short) 13);
    }

    @Test
    void setStaticShort() {
        JNIReflection.setStaticShort((short) 13, getClassName(), "staticShort", "S");
        assertThat(TestObject.staticShort).isEqualTo((short) 13);
    }

    @Test
    void getStaticInt() {
        TestObject.staticInt = 11;
        int readInt = JNIReflection.getStaticInt(getClassName(), "staticInt", "I");
        assertThat(readInt).isEqualTo(11);
    }

}
