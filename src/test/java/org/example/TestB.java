package org.example;

public class TestB extends TestA{
    @Override
    public String run(){
        super.run();
        System.out.println("TestB --------------");
        return "null";
    }

    public static void run3(int... a){
        System.out.println("run2 in TestB");
    }

    public static void hid(){
        System.out.println("B hiding");
    }

    public static void hid(int i){
        System.out.println(i + " in B hiding");
    }

    public static void test(){
        System.out.println("B test");
    }
}
