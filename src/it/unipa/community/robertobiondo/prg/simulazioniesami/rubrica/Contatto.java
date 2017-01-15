/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.rubrica;

import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public abstract class Contatto {

    private String nome;
    private String cognome;
    private String email;

    public Contatto(String nome, String cognome, String email) {
        setNome(nome);
        setCognome(cognome);
        setEmail(email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (Objects.isNull(nome) || nome.isEmpty()) {
            throw new IllegalArgumentException("String vuota o non inizializzata!");
        }
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        if (Objects.isNull(cognome) || cognome.isEmpty()) {
            throw new IllegalArgumentException("String vuota o non inizializzata!");
        }
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Objects.isNull(email) || email.isEmpty()) {
            throw new IllegalArgumentException("String vuota o non inizializzata!");
        }
        this.email = email;
    }

    public void modifica() {
        System.out.println("Modifica contatto " + getCognome() + " " + getNome() + " in corso. Lasciare i campi vuoti per mantenerli invariati");
        System.out.print("Inserire il nuovo nome: ");
        String nome = AcquisitoreInput.acquisisciStringa();
        if (!nome.isEmpty()) {
            setNome(nome);
        }
        System.out.print("Inserire il nuovo cognome: ");
        String cognome = AcquisitoreInput.acquisisciStringa();
        if (!cognome.isEmpty()) {
            setCognome(cognome);
        }
        System.out.print("Inserire la nuova email: ");
        String email = AcquisitoreInput.acquisisciStringa();
        if (!email.isEmpty()) {
            setEmail(email);
        }
    }

    @Override
    public String toString() {
        return "Nome: " + getCognome() + " " + getNome() + "\nEmail: " + getEmail() + "\n";
    }
}
