package it.unipa.community.robertobiondo.prg.n01.es07;

import java.util.Random; //Importo la classe per utilizzare oggetti random

public class Ruota {

    Random rand = new Random();
    public int pressione;
    public double coeffpressione;

    public Ruota() {
        pressione = 100;
        coeffpressione = rand.nextDouble(); //il coefficiente di riduzione della pressione viene generato casualmente tra 0 e 1
    }
}
