package com.deimos.binding;

import com.deimos.LibraryLoader;
import com.deimos.error.MethodSignatureError;
import com.deimos.model.MethodSignature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Invoker {

    private static final Map<String, MethodSignature> methodSignatureCache = new ConcurrentHashMap<>();

    static {
        LibraryLoader.load();
    }

    @SuppressWarnings("unchecked")
    public static <T> T invokeStatic(String className, String methodName, String signature, Object... arguments) {
        var methodSignature = getMethodSignature(signature);
        validateArgumentSize(methodSignature, arguments);
        return (T) invokeGenericStaticMethod(className, methodName, methodSignature, arguments);
    }

    @SuppressWarnings("unchecked")
    public static <T> T invoke(Object instance, String methodName, String signature, Object... arguments) {
        var methodSignature = getMethodSignature(signature);
        validateArgumentSize(methodSignature, arguments);
        return (T) invokeGenericInstanceMethod(instance, methodName, methodSignature, arguments);
    }

    @SuppressWarnings("unchecked")
    public static <T> T invokeNew(String className, String signature, Object... arguments) {
        var methodSignature = getMethodSignature(signature);
        validateArgumentSize(methodSignature, arguments);
        return (T) invokeConstructor(className, signature, arguments, methodSignature.getParameterTypes());
    }

    private static void validateArgumentSize(MethodSignature methodSignature, Object[] arguments) {
        if (arguments.length != methodSignature.getParameterTypes().length()) {
            throw new MethodSignatureError("Argument mismatch: number of arguments does not match number of parameters");
        }
    }

    private static MethodSignature getMethodSignature(String signature) {
        if (methodSignatureCache.containsKey(signature)) {
            return methodSignatureCache.get(signature);
        } else {
            var methodSignature = MethodSignature.parseSignature(signature);
            methodSignatureCache.put(signature, methodSignature);
            return methodSignature;
        }
    }

    private static Object invokeGenericStaticMethod(String className, String methodName, MethodSignature signature, Object[] arguments) {
        var parameterTypes = signature.getParameterTypes();
        var returnType = signature.getReturnType();

        switch (returnType) {
            case 'V':
                invokeStaticVoidMethod(className, methodName, signature.getSignature(), arguments, parameterTypes);
                return null;
            case 'L':
                return invokeStaticObjectMethod(className, methodName, signature.getSignature(), arguments, parameterTypes);
            case 'Z':
                return invokeStaticBooleanMethod(className, methodName, signature.getSignature(), arguments, parameterTypes);
            default:
                throw new MethodSignatureError("Invalid return type: " + signature.getReturnType());
        }
    }

    private static Object invokeGenericInstanceMethod(Object instance, String methodName, MethodSignature signature, Object[] arguments) {
        var parameterTypes = signature.getParameterTypes();
        var returnType = signature.getReturnType();

        switch (returnType) {
            case 'L':
                return invokeInstanceObjectMethod(instance, methodName, signature.getSignature(), arguments, parameterTypes);
            default:
                throw new MethodSignatureError("Invalid return type: " + signature.getReturnType());

        }
    }

    public static native void invokeStaticVoidMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native Object invokeStaticObjectMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native boolean invokeStaticBooleanMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native Object invokeInstanceObjectMethod(Object instance, String methodName, String signature, Object[] arguments, String parameterTypes);

    public static native Object invokeConstructor(String className, String signature, Object[] arguments, String parameterTypes);

}
