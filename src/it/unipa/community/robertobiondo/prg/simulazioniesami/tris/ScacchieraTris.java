/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tris;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public class ScacchieraTris {

    private List<List<SimboloTris>> scacchiera;

    public ScacchieraTris() {
        this.scacchiera = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.scacchiera.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                this.getRiga(i).add(j, SimboloTris.VUOTO);
            }
        }
    }

    private List<SimboloTris> getRiga(int riga) {
        if (riga < 0 || riga > 2) {
            throw new IllegalArgumentException("La scacchiera del tris ha solo 3 righe! Inserire esclusivamente indici compresi tra 0 e 2!");
        }
        return this.scacchiera.get(riga);
    }

    public SimboloTris getCasella(int riga, int colonna) {
        if (colonna < 0 || colonna > 2) {
            throw new IllegalArgumentException("La scacchiera del tris ha solo 3 colonne! Inserire esclusivamente indici compresi tra 0 e 2!");
        }
        return this.getRiga(riga).get(colonna);
    }

    public void setCasella(int riga, int colonna, SimboloTris simbolo) {
        if (this.scacchieraPiena()) {
            throw new IllegalStateException("La scacchiera è piena! Impossibile fare altre mosse!");
        }
        if (this.controllaVittoria() != SimboloTris.VUOTO) {
            throw new IllegalStateException("Lo stato attuale della scacchiera segnala una partita già vinta! Impossibile aggiungere ulteriori simboli!");
        }
        if (Objects.isNull(simbolo) || simbolo == SimboloTris.VUOTO) {
            throw new IllegalArgumentException("Simbolo non inizializzato o vuoto!");
        }
        if (colonna < 0 || colonna > 2) {
            throw new IllegalArgumentException("La scacchiera del tris ha solo 3 colonne! Inserire esclusivamente indici compresi tra 0 e 2!");
        }
        if (this.getCasella(riga, colonna) != SimboloTris.VUOTO) {
            throw new IllegalStateException("La casella è già occupata. Sceglierne un'altra!");
        }
        this.getRiga(riga).set(colonna, simbolo);
    }

    public SimboloTris controllaVittoria() {
        //CONTROLLO SU RIGHE
        for (int i = 0; i < 3; i++) {
            SimboloTris simbolo = this.getCasella(i, 0);
            if (simbolo != SimboloTris.VUOTO && simbolo == this.getCasella(i, 1) && simbolo == this.getCasella(i, 2)) {
                return simbolo;
            }
        }
        //CONTROLLO SU COLONNE
        for (int j = 0; j < 3; j++) {
            SimboloTris simbolo = this.getCasella(0, j);
            if (simbolo != SimboloTris.VUOTO && simbolo == this.getCasella(1, j) && simbolo == this.getCasella(2, j)) {
                return simbolo;
            }
        }
        //CONTROLLO SU DIAGONALI
        SimboloTris simbolo = this.getCasella(0, 0);
        if (simbolo != SimboloTris.VUOTO && simbolo == this.getCasella(1, 1) && simbolo == this.getCasella(2, 2)) {
            return simbolo;
        }
        simbolo = this.getCasella(0, 2);
        if (simbolo != SimboloTris.VUOTO && simbolo == this.getCasella(1, 1) && simbolo == this.getCasella(2, 0)) {
            return simbolo;
        }
        return SimboloTris.VUOTO;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("  0   1   2\n");
        for (int i = 0; i < 3; i++) {
            s.append(i);
            for (int j = 0; j < 3; j++) {
                s.append(" ");
                s.append(this.getCasella(i, j));
                if (j < 2) {
                    s.append(" |");
                }
            }
            s.append("\n");
            if (i < 2) {
                s.append(" -----------");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public boolean scacchieraPiena() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.getCasella(i, j) == SimboloTris.VUOTO) {
                    return false;
                }
            }
        }
        return true;
    }

    public void stampa() {
        System.out.println(this);
    }

}
