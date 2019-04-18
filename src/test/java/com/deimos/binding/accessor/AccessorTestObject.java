package com.deimos.binding.accessor;

import lombok.Getter;
import lombok.Setter;

class AccessorTestObject {

    static String staticString;
    static byte staticByte;
    static short staticShort;
    static int staticInt;
    static long staticLong;
    static float staticFloat;
    static double staticDouble;
    static boolean staticBoolean;
    static char staticChar;

    @Getter
    @Setter
    private String instanceString;

    @Getter
    @Setter
    private byte instanceByte;

    @Getter
    @Setter
    private short instanceShort;

    @Getter
    @Setter
    private int instanceInt;

    @Getter
    @Setter
    private long instanceLong;

    @Getter
    @Setter
    private float instanceFloat;

    @Getter
    @Setter
    private double instanceDouble;

    @Getter
    @Setter
    private boolean instanceBoolean;

    @Getter
    @Setter
    private char instanceChar;

}
