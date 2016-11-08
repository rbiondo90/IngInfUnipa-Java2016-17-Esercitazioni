package it.unipa.community.robertobiondo.prg.n01.es04;

public class Rettangolo {

    public int base;
    public int altezza;

    public int Area() {
        return base * altezza;
    }

    public int Perimetro() {
        return base * (2) + altezza * (2);
    }

    public Rettangolo(int b, int a) {
        base = b;
        altezza = a;
    }
}
