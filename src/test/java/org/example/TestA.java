package org.example;

public class TestA {
    public Object run(){
        System.out.println("TestA");
        return "null";
    }

    public void run2(){
        System.out.println("run2 in TestA");
    }

    public static void hid(){
        System.out.println("A hiding");
    }

    public static void test(){
        System.out.println("A test");
    }
}
