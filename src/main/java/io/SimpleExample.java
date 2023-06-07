package io;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleExample {
    @SneakyThrows
    public static void main(String[] args) {
        System.err.println("System error!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String s = String.valueOf(br.readLine());
        char c;
//        (char)br.read();
//        System.out.println(c);
//        System.out.println(s);
        while ((c = (char) br.read()) != 'q') {
            System.out.println(c);
        }
        System.out.write(100);
        System.out.println("sdsds");
    }
}
