/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tennis;

import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public class Set {

    private String sequenzaRisultati;
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private Giocatore vincitore;

    public Set(Giocatore giocatore1, Giocatore giocatore2) {
        setGiocatore1(giocatore1);
        setGiocatore2(giocatore2);
        sequenzaRisultati = "";
    }

    public void EffettuaSimulazione() {
        int punteggioG1 = 0;
        int punteggioG2 = 0;
        double modificaPercentuale = (giocatore1.getPosizioneInClassifica() - giocatore2.getPosizioneInClassifica()) / 20;
        StringBuilder risultati = new StringBuilder();
        risultati.append("0-0,");
        while (Math.max(punteggioG2, punteggioG1) < 6 || Math.abs(punteggioG2 - punteggioG1) < 2) {
            int rand = (int) (1 + modificaPercentuale + Math.random() * 2);
            if (rand > 2) {
                rand = 2;
            }
            if (rand < 1) {
                rand = 1;
            }
            if (rand == 1) {
                punteggioG1++;
            } else if (rand == 2) {
                punteggioG2++;
            }
            risultati.append(" ").append(punteggioG1).append("-").append(punteggioG2).append(",");
        }
        risultati.deleteCharAt(risultati.length() - 1);
        sequenzaRisultati = risultati.toString();
        if (punteggioG1 > punteggioG2) {
            setVincitore(getGiocatore1());
        } else {
            setVincitore(getGiocatore2());
        }
    }

    public String getSequenzaRisultati() {
        return sequenzaRisultati;
    }

    public Giocatore getGiocatore1() {
        return giocatore1;
    }

    private void setGiocatore1(Giocatore giocatore1) {
        if (Objects.isNull(giocatore1)) {
            throw new IllegalArgumentException("Oggetto non inizializzato");
        }
        this.giocatore1 = giocatore1;
    }

    public Giocatore getGiocatore2() {
        return giocatore2;
    }

    private void setGiocatore2(Giocatore giocatore2) {
        if (Objects.isNull(giocatore2)) {
            throw new IllegalArgumentException("Oggetto non inizializzato");
        }
        this.giocatore2 = giocatore2;
    }

    public Giocatore getVincitore() {
        return vincitore;
    }

    private void setVincitore(Giocatore vincitore) {
        if (Objects.isNull(vincitore)) {
            throw new IllegalArgumentException("Oggetto non inizializzato");
        }
        this.vincitore = vincitore;
    }
}
