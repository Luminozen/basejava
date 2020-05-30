package com.topjava.basejava.webapp.common;

import com.topjava.basejava.webapp.exception.StorageException;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static String indent = " ";

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\gosha\\MyGit\\basejava\\src");
        System.out.println(file.getCanonicalPath());
        printDirectoryList(file);
    }

    private static void printDirectoryList(File rootDir) {
        File[] dirFiles;
        if (rootDir.isDirectory()) {
            indent+=" ";
            dirFiles = rootDir.listFiles();
            if(dirFiles==null) {
                throw new StorageException("Directory read error", rootDir.getName());
            }
            for (File file : dirFiles) {
                System.out.println(indent+file.getName());
                printDirectoryList(file);
            }
            indent = indent.substring(1);
        }
    }
}
