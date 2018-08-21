package com.jnireflection.bindings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccessorTest extends AbstractJNIReflectionTest {

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
        TestObject.staticByte = Byte.MAX_VALUE;
        byte readByte = JNIReflection.getStaticByte(getClassName(), "staticByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setStaticByte() {
        JNIReflection.setStaticByte(Byte.MAX_VALUE, getClassName(), "staticByte", "B");
        assertThat(TestObject.staticByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getStaticShort() {
        TestObject.staticShort = Short.MAX_VALUE;
        short readShort = JNIReflection.getStaticShort(getClassName(), "staticShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setStaticShort() {
        JNIReflection.setStaticShort(Short.MAX_VALUE, getClassName(), "staticShort", "S");
        assertThat(TestObject.staticShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getStaticInt() {
        TestObject.staticInt = Integer.MAX_VALUE;
        int readInt = JNIReflection.getStaticInt(getClassName(), "staticInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setStaticInt() {
        JNIReflection.setStaticInt(Integer.MIN_VALUE, getClassName(), "staticInt", "I");
        assertThat(TestObject.staticInt).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void getStaticLong() {
        TestObject.staticLong = Long.MIN_VALUE;
        long readLong = JNIReflection.getStaticLong(getClassName(), "staticLong", "J");
        assertThat(readLong).isEqualTo(Long.MIN_VALUE);
    }

    @Test
    void setStaticLong() {
        JNIReflection.setStaticLong(Long.MAX_VALUE, getClassName(), "staticLong", "J");
        assertThat(TestObject.staticLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getStaticFloat() {
        TestObject.staticFloat = Float.MIN_VALUE;
        float readFloat = JNIReflection.getStaticFloat(getClassName(), "staticFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setStaticFloat() {
        JNIReflection.setStaticFloat(Float.MAX_VALUE, getClassName(), "staticFloat", "F");
        assertThat(TestObject.staticFloat).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getStaticDouble() {
        TestObject.staticDouble = Math.PI;
        double readDouble = JNIReflection.getStaticDouble(getClassName(), "staticDouble", "D");
        assertThat(readDouble).isEqualTo(Math.PI);
    }

    @Test
    void setStaticDouble() {
        JNIReflection.setStaticDouble(Math.E, getClassName(), "staticDouble", "D");
        assertThat(TestObject.staticDouble).isEqualTo(Math.E);
    }

    @Test
    void getStaticBoolean() {
        TestObject.staticBoolean = true;
        boolean readBoolean = JNIReflection.getStaticBoolean(getClassName(), "staticBoolean", "Z");
        assertThat(readBoolean).isTrue();
    }

    @Test
    void setStaticBoolean() {
        JNIReflection.setStaticBoolean(true, getClassName(), "staticBoolean", "Z");
        assertThat(TestObject.staticBoolean).isTrue();
    }

    @Test
    void getStaticChar() {
        TestObject.staticChar = 'c';
        char readChar = JNIReflection.getStaticChar(getClassName(), "staticChar", "C");
        assertThat(readChar).isEqualTo('c');
    }

    @Test
    void setStaticChar() {
        JNIReflection.setStaticChar('c', getClassName(), "staticChar", "C");
        assertThat(TestObject.staticChar).isEqualTo('c');
    }

    @Test
    void getInstanceObject() {
        getTestObject().setInstanceString("some text");
        String readString = (String) JNIReflection.getInstanceObject(getTestObject(), "instanceString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setInstanceObject() {
        JNIReflection.setInstanceObject("some text", getTestObject(), "instanceString", "Ljava/lang/String;");
        assertThat(getTestObject().getInstanceString()).isEqualTo("some text");
    }

    @Test
    void getInstanceByte() {
        getTestObject().setInstanceByte(Byte.MAX_VALUE);
        byte readByte = JNIReflection.getInstanceByte(getTestObject(), "instanceByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setInstanceByte() {
        JNIReflection.setInstanceByte(Byte.MAX_VALUE, getTestObject(), "instanceByte", "B");
        assertThat(getTestObject().getInstanceByte()).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getInstanceShort() {
        getTestObject().setInstanceShort(Short.MAX_VALUE);
        short readShort = JNIReflection.getInstanceShort(getTestObject(), "instanceShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setInstanceShort() {
        JNIReflection.setInstanceShort(Short.MAX_VALUE, getTestObject(), "instanceShort", "S");
        assertThat(getTestObject().getInstanceShort()).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getInstanceInt() {
        getTestObject().setInstanceInt(Integer.MAX_VALUE);
        int readInt = JNIReflection.getInstanceInt(getTestObject(), "instanceInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setInstanceInt() {
        JNIReflection.setInstanceInt(Integer.MAX_VALUE, getTestObject(), "instanceInt", "I");
        assertThat(getTestObject().getInstanceInt()).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void getInstanceLong() {
        getTestObject().setInstanceLong(Long.MAX_VALUE);
        long readLong = JNIReflection.getInstanceLong(getTestObject(), "instanceLong", "J");
        assertThat(readLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void setInstanceLong() {
        JNIReflection.setInstanceLong(Long.MAX_VALUE, getTestObject(), "instanceLong", "J");
        assertThat(getTestObject().getInstanceLong()).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getInstanceFloat() {
        getTestObject().setInstanceFloat(Float.MIN_VALUE);
        float readFloat = JNIReflection.getInstanceFloat(getTestObject(), "instanceFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setInstanceFloat() {
        JNIReflection.setInstanceFloat(Float.MAX_VALUE, getTestObject(), "instanceFloat", "F");
        assertThat(getTestObject().getInstanceFloat()).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getInstanceDouble() {
        getTestObject().setInstanceDouble(Double.MIN_VALUE);
        double readDouble = JNIReflection.getInstanceDouble(getTestObject(), "instanceDouble", "D");
        assertThat(readDouble).isEqualTo(Double.MIN_VALUE);
    }

    @Test
    void setInstanceDouble() {
        JNIReflection.setInstanceDouble(Double.MAX_VALUE, getTestObject(), "instanceDouble", "D");
        assertThat(getTestObject().getInstanceDouble()).isEqualTo(Double.MAX_VALUE);
    }

}
