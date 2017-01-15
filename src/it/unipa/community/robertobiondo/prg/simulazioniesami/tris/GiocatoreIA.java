/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tris;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto Biondo
 */
public class GiocatoreIA extends Giocatore {

    public GiocatoreIA(SimboloTris simbolo) {
        super("PC " + simbolo.toString(), simbolo);
    }

    @Override
    public void gioca(ScacchieraTris scacchiera) {
        if (Objects.isNull(scacchiera)) {
            throw new IllegalArgumentException("La scacchiera non è inizializzata! Impossibile giocare mosse!");
        }
        if (scacchiera.controllaVittoria() != SimboloTris.VUOTO) {
            throw new IllegalStateException("La partita è già vinta! Impossibile giocare altre mosse!");
        }
        boolean giocato = false;
        do {
            this.simulaPausa(2);
            int riga = (int) (Math.random() * 3);
            int colonna = (int) (Math.random() * 3);
            try {
                scacchiera.setCasella(riga, colonna, this.getSimbolo());
                giocato = true;
                System.out.println("Il giocatore " + this.getNome() + " ha posizionato un " + this.getSimbolo() + " nella casella " + riga + colonna + ".");
            } catch (IllegalArgumentException | IllegalStateException ex) {
            }
        } while (!giocato);
    }

    public void simulaPausa(int secondi) {
        try {
            TimeUnit.SECONDS.sleep(secondi);
        } catch (InterruptedException ex) {
            Logger.getLogger(GiocatoreIA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
