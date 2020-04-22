package com.topjava.basejava.webapp.common;

public class TestSingleton {
    private static TestSingleton ourInstance = new TestSingleton();

    public TestSingleton getInstance(){
        return ourInstance;
    }

    private TestSingleton(){}
}
