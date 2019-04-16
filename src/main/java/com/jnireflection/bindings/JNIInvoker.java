package com.jnireflection.bindings;

import com.jnireflection.bindings.errors.MethodSignatureError;

import java.util.HashMap;
import java.util.Map;

public class JNIInvoker {

    private static final Map<String, MethodSignature> staticMethodParameterTypeCache = new HashMap<>();
    private static final Map<String, MethodSignature> instanceMethodParameterTypeCache = new HashMap<>();

    static {
        LibraryLoader.load();
    }

    public static Object invokeStaticMethod(String className, String methodName, String signature, Object[] arguments) {
        String methodId = className + methodName + signature;
        if (!staticMethodParameterTypeCache.containsKey(methodId)) {
            staticMethodParameterTypeCache.put(methodId, MethodSignature.parseSignature(signature));
        }

        MethodSignature methodSignature = staticMethodParameterTypeCache.get(methodId);
        if (arguments.length != methodSignature.getParameterTypes().length()) {
            throw new MethodSignatureError("Invalid return type: number of arguments does not match number of parameters");
        }

        return invokeGenericStaticMethod(className, methodName, signature, arguments, methodSignature);
    }


    private static Object invokeGenericStaticMethod(String className, String methodName, String signature, Object[] arguments, MethodSignature signatureInfo) {
        String parameterTypes = signatureInfo.getParameterTypes();
        switch (signatureInfo.getReturnType()) {
            case 'L':
                return invokeStaticObjectMethod(className, methodName, signature, arguments, parameterTypes);
        }

        throw new MethodSignatureError("Invalid return type: " + signatureInfo.getReturnType());
    }

    public static native Object invokeStaticObjectMethod(String className, String methodName, String signature, Object[] arguments, String parameterTypes);

}
