package com.deimos;

public class LibraryLoader {

    private static boolean loaded = false;

    /**
     * Loads the native library
     */
    public static void load() {
        if (loaded) {
            return;
        }

        String devLibraryPath = System.getenv("dev_library_path");
        if (devLibraryPath != null) {
            System.load(devLibraryPath);
        } else {
            System.loadLibrary("jni-reflection");
        }

        loaded = true;
    }

}
