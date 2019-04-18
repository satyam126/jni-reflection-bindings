package com.deimos.binding;

import com.deimos.LibraryLoader;
import com.deimos.error.MethodSignatureError;
import com.deimos.model.MethodSignature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Invoker {

    private static final Map<String, MethodSignature> staticMethodSignatureCache = new ConcurrentHashMap<>();
    private static final Map<String, MethodSignature> instanceMethodSignatureCache = new ConcurrentHashMap<>();
    private static final Map<String, MethodSignature> constructorMethodSignatureCache = new ConcurrentHashMap<>();

    static {
        LibraryLoader.load();
    }

    @SuppressWarnings("unchecked")
    public static <T> T invoke(String className, String methodName, String signature, Object... arguments) {
        MethodSignature methodSignature = fetchMethodSignature(staticMethodSignatureCache, className, methodName, signature);
        validateArgumentSize(methodSignature, arguments);
        return (T) invokeGenericStaticMethod(className, methodName, signature, arguments, methodSignature);
    }

    @SuppressWarnings("unchecked")
    public static <T> T invoke(Object instance, String methodName, String signature, Object... arguments) {
        String identifier = String.valueOf(instance.hashCode());
        MethodSignature methodSignature = fetchMethodSignature(instanceMethodSignatureCache, identifier, methodName, signature);
        validateArgumentSize(methodSignature, arguments);
        return (T) invokeGenericInstanceMethod(instance, methodName, signature, arguments, methodSignature);
    }

    @SuppressWarnings("unchecked")
    public static <T> T invoke(String className, String signature, Object... arguments) {
        MethodSignature methodSignature = fetchMethodSignature(constructorMethodSignatureCache, className, "<init>", signature);
        validateArgumentSize(methodSignature, arguments);
        return (T) invokeConstructor(className, signature, arguments, methodSignature.getParameterTypes());
    }

    private static void validateArgumentSize(MethodSignature methodSignature, Object[] arguments) {
        if (arguments.length != methodSignature.getParameterTypes().length()) {
            throw new MethodSignatureError("Argument mismatch: number of arguments does not match number of parameters");
        }
    }

    private static MethodSignature fetchMethodSignature(Map<String, MethodSignature> cache, String className, String methodName, String signature) {
        String methodId = className + methodName + signature;
        if (cache.containsKey(methodId)) {
            return cache.get(methodId);
        } else {
            MethodSignature methodSignature = MethodSignature.parseSignature(signature);
            cache.put(methodId, methodSignature);

            return methodSignature;
        }
    }

    private static Object invokeGenericStaticMethod(String className, String methodName, String signature, Object[] arguments, MethodSignature signatureInfo) {
        String parameterTypes = signatureInfo.getParameterTypes();
        char returnType = signatureInfo.getReturnType();

        switch (returnType) {
            case 'V':
                invokeStaticVoidMethod(className, methodName, signature, arguments, parameterTypes);
                return null;
            case 'L':
                return invokeStaticObjectMethod(className, methodName, signature, arguments, parameterTypes);
            case 'Z':
                return invokeStaticBooleanMethod(className, methodName, signature, arguments, parameterTypes);
            default:
                throw new MethodSignatureError("Invalid return type: " + signatureInfo.getReturnType());

        }
    }

    private static Object invokeGenericInstanceMethod(Object instance, String methodName, String signature, Object[] arguments, MethodSignature signatureInfo) {
        String parameterTypes = signatureInfo.getParameterTypes();
        char returnType = signatureInfo.getReturnType();

        switch (returnType) {
            case 'L':
                return invokeInstanceObjectMethod(instance, methodName, signature, arguments, parameterTypes);
            default:
                throw new MethodSignatureError("Invalid return type: " + signatureInfo.getReturnType());

        }
    }

    public static native void invokeStaticVoidMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native Object invokeStaticObjectMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native boolean invokeStaticBooleanMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native Object invokeInstanceObjectMethod(Object instance, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native Object invokeConstructor(String className, String signature, Object[] arguments, String parameterTypes);

}
