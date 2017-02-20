package com.epam.calculator;

public class Calculator {

    public double multiple(double a, double b) {
        return a * b;
    }

    public int multiple(int a, int b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) throw new NumberFormatException("Second argument should'n br equal 0");
        else return a / b;
    }

    public double divide(int a, int b) {
        if (b == 0) throw new NumberFormatException("Second argument should'n br equal 0");
        else return a / b;
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public double addition(double a, double b) {
        return a + b;
    }

    public int subtruct(int a, int b) {
        return a - b;
    }

    public double subtruct(double a, double b) {
        return a - b;
    }

}
