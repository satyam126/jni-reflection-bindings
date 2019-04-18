package com.deimos.binding.accessor;

import com.deimos.binding.Accessor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccessorTest extends AbstractAccessorTest {

    @Test
    void getStaticObject() {
        AccessorTestObject.staticString = "some text";
        String readString = (String) Accessor.getStaticObject(getClassName(), "staticString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setStaticObject() {
        Accessor.setStaticObject("some new text", getClassName(), "staticString", "Ljava/lang/String;");
        assertThat(AccessorTestObject.staticString).isEqualTo("some new text");
    }

    @Test
    void getStaticByte() {
        AccessorTestObject.staticByte = Byte.MAX_VALUE;
        byte readByte = Accessor.getStaticByte(getClassName(), "staticByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setStaticByte() {
        Accessor.setStaticByte(Byte.MAX_VALUE, getClassName(), "staticByte", "B");
        assertThat(AccessorTestObject.staticByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getStaticShort() {
        AccessorTestObject.staticShort = Short.MAX_VALUE;
        short readShort = Accessor.getStaticShort(getClassName(), "staticShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setStaticShort() {
        Accessor.setStaticShort(Short.MAX_VALUE, getClassName(), "staticShort", "S");
        assertThat(AccessorTestObject.staticShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getStaticInt() {
        AccessorTestObject.staticInt = Integer.MAX_VALUE;
        int readInt = Accessor.getStaticInt(getClassName(), "staticInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setStaticInt() {
        Accessor.setStaticInt(Integer.MIN_VALUE, getClassName(), "staticInt", "I");
        assertThat(AccessorTestObject.staticInt).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void getStaticLong() {
        AccessorTestObject.staticLong = Long.MIN_VALUE;
        long readLong = Accessor.getStaticLong(getClassName(), "staticLong", "J");
        assertThat(readLong).isEqualTo(Long.MIN_VALUE);
    }

    @Test
    void setStaticLong() {
        Accessor.setStaticLong(Long.MAX_VALUE, getClassName(), "staticLong", "J");
        assertThat(AccessorTestObject.staticLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getStaticFloat() {
        AccessorTestObject.staticFloat = Float.MIN_VALUE;
        float readFloat = Accessor.getStaticFloat(getClassName(), "staticFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setStaticFloat() {
        Accessor.setStaticFloat(Float.MAX_VALUE, getClassName(), "staticFloat", "F");
        assertThat(AccessorTestObject.staticFloat).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getStaticDouble() {
        AccessorTestObject.staticDouble = Math.PI;
        double readDouble = Accessor.getStaticDouble(getClassName(), "staticDouble", "D");
        assertThat(readDouble).isEqualTo(Math.PI);
    }

    @Test
    void setStaticDouble() {
        Accessor.setStaticDouble(Math.E, getClassName(), "staticDouble", "D");
        assertThat(AccessorTestObject.staticDouble).isEqualTo(Math.E);
    }

    @Test
    void getStaticBoolean() {
        AccessorTestObject.staticBoolean = true;
        boolean readBoolean = Accessor.getStaticBoolean(getClassName(), "staticBoolean", "Z");
        assertThat(readBoolean).isTrue();
    }

    @Test
    void setStaticBoolean() {
        Accessor.setStaticBoolean(true, getClassName(), "staticBoolean", "Z");
        assertThat(AccessorTestObject.staticBoolean).isTrue();
    }

    @Test
    void getStaticChar() {
        AccessorTestObject.staticChar = 'c';
        char readChar = Accessor.getStaticChar(getClassName(), "staticChar", "C");
        assertThat(readChar).isEqualTo('c');
    }

    @Test
    void setStaticChar() {
        Accessor.setStaticChar('c', getClassName(), "staticChar", "C");
        assertThat(AccessorTestObject.staticChar).isEqualTo('c');
    }

    @Test
    void getInstanceObject() {
        getObject().setInstanceString("some text");
        String readString = (String) Accessor.getInstanceObject(getObject(), "instanceString",
                "Ljava/lang/String;");
        assertThat(readString).isEqualTo("some text");
    }

    @Test
    void setInstanceObject() {
        Accessor.setInstanceObject("some text", getObject(), "instanceString", "Ljava/lang/String;");
        assertThat(getObject().getInstanceString()).isEqualTo("some text");
    }

    @Test
    void getInstanceByte() {
        getObject().setInstanceByte(Byte.MAX_VALUE);
        byte readByte = Accessor.getInstanceByte(getObject(), "instanceByte", "B");
        assertThat(readByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void setInstanceByte() {
        Accessor.setInstanceByte(Byte.MAX_VALUE, getObject(), "instanceByte", "B");
        assertThat(getObject().getInstanceByte()).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getInstanceShort() {
        getObject().setInstanceShort(Short.MAX_VALUE);
        short readShort = Accessor.getInstanceShort(getObject(), "instanceShort", "S");
        assertThat(readShort).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void setInstanceShort() {
        Accessor.setInstanceShort(Short.MAX_VALUE, getObject(), "instanceShort", "S");
        assertThat(getObject().getInstanceShort()).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getInstanceInt() {
        getObject().setInstanceInt(Integer.MAX_VALUE);
        int readInt = Accessor.getInstanceInt(getObject(), "instanceInt", "I");
        assertThat(readInt).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void setInstanceInt() {
        Accessor.setInstanceInt(Integer.MAX_VALUE, getObject(), "instanceInt", "I");
        assertThat(getObject().getInstanceInt()).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void getInstanceLong() {
        getObject().setInstanceLong(Long.MAX_VALUE);
        long readLong = Accessor.getInstanceLong(getObject(), "instanceLong", "J");
        assertThat(readLong).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void setInstanceLong() {
        Accessor.setInstanceLong(Long.MAX_VALUE, getObject(), "instanceLong", "J");
        assertThat(getObject().getInstanceLong()).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getInstanceFloat() {
        getObject().setInstanceFloat(Float.MIN_VALUE);
        float readFloat = Accessor.getInstanceFloat(getObject(), "instanceFloat", "F");
        assertThat(readFloat).isEqualTo(Float.MIN_VALUE);
    }

    @Test
    void setInstanceFloat() {
        Accessor.setInstanceFloat(Float.MAX_VALUE, getObject(), "instanceFloat", "F");
        assertThat(getObject().getInstanceFloat()).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getInstanceDouble() {
        getObject().setInstanceDouble(Double.MIN_VALUE);
        double readDouble = Accessor.getInstanceDouble(getObject(), "instanceDouble", "D");
        assertThat(readDouble).isEqualTo(Double.MIN_VALUE);
    }

    @Test
    void setInstanceDouble() {
        Accessor.setInstanceDouble(Double.MAX_VALUE, getObject(), "instanceDouble", "D");
        assertThat(getObject().getInstanceDouble()).isEqualTo(Double.MAX_VALUE);
    }

    @Test
    void getInstanceBoolean() {
        getObject().setInstanceBoolean(false);
        boolean readBoolean = Accessor.getInstanceBoolean(getObject(), "instanceBoolean", "Z");
        assertThat(readBoolean).isFalse();
    }

    @Test
    void setInstanceBoolean() {
        Accessor.setInstanceBoolean(true, getObject(), "instanceBoolean", "Z");
        assertThat(getObject().isInstanceBoolean()).isTrue();
    }

    @Test
    void getInstanceChar() {
        getObject().setInstanceChar('c');
        char readDouble = Accessor.getInstanceChar(getObject(), "instanceChar", "C");
        assertThat(readDouble).isEqualTo('c');
    }

    @Test
    void setInstanceChar() {
        Accessor.setInstanceChar('c', getObject(), "instanceChar", "C");
        assertThat(getObject().getInstanceChar()).isEqualTo('c');
    }

    @Test
    void getInstances() {
        DummyObject instance = new DummyObject("bob", 11);
        DummyObject fetchedInstance = (DummyObject) Accessor.getInstances(
                DummyObject.class.getName().replace(".", "/")
        )[0];
        assertThat(fetchedInstance.getString()).isEqualTo(instance.getString());
    }

}
