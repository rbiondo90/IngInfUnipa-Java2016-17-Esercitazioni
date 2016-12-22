package it.unipa.community.robertobiondo.prg.n11.es01;

import java.util.Objects;

public abstract class OperaDArte {

    private String titolo;
    private String autore;
    private String dataDiCreazione;

    public OperaDArte(String titolo, String autore, String dataDiCreazione) {
        this.setTitolo(titolo);
        this.setAutore(autore);
        this.setDataDiCreazione(dataDiCreazione);
    }

    private void setTitolo(String titolo) {
        if (Objects.isNull(titolo) || titolo.isEmpty()) {
            throw new IllegalArgumentException("Denominazione non valida o oggetto non inizializzato!");
        }
        this.titolo = titolo;
    }

    private void setAutore(String autore) {
        if (Objects.isNull(autore) || autore.isEmpty()) {
            throw new IllegalArgumentException("Autore non valido o oggetto non inizializzato!");
        }
        this.autore = autore;
    }

    private void setDataDiCreazione(String dataDiCreazione) {
        if (Objects.isNull(dataDiCreazione) || dataDiCreazione.isEmpty()) {
            throw new IllegalArgumentException("Data non valida o oggetto non inizializzato!");
        }
        this.dataDiCreazione = dataDiCreazione;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public String getAutore() {
        return this.autore;
    }

    public String getDataDiCreazione() {
        return this.dataDiCreazione;
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.isNull(o) || !(o instanceof OperaDArte)) {
            return false;
        }
        OperaDArte oa = (OperaDArte) o;
        return this.getTitolo().equals(oa.getTitolo()) && this.getAutore().equals(oa.getAutore()) && this.getDataDiCreazione().equals(oa.getDataDiCreazione());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\"").append(this.getTitolo()).append("\"").append("\n");
        s.append("Opera di: ").append(this.getAutore()).append("\n");
        s.append("Data di creazione: ").append(this.getDataDiCreazione());
        return s.toString();
    }

}
