package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest {
    @Test
    public void testProduct() {
        System.out.println("Hello world!");
        Map<String, Product> productsByName = new HashMap<>();

        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);

        Product nextPurchase = productsByName.get("Car");
        assertNull(nextPurchase);
    }

    public static void main(String[] args) {
        TestA testA = new TestA();
        TestA testA1 = new TestB();

        TestB testB = new TestB();
//        TestB testB1 = new TestA();  ERROR!!!!!

        testA.run();
        testA1.run();
        testB.run();


        TestA.hid();
        TestB.hid();

        TestB.hid(2);

        TestB.test();
        TestA.test();
    }
}
