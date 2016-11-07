package it.unipa.community.robertobiondo.prg.n04.es02;

/**
 *
 * @author Bob
 */
public class Main {
    public static void main(String args[]){
        Complex a = new Complex (1.5,0.5);
        Complex b = new Complex (0,1);
        System.out.println("Numero complesso a: " + a + " = " + a.toStringFormaRazionale());
        System.out.println("Numero complesso b: " + b+ " = " + b.toStringFormaRazionale());
        Complex ris = new Complex();
        ris=a.somma(b);
        System.out.println("a+b, metodo somma e stampa non static: ");
        ris.stampa();
        ris=Complex.somma(a,b);
        System.out.println("a+b, metodo somma e stampa static: ");
        Complex.stampa(ris);
    }
}
