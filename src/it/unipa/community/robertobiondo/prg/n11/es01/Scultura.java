package it.unipa.community.robertobiondo.prg.n11.es01;

import java.util.Objects;

public class Scultura extends OperaDArte {

    private String materiale;
    private Double altezza;

    public Scultura(String titolo, String autore, String dataDiCreazione, String materiale, double altezza) {
        super(titolo, autore, dataDiCreazione);
        this.setMateriale(materiale);
        this.setAltezza(altezza);
    }

    private void setMateriale(String materiale) {
        if (Objects.isNull(materiale) || materiale.isEmpty()) {
            throw new IllegalArgumentException("Denominazione non valida o oggetto non inizializzato!");
        }
        this.materiale = materiale;
    }

    private void setAltezza(Double altezza) {
        if (altezza <= 0) {
            throw new IllegalArgumentException("L'altezza di una scultura non pu� essere nulla o negativa!");
        }
        this.altezza = altezza;
    }

    public String getMateriale() {
        return this.materiale;
    }

    public Double getAltezza() {
        return this.altezza;
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.isNull(o) || !(o instanceof Scultura)) {
            return false;
        }
        Scultura s = (Scultura) o;
        return super.equals(o) && this.getAltezza().equals(s.getAltezza()) && this.getMateriale().equals(s.getMateriale());
    }

    @Override
    public String toString() {
        return super.toString().replace("Opera", "Scultura")
                + "\nMateriale: " + this.getMateriale() + "\nAltezza: " + this.getAltezza()
                + "cm.";
    }
}
