/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.listaeventi;

import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public abstract class Evento {

    private int codiceIdentificativo;
    private String descrizione;

    public Evento(int codiceIdentificativo, String descrizione) {
        this.setCodiceIdentificativo(codiceIdentificativo);
        this.setDescrizione(descrizione);
    }

    private void setCodiceIdentificativo(int codiceIdentificativo) {
        if (codiceIdentificativo <= 0) {
            throw new IllegalArgumentException("Il codice identificativo di un evento deve essere un intero maggiore di zero!");
        }
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public int getCodiceIdentificativo() {
        return this.codiceIdentificativo;
    }

    private void setDescrizione(String descrizione) {
        if (Objects.isNull(descrizione)) {
            throw new IllegalArgumentException("Stringa descrizione non inizializzata!");
        }
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("EVENTO GENERICO\n");
        s.append("Codice identificativo: ").append(this.getCodiceIdentificativo()).append("\n");
        s.append("Descrizione: ").append(this.getDescrizione()).append("\n");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.isNull(o) || !(o instanceof Evento)) {
            return false;
        }
        Evento e = (Evento) o;
        return this.getCodiceIdentificativo() == e.getCodiceIdentificativo() && this.getDescrizione().equals(e.getDescrizione());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codiceIdentificativo;
        hash = 53 * hash + Objects.hashCode(this.descrizione);
        return hash;
    }
}
