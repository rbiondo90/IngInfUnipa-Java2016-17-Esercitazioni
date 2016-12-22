package it.unipa.community.robertobiondo.prg.n11.es01;

import java.util.Objects;

public class Dipinto extends OperaDArte {

    private enum Tecnica {
        OLIO, TEMPERA, LITOGRAFIA, SERIGRAFIA, CHINA;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }

    private Tecnica tecnica;
    private Double altezza;
    private Double larghezza;

    public Dipinto(String titolo, String autore, String dataDiNascita, Tecnica tecnica, Double altezza, Double larghezza) {
        super(titolo, autore, dataDiNascita);
        this.setTecnica(tecnica);
        this.setAltezza(altezza);
        this.setLarghezza(larghezza);
    }

    public Dipinto(String titolo, String autore, String dataDiNascita, String tecnica, Double altezza, Double larghezza) {
        super(titolo, autore, dataDiNascita);
        this.setTecnica(tecnica);
        this.setAltezza(altezza);
        this.setLarghezza(larghezza);
    }

    private void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    private void setTecnica(String tecnica) {
        try {
            this.tecnica = Tecnica.valueOf(tecnica.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException exc) {
            throw new IllegalArgumentException("Tecnica non valida.");
        }
    }

    private void setAltezza(Double altezza) {
        if (altezza <= 0) {
            throw new IllegalArgumentException("L'altezza non pu� essere nulla o negativa!");
        }
        this.altezza = altezza;
    }

    private void setLarghezza(Double larghezza) {
        if (larghezza <= 0) {
            throw new IllegalArgumentException("La larghezza non pu� essere nulla o negativa!");
        }
        this.larghezza = larghezza;
    }

    public Tecnica getTecnica() {
        return this.tecnica;
    }

    public Double getAltezza() {
        return this.altezza;
    }

    public Double getLarghezza() {
        return this.larghezza;
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.isNull(o) || !(o instanceof Dipinto)) {
            return false;
        }
        Dipinto d = (Dipinto) o;
        return super.equals(o) && this.getAltezza().equals(d.getAltezza()) && this.getLarghezza().equals(d.getLarghezza()) && this.getTecnica().equals(d.getTecnica());
    }

    @Override
    public String toString() {
        return super.toString().replace("Opera", "Dipinto")
                + "\nTecnica utilizzata: " + this.getTecnica()
                + "\nDimensioni: " + this.getAltezza() + " x " + this.getLarghezza() + " cm.";
    }
}
