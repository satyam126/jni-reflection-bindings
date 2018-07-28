package com.jnireflection.bindings;

class TestObject {

    static String staticString;
    static byte staticByte;
    static short staticShort;
    static int staticInt;
    static long staticLong;
    static float staticFloat;
    static double staticDouble;
    static boolean staticBoolean;
    static char staticChar;

    private String instanceString;
    private byte instanceByte;
    private short instanceShort;
    private int instanceInt;
    private long instanceLong;
    private float instanceFloat;
    private double instanceDouble;
    private boolean instanceBoolean;
    private char instanceChar;
    private int[] instanceArray;

    String getInstanceString() {
        return instanceString;
    }

    void setInstanceString(String instanceString) {
        this.instanceString = instanceString;
    }

    byte getInstanceByte() {
        return instanceByte;
    }

    void setInstanceByte(byte instanceByte) {
        this.instanceByte = instanceByte;
    }

    short getInstanceShort() {
        return instanceShort;
    }

    void setInstanceShort(short instanceShort) {
        this.instanceShort = instanceShort;
    }

    int getInstanceInt() {
        return instanceInt;
    }

    void setInstanceInt(int instanceInt) {
        this.instanceInt = instanceInt;
    }

    long getInstanceLong() {
        return instanceLong;
    }

    void setInstanceLong(long instanceLong) {
        this.instanceLong = instanceLong;
    }

    float getInstanceFloat() {
        return instanceFloat;
    }

    void setInstanceFloat(float instanceFloat) {
        this.instanceFloat = instanceFloat;
    }

    double getInstanceDouble() {
        return instanceDouble;
    }

    void setInstanceDouble(double instanceDouble) {
        this.instanceDouble = instanceDouble;
    }

    boolean isInstanceBoolean() {
        return instanceBoolean;
    }

    void setInstanceBoolean(boolean instanceBoolean) {
        this.instanceBoolean = instanceBoolean;
    }

    char getInstanceChar() {
        return instanceChar;
    }

    void setInstanceChar(char instanceChar) {
        this.instanceChar = instanceChar;
    }

    int[] getInstanceArray() {
        return instanceArray;
    }

    void setInstanceArray(int[] instanceArray) {
        this.instanceArray = instanceArray;
    }

}
