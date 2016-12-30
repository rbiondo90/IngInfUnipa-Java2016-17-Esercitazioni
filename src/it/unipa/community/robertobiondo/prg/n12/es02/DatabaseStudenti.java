/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es02;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author Roberto Biondo
 */
public class DatabaseStudenti {

    private final Map<String, String> studenti;

    public DatabaseStudenti() {
        this.studenti = new TreeMap<>();
    }

    public boolean aggiungiStudente(String nome) {
        if (Objects.isNull(nome) || nome.isEmpty()) {
            throw new IllegalArgumentException("Il nome dello studente non può essere vuoto!");
        }
        nome = nome.trim();
        if (nome.matches("[a-zA-Z ]*")) {
            return studenti.putIfAbsent(nome, "N.D.") == null;
        } else {
            throw new IllegalArgumentException("Il nome dello studente può contenere solo lettere dell'alfabeto!");
        }
    }

    public boolean aggiungiStudente(String nome, String voto) {
        if (this.aggiungiStudente(nome)) {
            this.setVoto(nome, voto);
            return true;
        } else {
            return false;
        }
    }

    public boolean rimuoviStudente(String nome) {
        if (Objects.isNull(nome)) {
            throw new IllegalArgumentException("L'argomento nome non può essere null!");
        }
        return studenti.remove(nome) != null;
    }

    public void setVoto(String nome, String voto) {
        if (studenti.containsKey(nome)) {
            voto = voto.trim().toUpperCase();
            if (voto.matches("[A-F][+-]{0,1}")) {
                studenti.put(nome, voto);
            } else {
                throw new IllegalArgumentException("Formato del voto non valido! Inserire solo lettere maiuscole da A ad F, eventualmente seguite da un + o un -.");
            }
        } else {
            throw new IllegalArgumentException("Studente non presente nel database!");
        }
    }

    public String getVoto(String studente) {
        if (Objects.isNull(studente)) {
            throw new IllegalArgumentException("Stringa studente non inizializzata!");
        }
        return studenti.get(studente);
    }

    @Override
    public String toString() {
        return this.studenti.toString().replace("{", "").replace("}", "").replace("=", ": ").replace(", ", "\n");
    }

    public void stampaDatabase() {
        System.out.println("\n---------------------------------------------\n" + this.toString() + "\n---------------------------------------------\n");
    }
}
