package it.unipa.community.robertobiondo.prg.n01.es03;

public class TestQuadrato {

    public static void main(String args[]) {
        Quadrato quadr1 = new Quadrato(2);
        // codice iniziale quadr1.lato=2;
        System.out.println("E' stato creato un oggetto della classe Quadrato, denominato quadr1 e di lato 2");
        System.out.println("Perimetro di quadr1:" + quadr1.Perimetro() + "\nArea di quadr1:" + quadr1.Area());
    }
}
//dopo aver aggiunto un costruttore alla classe quadrato, il codice new Quadrato() genera
//un errore, perchè il costruttore di default non viene aggiunto in compilazione,
//e il compilatore si aspetta in input una variabile intera per definire il lato
