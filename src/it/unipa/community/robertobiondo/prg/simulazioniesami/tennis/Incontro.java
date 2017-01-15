/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tennis;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public class Incontro {

    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private List<Set> listaSet;

    public Incontro(Giocatore giocatore1, Giocatore giocatore2) {
        listaSet = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listaSet.add(new Set(giocatore1, giocatore2));
        }
        setGiocatore1(giocatore1);
        setGiocatore2(giocatore2);
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

    public void simulaIncontro() {
        int setVintiG1 = 0;
        int setVintiG2 = 0;
        int indice = 0;
        int setGiocati = 0;
        System.out.println("Inizia la partita!");
        while (Math.max(setVintiG2, setVintiG1) < 2) {
            listaSet.get(indice).EffettuaSimulazione();
            System.out.println("Simulazione set " + (indice + 1) + ": vince " + listaSet.get(indice).getVincitore());
            if (listaSet.get(indice).getVincitore() == giocatore1) {
                setVintiG1++;
            } else {
                setVintiG2++;
            }
            setGiocati++;
            indice++;
        }
        System.out.println("Ha vinto la partita " + ((setVintiG1 > setVintiG2) ? giocatore1 : giocatore2));
        for (int i = 0; i < setGiocati; i++) {
            System.out.println("Set " + (i + 1) + ": " + listaSet.get(i).getSequenzaRisultati());
        }
    }

}
