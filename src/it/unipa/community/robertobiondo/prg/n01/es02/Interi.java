package it.unipa.community.robertobiondo.prg.n01.es02;

public class Interi {

    public static void main(String args[]) {
        NumeroIntero n1 = new NumeroIntero(0);
        NumeroIntero n2 = new NumeroIntero(0);
        n1.stampaNumero();
        n2.stampaNumero();
        n1.numeroIntero = 3;
        n2.numeroIntero = 4;
        n1.stampaNumero();
        n2.stampaNumero();
    }
}
