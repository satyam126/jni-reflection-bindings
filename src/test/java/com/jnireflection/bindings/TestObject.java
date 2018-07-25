package com.jnireflection.bindings;

public class TestObject {

    public static String staticString;
    public static byte staticByte;
    public static short staticShort;
    public static int staticInt;
    public static long staticLong;
    public static float staticFloat;
    public static double staticDouble;
    public static boolean staticBoolean;
    public static char staticChar;

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

    public String getInstanceString() {
        return instanceString;
    }

    public void setInstanceString(String instanceString) {
        this.instanceString = instanceString;
    }

    public byte getInstanceByte() {
        return instanceByte;
    }

    public void setInstanceByte(byte instanceByte) {
        this.instanceByte = instanceByte;
    }

    public short getInstanceShort() {
        return instanceShort;
    }

    public void setInstanceShort(short instanceShort) {
        this.instanceShort = instanceShort;
    }

    public int getInstanceInt() {
        return instanceInt;
    }

    public void setInstanceInt(int instanceInt) {
        this.instanceInt = instanceInt;
    }

    public long getInstanceLong() {
        return instanceLong;
    }

    public void setInstanceLong(long instanceLong) {
        this.instanceLong = instanceLong;
    }

    public float getInstanceFloat() {
        return instanceFloat;
    }

    public void setInstanceFloat(float instanceFloat) {
        this.instanceFloat = instanceFloat;
    }

    public double getInstanceDouble() {
        return instanceDouble;
    }

    public void setInstanceDouble(double instanceDouble) {
        this.instanceDouble = instanceDouble;
    }

    public boolean isInstanceBoolean() {
        return instanceBoolean;
    }

    public void setInstanceBoolean(boolean instanceBoolean) {
        this.instanceBoolean = instanceBoolean;
    }

    public char getInstanceChar() {
        return instanceChar;
    }

    public void setInstanceChar(char instanceChar) {
        this.instanceChar = instanceChar;
    }

    public int[] getInstanceArray() {
        return instanceArray;
    }

    public void setInstanceArray(int[] instanceArray) {
        this.instanceArray = instanceArray;
    }

}
