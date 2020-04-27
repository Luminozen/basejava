package com.topjava.basejava.webapp.common;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\gosha\\MyGit\\basejava\\.gitignore");
        System.out.println(file.getCanonicalPath());
    }
}
