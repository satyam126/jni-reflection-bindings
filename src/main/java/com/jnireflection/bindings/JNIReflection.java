package com.jnireflection.bindings;

import com.jnireflection.bindings.errors.MethodSignatureError;

import java.util.HashMap;

public class JNIReflection {

    private static final HashMap<String, MethodSignatureInfo> staticMethodParameterTypeCache = new HashMap<>();
    private static final HashMap<String, MethodSignatureInfo> instanceMethodParameterTypeCache = new HashMap<>();

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

    public static Object invokeStaticMethod(String className, String methodName, String signature, Object[] arguments) {
        String methodId = className + methodName + signature;
        if (!staticMethodParameterTypeCache.containsKey(methodId)) {
            staticMethodParameterTypeCache.put(methodId, MethodSignatureInfo.parseSignature(signature));
        }

        MethodSignatureInfo methodSignatureInfo = staticMethodParameterTypeCache.get(methodId);
        if (arguments.length != methodSignatureInfo.getParameterTypes().length()) {
            throw new MethodSignatureError("Invalid return type: number of arguments does not match number of parameters");
        }

        return invokeGenericStaticMethod(className, methodName, signature, arguments, methodSignatureInfo);
    }


    private static Object invokeGenericStaticMethod(String className, String methodName, String signature, Object[] arguments, MethodSignatureInfo signatureInfo) {
        int argumentCount = arguments.length;
        String parameterTypes = signatureInfo.getParameterTypes();

        switch (signatureInfo.getReturnType()) {
            case 'L':
               return invokeStaticObjectMethod(className, methodName, signature, arguments, parameterTypes, argumentCount);
        }

        throw new MethodSignatureError("Invalid return type: " + signatureInfo.getReturnType());
    }

    public static native Object invokeStaticObjectMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes, int argumentCount);

    public static native Object[] getInstances(String className);

}
