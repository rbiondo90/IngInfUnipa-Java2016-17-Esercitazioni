package it.unipa.community.robertobiondo.prg.n01.es03;

public class Quadrato {

    public int lato;
    public final int NUMERO_LATI = 4;

    public int Area() {
        return lato * lato;
    }

    public int Perimetro() {
        return lato * NUMERO_LATI;
    }

    public Quadrato(int l) {
        lato = l;
    }
}
