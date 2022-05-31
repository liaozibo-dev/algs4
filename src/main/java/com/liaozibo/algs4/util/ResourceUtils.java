package com.liaozibo.algs4.util;

import edu.princeton.cs.algs4.In;

import java.net.URL;
import java.nio.file.Paths;

public class ResourceUtils {
    private static final String dir = "algs4-data";

    public static In getResource(String filename) {
        String path = dir + "/" + filename;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL resource = classLoader.getResource(path);
        return new In(resource.getPath().substring(1));
    }
}
