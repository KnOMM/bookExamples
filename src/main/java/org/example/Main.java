package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.callme();
        b.callmetoo();

//      dynamic method dispatch - during runtime
        A a = new B();
        a.callme();
        a.callmetoo();

//      compile-time error
//      A abst = new A();

        B b1 = new B();
        B b2 = new B();
//      b1 and b3 refer to the same memory field
        A b3 = b1;
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b3));
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b3.hashCode());

        System.out.println(Arrays.toString(args));

    }
}