package it.unipa.community.robertobiondo.prg.n01.es04;

public class TestRettangolo {

    public static void main(String args[]) {
        Rettangolo rett1 = new Rettangolo(2, 3);
        Rettangolo rett2 = new Rettangolo(5, 7);
        System.out.println("Rettangolo 1: base = 2, altezza = 3. \nRettangolo 2: base = 5, altezza = 7");
        System.out.println("Perimetro di Rettangolo 1: " + rett1.Perimetro() + "\nArea di Rettangolo 1: " + rett1.Area());
        System.out.println("Perimetro di Rettangolo 2: " + rett2.Perimetro() + "\nArea di Rettangolo 2: " + rett2.Area());
    }
}
