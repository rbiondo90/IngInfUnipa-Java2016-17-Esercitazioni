/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es01;

import it.unipa.community.robertobiondo.prg.n04.es04.Date;

/**
 *
 * @author Bob
 */
public class Persona {

    private Date dataDiNascita;
    private String nome = "";
    private String cognome = "";
    private String codiceFiscale = "";
    private String indirizzo = "";
    private String città = "";
    private String cap = "";
    private boolean validitàRecord = false;

    public Persona(Date dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap) {
        this.setDataDiNascita(dataDiNascita);
        this.setNome(nome);
        this.setCognome(cognome);
        this.setCodiceFiscale(codiceFiscale);
        this.setIndirizzo(indirizzo);
        this.setCittà(città);
        this.setCap(cap);
    }

    public Persona(String dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap) {
        this(new Date(dataDiNascita), nome, cognome, codiceFiscale, indirizzo, città, cap);
    }

    public Persona(Persona persona) {
        this(persona.getDataDiNascita(), persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), persona.getIndirizzo(), persona.getCittà(), persona.getCap());
    }

    public Date getDataDiNascita() {
        return (this.validitàRecord) ? dataDiNascita : null;
    }

    public boolean setDataDiNascita(Date dataDiNascita) {
        if (dataDiNascita != null && dataDiNascita.giorniPassati(Date.ottieniDataCorrente()) > 0) {
            this.dataDiNascita = dataDiNascita.clone();
            this.updateValiditàRecord();
            return true;
        } else {
            this.dataDiNascita = null;
            return this.validitàRecord = false;
        }
    }

    public String getNome() {
        return (this.validitàRecord) ? this.nome : "";
    }

    public boolean setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome.substring(0, Math.min(nome.length(), 30));
            this.updateValiditàRecord();
            return true;
        } else {
            this.nome = "";
            return this.validitàRecord = false;
        }

    }

    public String getCognome() {
        return (this.validitàRecord) ? this.cognome : "";
    }

    public boolean setCognome(String cognome) {
        if (!cognome.isEmpty()) {
            this.cognome = cognome.substring(0, Math.min(cognome.length(), 30));
            this.updateValiditàRecord();
            return true;
        } else {
            return this.validitàRecord = false;
        }
    }

    public String getCodiceFiscale() {
        return (this.validitàRecord) ? this.codiceFiscale : "";
    }

    public boolean setCodiceFiscale(String codiceFiscale) {
        if (codiceFiscale.length() == 16) {
            this.codiceFiscale = codiceFiscale;
            this.updateValiditàRecord();
            return true;
        } else {
            return this.validitàRecord = false;
        }
    }

    public String getIndirizzo() {
        return (this.validitàRecord) ? this.indirizzo : "";
    }

    public boolean setIndirizzo(String indirizzo) {
        if (!indirizzo.isEmpty()) {
            this.indirizzo = indirizzo.substring(0, Math.min(indirizzo.length(), 100));
            this.updateValiditàRecord();
            return true;
        } else {
            return this.validitàRecord = false;
        }
    }

    public String getCittà() {
        return (this.validitàRecord) ? this.città : "";
    }

    public boolean setCittà(String città) {
        if (!città.isEmpty()) {
            this.città = città.substring(0, Math.min(città.length(), 30));
            this.updateValiditàRecord();
            return true;
        } else {
            return this.validitàRecord = false;
        }
    }

    public String getCap() {
        return (this.validitàRecord) ? this.cap : "";
    }

    public boolean setCap(String cap) {
        if (cap.length() == 5) {
            this.cap = cap;
            this.updateValiditàRecord();
            return true;
        } else {
            return this.validitàRecord = false;
        }
    }

    public boolean getValiditàRecord() {
        return this.validitàRecord;
    }

    public int getEta() {
        return (this.validitàRecord) ? this.getDataDiNascita().anniPassati(Date.ottieniDataCorrente()) : -1;
    }

    private void updateValiditàRecord() {
        this.validitàRecord = (this.dataDiNascita != null && !this.nome.isEmpty() && !this.cognome.isEmpty()
                && this.codiceFiscale.length() == 16 && !this.indirizzo.isEmpty() && !this.città.isEmpty() && this.cap.length() == 5);
    }

    @Override
    public String toString() {
        if (this.getValiditàRecord()) {
            StringBuilder s = new StringBuilder();
            s.append("Cognome: ").append(this.getCognome());
            s.append("\nNome: ").append(this.getNome());
            s.append("\nNato il ").append(this.dataDiNascita);
            s.append("\nIndirizzo: ").append(this.getIndirizzo()).append("\n");
            s.append(this.getCap()).append(" ").append(this.getCittà());
            s.append("\nCodice Fiscale: ").append(this.getCodiceFiscale());
            return s.toString();
        } else {
            return "Record non valido! Reinizializzare con dati corretti.";
        }

    }

    @Override
    public Persona clone() {
        return new Persona(this);
    }

    public void stampaDati() {
        System.out.println(this);
    }
}
