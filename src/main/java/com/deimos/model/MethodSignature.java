package com.deimos.model;

import com.deimos.error.MethodSignatureError;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class MethodSignature {

    private static final Pattern signaturePattern = Pattern.compile("^\\(([LBCDFIJSZ]*)\\)([VLBCDFIJSZ])$");
    private static final Pattern objectTypePattern = Pattern.compile("L.+?;");
    private static final Pattern arrayPattern = Pattern.compile("\\[[LBCDFIJSZ]");

    private static final Map<String, MethodSignature> cache = new ConcurrentHashMap<>();

    @Getter
    private final String signature;

    @Getter
    private final String parameterTypes;

    @Getter
    private final char returnType;

    public static MethodSignature fetch(String signature) {
        if (cache.containsKey(signature)) {
            return cache.get(signature);
        } else {
            var methodSignature = MethodSignature.parse(signature);
            cache.put(signature, methodSignature);
            return methodSignature;
        }
    }

    public static MethodSignature parse(String signature) {
        var desugaredSignature = transformArraysToObjects(truncateObjectTypes(signature));
        var signatureMatcher = signaturePattern.matcher(desugaredSignature);

        if (signatureMatcher.find()) {
            var parameterTypes = signatureMatcher.group(1);
            var returnType = signatureMatcher.group(2).charAt(0);
            return new MethodSignature(signature, parameterTypes, returnType);
        }

        throw new MethodSignatureError("Invalid method signature: " + signature);
    }

    private static String transformArraysToObjects(String methodSignature) {
        return arrayPattern.matcher(methodSignature).replaceAll("L");
    }

    private static String truncateObjectTypes(String methodSignature) {
        return objectTypePattern.matcher(methodSignature).replaceAll("L");
    }

}
