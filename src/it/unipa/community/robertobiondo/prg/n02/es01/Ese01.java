package it.unipa.community.robertobiondo.prg.n02.es01;

public class Ese01 {

    public static void main(String args[]) {
        int a = 5, b = 3;
        double r1 = (double) a / b;
        System.out.println(a + " / " + b + " = " + r1);
        char c = 'a';
        short s = 5000;
        int r2 = c * s;
        System.out.println(c + " * " + s + " = " + r2);
        int i = 6;
        float f = 3.14F;
        float r3 = (float) i + f;
        System.out.println(i + " + " + f + " = " + r3);
        double r4 = r1 - r2 - r3;
        System.out.println(r1 + " - " + r2 + " - " + " - " + r3 + " = " + r4);
    }
}
