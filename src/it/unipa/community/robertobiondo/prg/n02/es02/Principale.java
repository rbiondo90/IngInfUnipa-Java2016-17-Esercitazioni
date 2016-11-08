package it.unipa.community.robertobiondo.prg.n02.es02;

public class Principale {

    public static void main(String args[]) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        persona1.nome = "Mario";
        persona2.nome = "Luigi";
        persona1.cognome = "Rossi";
        persona2.cognome = "Verdi";
        persona1.eta = 35;
        persona2.eta = 32;
        Persona persona3 = persona1;
        System.out.println(persona1.dettagli() + persona2.dettagli() + persona3.dettagli());
    }
}
