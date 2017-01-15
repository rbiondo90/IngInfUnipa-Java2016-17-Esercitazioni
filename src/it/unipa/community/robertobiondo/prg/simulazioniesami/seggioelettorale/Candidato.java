/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.seggioelettorale;

import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public class Candidato extends Studente {

    String lista;

    public Candidato(String nome, String cognome, long matricola, long codiceDiControllo, String lista) {
        super(nome, cognome, matricola, codiceDiControllo);
        setLista(lista);
    }

    public void setLista(String lista) {
        if (Objects.isNull(lista) || lista.isEmpty()) {
            throw new IllegalArgumentException("Stringa vuota o non inizializzata!");
        }
        this.lista = lista;
    }

    public String getLista() {
        return this.lista;
    }

}
