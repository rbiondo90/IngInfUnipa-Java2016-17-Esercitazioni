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
public class StudenteMagistrale extends Studente {

    private final int CFU_DA_CONSEGUIRE = 120;
    public int cfuConseguiti = 0;
    private String corsoDiProvenienza = "";
    private boolean validitàRecord = true;

    public StudenteMagistrale(Studente studenteMagistrale, String corsoDiProvenienza) {
        super(studenteMagistrale.getPersona(), studenteMagistrale.getDataIscrizione(), studenteMagistrale.getMatricola(), studenteMagistrale.getCorsoDiLaurea());
        if (super.getValiditàRecord()) {
            this.setCorsoDiProvenienza(corsoDiProvenienza);
        } else {
            this.validitàRecord = false;
        }
    }

    public StudenteMagistrale(Persona studenteMagistrale, Date dataIscrizione, int matricola, String corsoDiLaurea, String corsoDiProvenienza) {
        this(new Studente(studenteMagistrale, dataIscrizione, matricola, corsoDiLaurea), corsoDiProvenienza);
    }

    private boolean setCorsoDiProvenienza(String corsoDiProvenienza) {
        if (!corsoDiProvenienza.isEmpty()) {
            this.corsoDiProvenienza = corsoDiProvenienza.substring(0, Math.min(50, corsoDiProvenienza.length()));
            return validitàRecord = true;
        } else {
            this.corsoDiProvenienza = "";
            return validitàRecord = false;
        }
    }

    public String getScuolaDiprovenienza() {
        if (this.getValiditàRecord()) {
            return this.corsoDiProvenienza;
        } else {
            return "";
        }
    }

    @Override
    public boolean getValiditàRecord() {
        return this.validitàRecord;
    }

    public int getCfuConseguiti() {
        if (this.getValiditàRecord()) {
            return this.cfuConseguiti;
        } else {
            return 0;
        }
    }

    private void incrementaCfu(int incremento) {
        if (incremento > 0 && this.cfuConseguiti < this.CFU_DA_CONSEGUIRE) {
            this.cfuConseguiti += incremento;
            if (this.cfuConseguiti > this.CFU_DA_CONSEGUIRE) {
                this.cfuConseguiti = this.CFU_DA_CONSEGUIRE;
            }
            System.out.println("\nLo studente " + this.getCognome() + " " + this.getNome() + ", iscritto al Corso di Laurea triennale di " + this.getCorsoDiLaurea()
                    + " ha conseguito con successo un esame da " + incremento + " CFU.\nTotale CFU conseguiti: " + this.getCfuConseguiti());
            if (this.getCfuConseguiti() == this.CFU_DA_CONSEGUIRE) {
                System.out.println("Lo studente ha sostenuto tutti gli esami del corso.");
            }
        }
        else {
            System.out.println("\nIl numero di CFU non può essere nullo o negativo!");
        }
    }

    @Override
    public String toString() {
        if (this.getValiditàRecord()) {
            StringBuilder s = new StringBuilder(super.toString());
            s.insert(17, "MAGISTRALE");
            s.append("\nCFU conseguiti: ").append(this.getCfuConseguiti());
            s.append("\nCFU da conseguire: ").append(this.CFU_DA_CONSEGUIRE - this.getCfuConseguiti());
            return s.toString();
        }
        else {
            return "Record non valido!";
        }
    }
}
