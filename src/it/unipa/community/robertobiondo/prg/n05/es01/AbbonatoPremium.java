/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es01;

import it.unipa.community.robertobiondo.prg.n04.es04.Date;

/**
 *
 * @author Bob
 */
public class AbbonatoPremium extends Abbonato {

    public final int SOGLIA_PER_ACQUISTO_BONUS = 100;
    private int acquistiBonus = 0;
    private int spesaAccumulata = 0;

    public AbbonatoPremium(Date dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap, byte sconto) {
        super(dataDiNascita, nome, cognome, codiceFiscale, indirizzo, città, cap, sconto);
    }

    public AbbonatoPremium(String dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap, byte sconto) {
        this(new Date(dataDiNascita), nome, cognome, codiceFiscale, indirizzo, città, cap, sconto);
    }

    public AbbonatoPremium(Abbonato abbonato) {
        this(abbonato.getDataDiNascita(), abbonato.getNome(), abbonato.getCognome(), abbonato.getCodiceFiscale(), abbonato.getIndirizzo(), abbonato.getCittà(), abbonato.getCap(), abbonato.getSconto());
    }

    public AbbonatoPremium(Persona persona, byte sconto) {
        this(persona.getDataDiNascita(), persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), persona.getIndirizzo(), persona.getCittà(), persona.getCap(), sconto);
    }

    public int getAcquistiBonus() {
        return (this.getValiditàRecord()) ? acquistiBonus : 0;
    }

    public int getSpesaAccumulata() {
        return (this.getValiditàRecord()) ? spesaAccumulata : 0;
    }

    public void accumulaSpesa(int spesa) {
        if (this.getValiditàRecord()) {
            if (spesa > 0) {
                int bonus = 0;
                this.spesaAccumulata += spesa;
                while (spesaAccumulata >= 100) {
                    spesaAccumulata -= 100;
                    bonus++;
                }
                this.acquistiBonus += bonus;
                System.out.println("\nSono stati spesi " + spesa + "€. Accumulati " + bonus + " acquisti bonus." + "\nTotale acquisti bonus: " + acquistiBonus + "\nSpesa residua accumulata: " + spesaAccumulata);

            } else {
                System.out.println("\nImporto errato.");
            }
        }
    }

    public void effettuaAcquistiBonus(int n) {
        if (this.getValiditàRecord()) {
            if (n <= this.acquistiBonus) {
                this.acquistiBonus -= n;
                System.out.println("\nEffettuati " + n + " acquisti bonus. Ne rimangono " + this.acquistiBonus + ".");
            } else {
                System.out.println("\nAcquisti bonus accumulati non sufficienti.");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        if (this.getValiditàRecord()) {
            s.append("\nSpesa accumulata: ").append(this.getSpesaAccumulata()).append("\nAcquisti bonus disponibili: ").append(this.getAcquistiBonus());
        }
        return s.toString();
    }

    @Override
    public void stampaDati() {
        System.out.println(this);
    }
}
