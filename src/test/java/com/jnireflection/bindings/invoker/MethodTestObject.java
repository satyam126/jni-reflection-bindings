package com.jnireflection.bindings.invoker;

import lombok.Data;

import java.util.Arrays;

@Data
public class MethodTestObject {

    public static String staticEmptyParameter() {
        return "ok";
    }

    public static String staticObjectParameter(String a) {
        return a;
    }

    public static String staticArrayParameter(int[] a) {
        return Arrays.toString(a);
    }

    public static String staticByteParameter(byte a) {
        return String.valueOf(a);
    }

    public static String staticCharParameter(char a) {
        return String.valueOf(a);
    }

    public static String staticDoubleParameter(double a) {
        return String.valueOf(a);
    }

    public static String staticFloatParameter(float a) {
        return String.valueOf(a);
    }

    public static String staticIntegerParameter(int a) {
        return String.valueOf(a);
    }

    public static String staticLongParameter(long a) {
        return String.valueOf(a);
    }

    public static String staticShortParameter(short a) {
        return String.valueOf(a);
    }

    public static String staticBooleanParameter(boolean a) {
        return String.valueOf(a);
    }

}
