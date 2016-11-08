package it.unipa.community.robertobiondo.prg.n01.es02;

public class NumeroIntero {

    public int numeroIntero;

    public void stampaNumero() {
        System.out.println(numeroIntero);
    }

    public NumeroIntero(int x) {
        numeroIntero = x;
    }
}

//La variabile numeroIntero appartiene alla tipologia di variabili d'istanza
//Con il costruttore di default, il valore assegnato ad una nuova variabile sarebbe 0
//con il costruttore definito in questo codice, se non specificassimo un valore
//verrebbe generato un errore
