package com.deimos.binding;

import com.deimos.LibraryLoader;

public class Accessor {

    static {
        LibraryLoader.load();
    }

    public static native Object getStaticObject(String className, String fieldName, String signature);

    public static native void setStaticObject(Object newObject, String className, String fieldName, String signature);

    public static native byte getStaticByte(String className, String fieldName, String signature);

    public static native void setStaticByte(byte newByte, String className, String fieldName, String signature);

    public static native short getStaticShort(String className, String fieldName, String signature);

    public static native void setStaticShort(short newShort, String className, String fieldName, String signature);

    public static native int getStaticInt(String className, String fieldName, String signature);

    public static native void setStaticInt(int newInt, String className, String fieldName, String signature);

    public static native long getStaticLong(String className, String fieldName, String signature);

    public static native void setStaticLong(long newLong, String className, String fieldName, String signature);

    public static native float getStaticFloat(String className, String fieldName, String signature);

    public static native void setStaticFloat(float newFloat, String className, String fieldName, String signature);

    public static native double getStaticDouble(String className, String fieldName, String signature);

    public static native void setStaticDouble(double newDouble, String className, String fieldName, String signature);

    public static native boolean getStaticBoolean(String className, String fieldName, String signature);

    public static native void setStaticBoolean(boolean newBoolean, String className, String fieldName, String
            signature);

    public static native char getStaticChar(String className, String fieldName, String signature);

    public static native void setStaticChar(char newChar, String className, String fieldName, String signature);

    public static native Object getInstanceObject(Object instance, String fieldName, String signature);

    public static native void setInstanceObject(Object newObject, Object instance, String fieldName, String signature);

    public static native byte getInstanceByte(Object instance, String fieldName, String signature);

    public static native void setInstanceByte(byte newByte, Object instance, String fieldName, String signature);

    public static native short getInstanceShort(Object instance, String fieldName, String signature);

    public static native void setInstanceShort(short newShort, Object instance, String fieldName, String signature);

    public static native int getInstanceInt(Object instance, String fieldName, String signature);

    public static native void setInstanceInt(int newInt, Object instance, String fieldName, String signature);

    public static native long getInstanceLong(Object instance, String fieldName, String signature);

    public static native void setInstanceLong(long newLong, Object instance, String fieldName, String signature);

    public static native float getInstanceFloat(Object instance, String fieldName, String signature);

    public static native void setInstanceFloat(float newFloat, Object instance, String fieldName, String signature);

    public static native double getInstanceDouble(Object instance, String fieldName, String signature);

    public static native void setInstanceDouble(double newDouble, Object instance, String fieldName, String signature);

    public static native boolean getInstanceBoolean(Object instance, String fieldName, String signature);

    public static native void setInstanceBoolean(boolean newBoolean, Object instance, String fieldName, String
            signature);

    public static native char getInstanceChar(Object instance, String fieldName, String signature);

    public static native void setInstanceChar(char newChar, Object instance, String fieldName, String signature);

    public static native Object[] getInstances(String className);

}
