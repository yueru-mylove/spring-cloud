package com.miracle.cloud.config;

public class TestClass extends Thread implements Runnable {

    @Override
    public void run() {

        System.out.println("test");
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new TestClass());
        thread.start();
    }
}
