package it.unipa.community.robertobiondo.prg.n01.es05;

import java.util.Random; //Importo la classe per utilizzare oggetti random

public class Moneta {

    Random rand = new Random();
    public int faccia; //la faccia della moneta viene inizializzata come un intero

    public void Lancia() {
        faccia = rand.nextInt(2); //Il metodo nextInt dell'oggetto rand della classe Random, associato al parametro intero 2, restituisce un intero casuale tra 0 e 1
    }

    public void StampaFaccia() {
        //Questo metodo stampa testa o croce a seconda del valore della variabile faccia
        if (faccia == 0) {
            System.out.println("Croce.");
        } else {
            System.out.println("Testa");
        }
    }
}
//versione del professore:
/*
public class Moneta{
	public Random r;
	public Moneta(){
		r = new Random();
	}
	public int lancia(){
		return r.nextInt(2);
	}
}
*/
