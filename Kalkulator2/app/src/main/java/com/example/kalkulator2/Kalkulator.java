package com.example.kalkulator2;

public class Kalkulator {
    public static double dodaj(double a, double b) {
        return a + b;
    }

    public static double odejmij(double a, double b) {
        return a - b;
    }

    public static double mnoz(double a, double b) {
        return a * b;
    }

    public static double dziel(double a, double b) {
        if (b == 0) throw new ArithmeticException("Nie można dzielić przez zero");
        return a / b;
    }

    public static double poteguj(double a, double b) {
        return Math.pow(a, b);
    }

    public static double pierwiastkuj(double a, double n) {
        if (a < 0 && n % 2 == 0) {
            throw new IllegalArgumentException("Nie można obliczyć pierwiastka z liczby ujemnej dla parzystego stopnia");
        }
        return Math.pow(a, 1.0 / n);
    }

    public static double silnia(double a) {
        if (a <= 1) {
            return 1;
        }
        else {
            return a * silnia(a - 1);
        }
    }
}
