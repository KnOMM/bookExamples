package org.example;

public abstract class A {

    private int varA = 0;
    abstract void callme();

    void callmetoo() {
        System.out.println("This is a concrete method");
    }
}
