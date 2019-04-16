package com.jnireflection.bindings.accessor;

import com.jnireflection.bindings.JNIAccessor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class AccessorTest extends AbstractAccessorTest {

    @Test
    void getStaticObject() {
        AccessorTestObject.staticString = "some text";
        String readString = (String) JNIAccessor.getStaticObject(getClassName(), "staticString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setStaticObject() {
        JNIAccessor.setStaticObject("some new text", getClassName(), "staticString", "Ljava/lang/String;");
        assertThat(AccessorTestObject.staticString).isEqualTo("some new text");
    }

    @Test
    void getStaticByte() {
        AccessorTestObject.staticByte = Byte.MAX_VALUE;
        byte readByte = JNIAccessor.getStaticByte(getClassName(), "staticByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setStaticByte() {
        JNIAccessor.setStaticByte(Byte.MAX_VALUE, getClassName(), "staticByte", "B");
        assertThat(AccessorTestObject.staticByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getStaticShort() {
        AccessorTestObject.staticShort = Short.MAX_VALUE;
        short readShort = JNIAccessor.getStaticShort(getClassName(), "staticShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setStaticShort() {
        JNIAccessor.setStaticShort(Short.MAX_VALUE, getClassName(), "staticShort", "S");
        assertThat(AccessorTestObject.staticShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getStaticInt() {
        AccessorTestObject.staticInt = Integer.MAX_VALUE;
        int readInt = JNIAccessor.getStaticInt(getClassName(), "staticInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setStaticInt() {
        JNIAccessor.setStaticInt(Integer.MIN_VALUE, getClassName(), "staticInt", "I");
        assertThat(AccessorTestObject.staticInt).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void getStaticLong() {
        AccessorTestObject.staticLong = Long.MIN_VALUE;
        long readLong = JNIAccessor.getStaticLong(getClassName(), "staticLong", "J");
        assertThat(readLong).isEqualTo(Long.MIN_VALUE);
    }

    @Test
    void setStaticLong() {
        JNIAccessor.setStaticLong(Long.MAX_VALUE, getClassName(), "staticLong", "J");
        assertThat(AccessorTestObject.staticLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getStaticFloat() {
        AccessorTestObject.staticFloat = Float.MIN_VALUE;
        float readFloat = JNIAccessor.getStaticFloat(getClassName(), "staticFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setStaticFloat() {
        JNIAccessor.setStaticFloat(Float.MAX_VALUE, getClassName(), "staticFloat", "F");
        assertThat(AccessorTestObject.staticFloat).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getStaticDouble() {
        AccessorTestObject.staticDouble = Math.PI;
        double readDouble = JNIAccessor.getStaticDouble(getClassName(), "staticDouble", "D");
        assertThat(readDouble).isEqualTo(Math.PI);
    }

    @Test
    void setStaticDouble() {
        JNIAccessor.setStaticDouble(Math.E, getClassName(), "staticDouble", "D");
        assertThat(AccessorTestObject.staticDouble).isEqualTo(Math.E);
    }

    @Test
    void getStaticBoolean() {
        AccessorTestObject.staticBoolean = true;
        boolean readBoolean = JNIAccessor.getStaticBoolean(getClassName(), "staticBoolean", "Z");
        assertThat(readBoolean).isTrue();
    }

    @Test
    void setStaticBoolean() {
        JNIAccessor.setStaticBoolean(true, getClassName(), "staticBoolean", "Z");
        assertThat(AccessorTestObject.staticBoolean).isTrue();
    }

    @Test
    void getStaticChar() {
        AccessorTestObject.staticChar = 'c';
        char readChar = JNIAccessor.getStaticChar(getClassName(), "staticChar", "C");
        assertThat(readChar).isEqualTo('c');
    }

    @Test
    void setStaticChar() {
        JNIAccessor.setStaticChar('c', getClassName(), "staticChar", "C");
        assertThat(AccessorTestObject.staticChar).isEqualTo('c');
    }

    @Test
    void getInstanceObject() {
        getAccessorTestObject().setInstanceString("some text");
        String readString = (String) JNIAccessor.getInstanceObject(getAccessorTestObject(), "instanceString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setInstanceObject() {
        JNIAccessor.setInstanceObject("some text", getAccessorTestObject(), "instanceString", "Ljava/lang/String;");
        assertThat(getAccessorTestObject().getInstanceString()).isEqualTo("some text");
    }

    @Test
    void getInstanceByte() {
        getAccessorTestObject().setInstanceByte(Byte.MAX_VALUE);
        byte readByte = JNIAccessor.getInstanceByte(getAccessorTestObject(), "instanceByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setInstanceByte() {
        JNIAccessor.setInstanceByte(Byte.MAX_VALUE, getAccessorTestObject(), "instanceByte", "B");
        assertThat(getAccessorTestObject().getInstanceByte()).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getInstanceShort() {
        getAccessorTestObject().setInstanceShort(Short.MAX_VALUE);
        short readShort = JNIAccessor.getInstanceShort(getAccessorTestObject(), "instanceShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setInstanceShort() {
        JNIAccessor.setInstanceShort(Short.MAX_VALUE, getAccessorTestObject(), "instanceShort", "S");
        assertThat(getAccessorTestObject().getInstanceShort()).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getInstanceInt() {
        getAccessorTestObject().setInstanceInt(Integer.MAX_VALUE);
        int readInt = JNIAccessor.getInstanceInt(getAccessorTestObject(), "instanceInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setInstanceInt() {
        JNIAccessor.setInstanceInt(Integer.MAX_VALUE, getAccessorTestObject(), "instanceInt", "I");
        assertThat(getAccessorTestObject().getInstanceInt()).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void getInstanceLong() {
        getAccessorTestObject().setInstanceLong(Long.MAX_VALUE);
        long readLong = JNIAccessor.getInstanceLong(getAccessorTestObject(), "instanceLong", "J");
        assertThat(readLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void setInstanceLong() {
        JNIAccessor.setInstanceLong(Long.MAX_VALUE, getAccessorTestObject(), "instanceLong", "J");
        assertThat(getAccessorTestObject().getInstanceLong()).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getInstanceFloat() {
        getAccessorTestObject().setInstanceFloat(Float.MIN_VALUE);
        float readFloat = JNIAccessor.getInstanceFloat(getAccessorTestObject(), "instanceFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setInstanceFloat() {
        JNIAccessor.setInstanceFloat(Float.MAX_VALUE, getAccessorTestObject(), "instanceFloat", "F");
        assertThat(getAccessorTestObject().getInstanceFloat()).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getInstanceDouble() {
        getAccessorTestObject().setInstanceDouble(Double.MIN_VALUE);
        double readDouble = JNIAccessor.getInstanceDouble(getAccessorTestObject(), "instanceDouble", "D");
        assertThat(readDouble).isEqualTo(Double.MIN_VALUE);
    }

    @Test
    void setInstanceDouble() {
        JNIAccessor.setInstanceDouble(Double.MAX_VALUE, getAccessorTestObject(), "instanceDouble", "D");
        assertThat(getAccessorTestObject().getInstanceDouble()).isEqualTo(Double.MAX_VALUE);
    }

    @Test
    void getInstanceBoolean() {
        getAccessorTestObject().setInstanceBoolean(false);
        boolean readBoolean = JNIAccessor.getInstanceBoolean(getAccessorTestObject(), "instanceBoolean", "Z");
        assertThat(readBoolean).isFalse();
    }

    @Test
    void setInstanceBoolean() {
        JNIAccessor.setInstanceBoolean(true, getAccessorTestObject(), "instanceBoolean", "Z");
        assertThat(getAccessorTestObject().isInstanceBoolean()).isTrue();
    }

    @Test
    void getInstanceChar() {
        getAccessorTestObject().setInstanceChar('c');
        char readDouble = JNIAccessor.getInstanceChar(getAccessorTestObject(), "instanceChar", "C");
        assertThat(readDouble).isEqualTo('c');
    }

    @Test
    void setInstanceChar() {
        JNIAccessor.setInstanceChar('c', getAccessorTestObject(), "instanceChar", "C");
        assertThat(getAccessorTestObject().getInstanceChar()).isEqualTo('c');
    }

    @Test
    void getInstances() {
        DummyObject instance = new DummyObject("bob", 11);
        DummyObject fetchedInstance =
                (DummyObject) JNIAccessor.getInstances("com/jnireflection/bindings/accessor/DummyObject")[0];
        assertThat(fetchedInstance.getString()).isEqualTo(instance.getString());
    }

}
