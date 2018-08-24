package com.jnireflection.bindings;

import com.jnireflection.bindings.errors.MethodSignatureError;
import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class MethodSignatureInfo {

    private static final Pattern signaturePattern = Pattern.compile("(\\()(.*)(\\))(.+)");
    private static final Pattern objectTypePattern = Pattern.compile("L.+?;");

    @Getter
    private final String parameterTypes;

    @Getter
    private final char returnType;

    public static MethodSignatureInfo parseSignature(String methodSignature) {
        Matcher signatureMatcher = signaturePattern.matcher(methodSignature);

        if (signatureMatcher.find()) {
            char returnType = signatureMatcher.group(4).charAt(0);
            String parameterTypes = signatureMatcher.group(2);

            Matcher objectTypeMatcher = objectTypePattern.matcher(parameterTypes);
            String tidyParameterTypes = objectTypeMatcher.replaceAll("L");

            return new MethodSignatureInfo(tidyParameterTypes, returnType);
        }

        throw new MethodSignatureError("Invalid method signature: " + methodSignature);
    }

}
