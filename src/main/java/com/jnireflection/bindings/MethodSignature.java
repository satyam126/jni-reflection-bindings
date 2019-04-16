package com.jnireflection.bindings;

import com.jnireflection.bindings.errors.MethodSignatureError;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class MethodSignature {

    private static final Pattern signaturePattern = Pattern.compile("^\\(([LBCDFIJSZ]*)\\)([VLBCDFIJSZ])$");
    private static final Pattern objectTypePattern = Pattern.compile("L.+?;");

    @Getter
    private final String parameterTypes;

    @Getter
    private final char returnType;

    public static MethodSignature parseSignature(String methodSignature) {
        methodSignature = truncateObjectTypes(removeArrays(methodSignature));
        Matcher signatureMatcher = signaturePattern.matcher(methodSignature);

        if (signatureMatcher.find()) {
            char returnType = signatureMatcher.group(4).charAt(0);
            String parameterTypes = signatureMatcher.group(2);
            return new MethodSignature(parameterTypes, returnType);
        }

        throw new MethodSignatureError("Invalid method signature: " + methodSignature);
    }

    private static String removeArrays(String methodSignature) {
        return methodSignature.replace("[", "");
    }

    private static String truncateObjectTypes(String methodSignature) {
        return objectTypePattern.matcher(methodSignature).replaceAll("L");
    }

}
