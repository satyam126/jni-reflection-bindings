package com.jnireflection.bindings;

public class JNIReflection {

    /**
     * Loads the native library
     */
    public static void loadLibrary() {
        String devLibraryPath = System.getenv("dev_library_path");
        if (devLibraryPath != null) {
            System.load(devLibraryPath);
        } else {
            System.loadLibrary("jni-reflection");
        }
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

    public static native void setInstanceObject(Object instance,String fieldName, String signature, Object newObject);

    public static native Object[] getInstances(String className);

}
