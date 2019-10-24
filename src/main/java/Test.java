package main.java;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        char[][] tak = new char[18][4];
        int test = ((2 * 0xdb)%0xFF) ^ ((3 * 0x13)%0xFF) ^ 0x53 ^ 0x45;
        test = test & 0xFF;
        System.out.println(test);
    }
}