/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tris;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class GiocatoreUmano extends Giocatore {

    private Scanner inputGiocatore = new Scanner(System.in);

    public GiocatoreUmano(String nome, SimboloTris simbolo) {
        super(nome, simbolo);
    }

    @Override
    public void gioca(ScacchieraTris scacchiera) {
        if(Objects.isNull(scacchiera)){
            throw new IllegalArgumentException("La scacchiera non è inizializzata! Impossibile giocare mosse!");
        }
        if (scacchiera.controllaVittoria() != SimboloTris.VUOTO) {
            throw new IllegalStateException("La partita è già vinta! Impossibile giocare altre mosse!");
        }
        scacchiera.stampa();
        boolean giocato = false;
        do {
            System.out.print("Inserire gli indici della casella su cui si vuole posizionare il proprio simbolo (prima riga e poi colonna, senza spazi in mezzo): ");
            try {
                String scelta = inputGiocatore.nextLine().trim();
                if (scelta.length() != 2) {
                    throw new IllegalArgumentException("Input errato!");
                }
                scacchiera.setCasella(Integer.valueOf(scelta.substring(0, 1)), Integer.valueOf(scelta.substring(1,2)), this.getSimbolo());
                giocato = true;
                System.out.println("Il giocatore " + this.getNome() + " ha posizionato un " + this.getSimbolo() + " nella casella " + scelta + ".");
            } catch (IllegalArgumentException | IllegalStateException ex) {
                System.out.println("Errore: " + ex.getMessage());
            }
        } while (!giocato);
    }
}
