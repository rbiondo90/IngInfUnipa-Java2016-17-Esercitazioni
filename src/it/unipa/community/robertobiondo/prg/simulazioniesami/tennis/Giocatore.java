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
public class Giocatore {

    private String nome;
    private String cognome;
    private int posizioneInClassifica;

    public Giocatore(String nome, String cognome, int posizioneInClassifica) {
        setNome(nome);
        setCognome(cognome);
        setPosizioneInClassifica(posizioneInClassifica);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (Objects.isNull(nome)) {
            throw new IllegalArgumentException("Oggetto non inizializzato");
        }
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    private void setCognome(String cognome) {
        if (Objects.isNull(cognome)) {
            throw new IllegalArgumentException("Oggetto non inizializzato");
        }
        this.cognome = cognome;
    }

    public int getPosizioneInClassifica() {
        return posizioneInClassifica;
    }

    public void setPosizioneInClassifica(int posizioneInClassifica) {
        if (posizioneInClassifica < 1) {
            throw new IllegalArgumentException("La posizione in classifica non può essere negativa!");
        }
        this.posizioneInClassifica = posizioneInClassifica;
    }

    public String toString(boolean stampaPosizione) {
        return this.getNome() + " " + this.getCognome() + ((stampaPosizione) ? this.getPosizioneInClassifica() : "");
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
