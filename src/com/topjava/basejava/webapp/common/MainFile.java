package com.topjava.basejava.webapp.common;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\gosha\\MyGit\\basejava\\src");
        System.out.println(file.getCanonicalPath());
        printDirectoryList(file);
    }

    private static void printDirectoryList(File rootDir) throws IOException {
        if (rootDir.isDirectory()) {
            for (File file : rootDir.listFiles()) {
                System.out.println(file);
                printDirectoryList(file);
            }
        }
    }
}
