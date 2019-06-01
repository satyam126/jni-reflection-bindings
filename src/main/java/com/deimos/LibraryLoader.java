package com.deimos;

public class LibraryLoader {

    private static boolean loaded = false;

    /**
     * Loads the native library
     */
    public static synchronized void load() {
        if (loaded) {
            return;
        }

        var devLibraryPath = System.getenv("library_path");
        if (devLibraryPath != null) {
            System.load(devLibraryPath);
        } else {
            System.loadLibrary("jni-reflection");
        }

        loaded = true;
    }

}
