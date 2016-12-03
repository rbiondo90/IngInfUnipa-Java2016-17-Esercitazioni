/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es07;

import it.unipa.community.robertobiondo.prg.n08.es07.Carta.Seme;
import it.unipa.community.robertobiondo.prg.n08.es07.Carta.ValoreCarta;
import robertobiondo.utilities.Utils;


/**
 *
 * @author Roberto Biondo
 */
public class Mazzo{

    public final Carta[] carte = new Carta[NUMERO_CARTE];
    private static final int NUMERO_CARTE = 40;
    private int carteRimanenti;

    public Mazzo() {
        carteRimanenti = this.NUMERO_CARTE;
        int indiceMazzo = 0;
        Seme[] semi = Seme.values();
        ValoreCarta[] valori = ValoreCarta.values();
        for (int seme = 0; seme < 4; seme++) {
            for (int carta = 0; carta < 10; carta++, indiceMazzo++) {
                this.carte[indiceMazzo] = new Carta(semi[seme], valori[carta]);
            }
        }
    }

    public int getCarteRimanenti() {
        return this.carteRimanenti;
    }

    private Carta getCarta(int indice) {
        if (indice >= NUMERO_CARTE) {
            throw new ArrayIndexOutOfBoundsException("Il mazzo è composto da sole " + NUMERO_CARTE + " carte!");
        }
        return this.carte[indice];
    }

    public Carta pesca(boolean stampaPesca) {
        if (this.getCarteRimanenti() == 0) {
            System.out.println("Mazzo vuoto!");
            return null;
        }
        Carta pescata = this.getCarta(this.getCarteRimanenti() - 1);
        this.carteRimanenti--;
        if (stampaPesca) {
            System.out.println("Pescata la carta: " + pescata + ".");
        }
        return pescata;
    }

    public Carta pesca() {
        return this.pesca(false);
    }

    public Carta[] pesca(int carteDaPescare, boolean stampaPesca) {
        if (this.getCarteRimanenti() == 0) {
            System.out.println("Mazzo vuoto!");
            return null;
        } else if (this.getCarteRimanenti() < carteDaPescare) {
            System.out.println("Carte rimanenti : " + this.getCarteRimanenti() + ". Verranno pescate tutte.");
            carteDaPescare = this.getCarteRimanenti();
        }
        Carta[] pescate = new Carta[carteDaPescare];
        for (int i = 0; i < carteDaPescare; i++) {
            pescate[i] = this.pesca(stampaPesca);
        }
        return pescate;
    }

    public Carta[] pesca(int carteDaPescare) {
        return this.pesca(carteDaPescare, false);
    }

    public void mescola() {
        for (int i = 0; i < this.getCarteRimanenti(); i++) {
            Carta tmp = this.getCarta(i);
            int cartaDaScambiare = Utils.randomIntInRange(0, this.getCarteRimanenti() - 1);
            this.carte[i] = this.getCarta(cartaDaScambiare);
            this.carte[cartaDaScambiare] = tmp;
        }
    }

    public void stampa() {
        if (this.getCarteRimanenti() == 0) {
            System.out.println("Mazzo vuoto.");
        }
        for (int i = this.getCarteRimanenti() - 1; i >= 0; i--) {
            System.out.println(this.getCarta(i));
        }
    }
}
