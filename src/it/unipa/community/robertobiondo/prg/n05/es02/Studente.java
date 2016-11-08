/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es02;

import it.unipa.community.robertobiondo.prg.n04.es04.Date;
import it.unipa.community.robertobiondo.prg.n05.es01.Persona;

/**
 *
 * @author Bob
 */
public class Studente extends Persona {

    private Date dataIscrizione;
    private int matricola;
    private String corsoDiLaurea = "";
    private boolean validitàRecord = true;

    public Studente(Persona studente, Date dataIscrizione, int matricola, String corsoDiLaurea) {
        super(studente);
        if (super.getValiditàRecord()) {
            this.validitàRecord = this.setDataIscrizione(dataIscrizione) && this.setMatricola(matricola) && this.setCorsoDiLaurea(corsoDiLaurea);
        } else {
            this.validitàRecord = false;
        }
    }
    
    public Studente(Date dataDiNascita,String nome,String cognome, String codiceFiscale, String indirizzo, String città, String cap,
            Date dataDiIscrizione, int matricola, String corsoDiLaurea){
        this(new Persona(dataDiNascita,nome,cognome,codiceFiscale,indirizzo,città,cap),dataDiIscrizione,matricola,corsoDiLaurea);
    }

    public boolean setDataIscrizione(Date dataIscrizione) {
        if (dataIscrizione != null && this.getDataDiNascita().anniPassati(dataIscrizione) >= 18) {
            this.dataIscrizione = dataIscrizione.clone();
            this.updateValiditàRecord();
            return true;
        } else {
            this.dataIscrizione = null;
            return validitàRecord = false;
        }
    }

    public boolean setMatricola(int matricola) {
        if (matricola > 0) {
            this.matricola = matricola;
            this.updateValiditàRecord();
            return true;
        } else {
            this.matricola = -1;
            return validitàRecord = false;
        }
    }

    public boolean setCorsoDiLaurea(String corsoDiLaurea) {
        if (corsoDiLaurea != null && !corsoDiLaurea.isEmpty()) {
            this.corsoDiLaurea = corsoDiLaurea.substring(0, Math.min(60, corsoDiLaurea.length()));
            this.updateValiditàRecord();
            return true;
        } else {
            this.corsoDiLaurea = "";
            return validitàRecord = false;
        }
    }

    public Date getDataIscrizione() {
        return this.dataIscrizione;
    }

    public int getMatricola() {
        return this.matricola;
    }

    public String getCorsoDiLaurea() {
        return this.corsoDiLaurea;
    }

    private void updateValiditàRecord() {
        this.validitàRecord = super.getValiditàRecord() && this.getDataIscrizione() != null && this.getMatricola() > 0 && !this.getCorsoDiLaurea().isEmpty();
    }
    
    public boolean getValiditàRecord(){
        return this.validitàRecord;
    }
    
    @Override
    public String toString(){
        if(this.getValiditàRecord()){
            StringBuilder s = new StringBuilder(super.toString());
            s.insert(0, "\nSCHEDA STUDENTE ");
            s.append("\nCorso di Laurea: ").append(this.getCorsoDiLaurea());
            s.append("\nData di iscrizione: ").append(this.getDataIscrizione());
            s.append("\nNumero di matricola: ").append(this.getMatricola());
            return s.toString();
        }
        else {
            return "Record non valido!";
        }
    }

    @Override
    public void stampaDati(){
        System.out.println(this);
    }
    
    public Persona getPersona(){
        if(super.getValiditàRecord()){
            return new Persona(this.getDataDiNascita(),this.getNome(),this.getCognome(),this.getCodiceFiscale(),this.getIndirizzo(),this.getCittà(),this.getCap());
        }
        else {
            return null;
        }
    }
    
}
