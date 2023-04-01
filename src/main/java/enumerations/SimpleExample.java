package enumerations;

enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class SimpleExample {
    public static void main(String[] args) {
        Apple ap1 = Apple.Jonathan;
        System.out.println(ap1);
        if (ap1 == Apple.Jonathan) {
            System.out.println("equals");
        }

        switch (ap1) {
            case Jonathan -> System.out.println("Jonathan");
            case GoldenDel -> System.out.println("GoldenDel");
        }

        System.out.println();
        Apple[] allApples = Apple.values();
        for (Apple apple :allApples) {
            System.out.println(apple);
        }

        ap1 = Apple.valueOf("Jonathan");
        System.out.println(ap1);
    }
}
