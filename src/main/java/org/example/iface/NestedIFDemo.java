package org.example.iface;

public class NestedIFDemo {
    public static void main(String[] args) {

        // use a nested interface reference
        A.NestedIF nif = new B();

        if (nif.isNotNegative(5)) System.out.println("positive");
        else System.out.println("negative");
    }
}
