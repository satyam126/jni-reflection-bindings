package com.jnireflection.bindings.accessor;

import com.jnireflection.bindings.JNIReflection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccessorTest extends AbstractAccessorTest {

    @Test
    void getStaticObject() {
        AccessorTestObject.staticString = "some text";
        String readString = (String) JNIReflection.getStaticObject(getClassName(), "staticString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setStaticObject() {
        JNIReflection.setStaticObject("some new text", getClassName(), "staticString", "Ljava/lang/String;");
        assertThat(AccessorTestObject.staticString).isEqualTo("some new text");
    }

    @Test
    void getStaticByte() {
        AccessorTestObject.staticByte = Byte.MAX_VALUE;
        byte readByte = JNIReflection.getStaticByte(getClassName(), "staticByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setStaticByte() {
        JNIReflection.setStaticByte(Byte.MAX_VALUE, getClassName(), "staticByte", "B");
        assertThat(AccessorTestObject.staticByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getStaticShort() {
        AccessorTestObject.staticShort = Short.MAX_VALUE;
        short readShort = JNIReflection.getStaticShort(getClassName(), "staticShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setStaticShort() {
        JNIReflection.setStaticShort(Short.MAX_VALUE, getClassName(), "staticShort", "S");
        assertThat(AccessorTestObject.staticShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getStaticInt() {
        AccessorTestObject.staticInt = Integer.MAX_VALUE;
        int readInt = JNIReflection.getStaticInt(getClassName(), "staticInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setStaticInt() {
        JNIReflection.setStaticInt(Integer.MIN_VALUE, getClassName(), "staticInt", "I");
        assertThat(AccessorTestObject.staticInt).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void getStaticLong() {
        AccessorTestObject.staticLong = Long.MIN_VALUE;
        long readLong = JNIReflection.getStaticLong(getClassName(), "staticLong", "J");
        assertThat(readLong).isEqualTo(Long.MIN_VALUE);
    }

    @Test
    void setStaticLong() {
        JNIReflection.setStaticLong(Long.MAX_VALUE, getClassName(), "staticLong", "J");
        assertThat(AccessorTestObject.staticLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getStaticFloat() {
        AccessorTestObject.staticFloat = Float.MIN_VALUE;
        float readFloat = JNIReflection.getStaticFloat(getClassName(), "staticFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setStaticFloat() {
        JNIReflection.setStaticFloat(Float.MAX_VALUE, getClassName(), "staticFloat", "F");
        assertThat(AccessorTestObject.staticFloat).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getStaticDouble() {
        AccessorTestObject.staticDouble = Math.PI;
        double readDouble = JNIReflection.getStaticDouble(getClassName(), "staticDouble", "D");
        assertThat(readDouble).isEqualTo(Math.PI);
    }

    @Test
    void setStaticDouble() {
        JNIReflection.setStaticDouble(Math.E, getClassName(), "staticDouble", "D");
        assertThat(AccessorTestObject.staticDouble).isEqualTo(Math.E);
    }

    @Test
    void getStaticBoolean() {
        AccessorTestObject.staticBoolean = true;
        boolean readBoolean = JNIReflection.getStaticBoolean(getClassName(), "staticBoolean", "Z");
        assertThat(readBoolean).isTrue();
    }

    @Test
    void setStaticBoolean() {
        JNIReflection.setStaticBoolean(true, getClassName(), "staticBoolean", "Z");
        assertThat(AccessorTestObject.staticBoolean).isTrue();
    }

    @Test
    void getStaticChar() {
        AccessorTestObject.staticChar = 'c';
        char readChar = JNIReflection.getStaticChar(getClassName(), "staticChar", "C");
        assertThat(readChar).isEqualTo('c');
    }

    @Test
    void setStaticChar() {
        JNIReflection.setStaticChar('c', getClassName(), "staticChar", "C");
        assertThat(AccessorTestObject.staticChar).isEqualTo('c');
    }

    @Test
    void getInstanceObject() {
        getAccessorTestObject().setInstanceString("some text");
        String readString = (String) JNIReflection.getInstanceObject(getAccessorTestObject(), "instanceString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setInstanceObject() {
        JNIReflection.setInstanceObject("some text", getAccessorTestObject(), "instanceString", "Ljava/lang/String;");
        assertThat(getAccessorTestObject().getInstanceString()).isEqualTo("some text");
    }

    @Test
    void getInstanceByte() {
        getAccessorTestObject().setInstanceByte(Byte.MAX_VALUE);
        byte readByte = JNIReflection.getInstanceByte(getAccessorTestObject(), "instanceByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setInstanceByte() {
        JNIReflection.setInstanceByte(Byte.MAX_VALUE, getAccessorTestObject(), "instanceByte", "B");
        assertThat(getAccessorTestObject().getInstanceByte()).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getInstanceShort() {
        getAccessorTestObject().setInstanceShort(Short.MAX_VALUE);
        short readShort = JNIReflection.getInstanceShort(getAccessorTestObject(), "instanceShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setInstanceShort() {
        JNIReflection.setInstanceShort(Short.MAX_VALUE, getAccessorTestObject(), "instanceShort", "S");
        assertThat(getAccessorTestObject().getInstanceShort()).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getInstanceInt() {
        getAccessorTestObject().setInstanceInt(Integer.MAX_VALUE);
        int readInt = JNIReflection.getInstanceInt(getAccessorTestObject(), "instanceInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setInstanceInt() {
        JNIReflection.setInstanceInt(Integer.MAX_VALUE, getAccessorTestObject(), "instanceInt", "I");
        assertThat(getAccessorTestObject().getInstanceInt()).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void getInstanceLong() {
        getAccessorTestObject().setInstanceLong(Long.MAX_VALUE);
        long readLong = JNIReflection.getInstanceLong(getAccessorTestObject(), "instanceLong", "J");
        assertThat(readLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void setInstanceLong() {
        JNIReflection.setInstanceLong(Long.MAX_VALUE, getAccessorTestObject(), "instanceLong", "J");
        assertThat(getAccessorTestObject().getInstanceLong()).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getInstanceFloat() {
        getAccessorTestObject().setInstanceFloat(Float.MIN_VALUE);
        float readFloat = JNIReflection.getInstanceFloat(getAccessorTestObject(), "instanceFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setInstanceFloat() {
        JNIReflection.setInstanceFloat(Float.MAX_VALUE, getAccessorTestObject(), "instanceFloat", "F");
        assertThat(getAccessorTestObject().getInstanceFloat()).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getInstanceDouble() {
        getAccessorTestObject().setInstanceDouble(Double.MIN_VALUE);
        double readDouble = JNIReflection.getInstanceDouble(getAccessorTestObject(), "instanceDouble", "D");
        assertThat(readDouble).isEqualTo(Double.MIN_VALUE);
    }

    @Test
    void setInstanceDouble() {
        JNIReflection.setInstanceDouble(Double.MAX_VALUE, getAccessorTestObject(), "instanceDouble", "D");
        assertThat(getAccessorTestObject().getInstanceDouble()).isEqualTo(Double.MAX_VALUE);
    }

    @Test
    void getInstanceBoolean() {
        getAccessorTestObject().setInstanceBoolean(false);
        boolean readBoolean = JNIReflection.getInstanceBoolean(getAccessorTestObject(), "instanceBoolean", "Z");
        assertThat(readBoolean).isFalse();
    }

    @Test
    void setInstanceBoolean() {
        JNIReflection.setInstanceBoolean(true, getAccessorTestObject(), "instanceBoolean", "Z");
        assertThat(getAccessorTestObject().isInstanceBoolean()).isTrue();
    }

    @Test
    void getInstanceChar() {
        getAccessorTestObject().setInstanceChar('c');
        char readDouble = JNIReflection.getInstanceChar(getAccessorTestObject(), "instanceChar", "C");
        assertThat(readDouble).isEqualTo('c');
    }

    @Test
    void setInstanceChar() {
        JNIReflection.setInstanceChar('c', getAccessorTestObject(), "instanceChar", "C");
        assertThat(getAccessorTestObject().getInstanceChar()).isEqualTo('c');
    }

}
