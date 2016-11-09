package it.unipa.community.robertobiondo.prg.n05.es01;

import it.unipa.community.robertobiondo.prg.n04.es04.Date;

/**
 *
 * @author Bob
 */
public class Abbonato extends Persona {

    private byte sconto;
    private boolean validitàRecord = true;

    public Abbonato(Date dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap, byte sconto) {
        super(dataDiNascita, nome, cognome, codiceFiscale, indirizzo, città, cap);
        if (super.getValiditàRecord() && this.getDataDiNascita().anniDiDifferenza(Date.ottieniDataCorrente()) >= 18) {
            this.setSconto(sconto);
        } else {
            this.validitàRecord = false;
        }
    }

    public Abbonato(String dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap, byte sconto) {
        this(new Date(dataDiNascita), nome, cognome, codiceFiscale, indirizzo, città, cap, sconto);

    }

    public Abbonato(Persona persona, byte sconto) {
        this(persona.getDataDiNascita(), persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), persona.getIndirizzo(), persona.getCittà(), persona.getCap(), sconto);
    }

    public void setSconto(byte sconto) {
        if (this.validitàRecord && sconto >= 0 && sconto <= 100) {
            this.sconto = sconto;
        } else {
            this.sconto = 0;
        }
    }

    public byte getSconto() {
        return (this.validitàRecord) ? this.sconto : 0;
    }

    @Override
    public boolean getValiditàRecord() {
        return this.validitàRecord;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        if (this.validitàRecord) {
            s.append("\nCliente abbonato.");
            if (this.getSconto() > 0) {
                s.append(" Ha diritto a uno sconto del ").append(this.getSconto()).append("% sugli acquisti.\n");
            } else {
                s.append(" Attualmente l'abbonato non ha diritto ad alcuno sconto.\n");
            }
            return s.toString();
        } else {
            return "Errore! Persona minorenne o persona non correttamente registrata!";
        }

    }

    @Override
    public void stampaDati() {
        System.out.println(this.toString());
    }
}
