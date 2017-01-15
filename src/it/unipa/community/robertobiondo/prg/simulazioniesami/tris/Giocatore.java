/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tris;

import it.unipa.community.robertobiondo.prg.simulazioniesami.tris.SimboloTris;
import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public abstract class Giocatore {

    String nome;
    SimboloTris simbolo;

    public Giocatore(String nome, SimboloTris simbolo) {
        this.setNome(nome);
        this.setSimbolo(simbolo);
    }

    private void setNome(String nome) {
        if (Objects.isNull(nome) || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome giocatore non inizializzato o vuoto!");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    private void setSimbolo(SimboloTris simbolo) {
        if (Objects.isNull(simbolo) || simbolo == SimboloTris.VUOTO) {
            throw new IllegalArgumentException("Simbolo non inizializzato o vuoto!");
        }
        this.simbolo = simbolo;
    }

    public SimboloTris getSimbolo() {
        return this.simbolo;
    }

    public abstract void gioca(ScacchieraTris scacchiera);
}
