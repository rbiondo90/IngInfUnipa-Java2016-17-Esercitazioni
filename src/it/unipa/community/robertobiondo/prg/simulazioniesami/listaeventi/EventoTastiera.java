/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.listaeventi;

/**
 *
 * @author Roberto Biondo
 */
public class EventoTastiera extends Evento {

    private int codiceTasto;

    public EventoTastiera(int codiceIdentificativo, String descrizione, int codiceTasto) {
        super(codiceIdentificativo, descrizione);
        this.setCodiceTasto(codiceTasto);
    }

    private void setCodiceTasto(int codiceTasto) {
        if (codiceTasto < 0) {
            throw new IllegalArgumentException("Codice del tasto non valido!");
        }
        this.codiceTasto = codiceTasto;
    }

    public int getCodiceTasto() {
        return this.codiceTasto;
    }

    @Override
    public String toString() {
        return super.toString().replace("GENERICO", "TASTIERA").concat("Codice tasto: " + this.getCodiceTasto() + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o) || (!(o instanceof EventoTastiera))) {
            return false;
        }
        EventoTastiera e = (EventoTastiera) o;
        return this.getCodiceTasto() == e.getCodiceTasto();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 13 * hash + this.codiceTasto;
        return hash;
    }

}
