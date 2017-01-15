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
public class Studente implements Comparable<Studente> {

    private String cognome;
    private String nome;
    private long matricola;
    private long codiceDiControllo;

    public Studente(String nome, String cognome, long matricola, long codiceDiControllo) {
        setNome(nome);
        setCognome(cognome);
        setMatricola(matricola);
        setCodiceDiControllo(codiceDiControllo);
    }

    public String getCognome() {
        return cognome;
    }

    private void setCognome(String cognome) {
        if (Objects.isNull(cognome) || cognome.isEmpty()) {
            throw new IllegalArgumentException("Stringa vuota o non inizializzata!");
        }
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (Objects.isNull(nome) || nome.isEmpty()) {
            throw new IllegalArgumentException("Stringa vuota o non inizializzata!");
        }
        this.nome = nome;
    }

    public long getMatricola() {
        return matricola;
    }

    private void setMatricola(long matricola) {
        if (matricola <= 0) {
            throw new IllegalArgumentException("La matricola non può essere rappresentata da un numero negativo!");
        }
        this.matricola = matricola;
    }

    public long getCodiceDiControllo() {
        return codiceDiControllo;
    }

    private void setCodiceDiControllo(long codiceDiControllo) {
        this.codiceDiControllo = codiceDiControllo;
    }

    @Override
    public int compareTo(Studente t) {
        int confrontaCognomi = getCognome().compareTo(t.getCognome());
        if (confrontaCognomi == 0) {
            return getNome().compareTo(t.getNome());
        }
        return confrontaCognomi;
    }
}
