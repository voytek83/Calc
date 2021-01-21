package com.company;


public class Calculations {

    static double calculation(double a, String dz, double b) {

        return switch (dz) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalStateException("Unexpected value: "+dz);
        };
    }
}


