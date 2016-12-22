package it.unipa.community.robertobiondo.prg.n11.es02;

import java.util.Formatter;
import java.util.Objects;

public class Nave {

    private String codiceIdentificativo;
    private Double posizioneX;
    private Double posizioneY;
    private Double velocita;
    private Integer direzione;
    private Double larghezza;
    private Double lunghezza;
    private Integer passeggeriABordo;

    public Nave(String codiceIdentificativo, Double posizioneX, Double posizioneY, Double velocita, Integer direzione, Double larghezza, Double lunghezza,
            Integer passeggeriABordo) {
        this.setCodiceIdentificativo(codiceIdentificativo);
        this.setPosizione(posizioneX, posizioneY);
        this.setVelocita(velocita);
        this.setDirezione(direzione);
        this.setLarghezza(larghezza);
        this.setLunghezza(lunghezza);
        this.setPasseggeriABordo(passeggeriABordo);
    }

    public Nave(String codiceIdentificativo, Double larghezza, Double lunghezza) {
        this(codiceIdentificativo, 0D, 0D, 0D, 0, larghezza, lunghezza, 0);
    }

    private void setCodiceIdentificativo(String codiceIdentificativo) {
        if (Objects.isNull(codiceIdentificativo) || codiceIdentificativo.isEmpty()) {
            throw new IllegalArgumentException("Codice identificativo non valido!");
        }
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public String getCodiceIdentificativo() {
        return this.codiceIdentificativo;
    }

    public void setPosizione(Double x, Double y) {
        this.setPosizioneX(x);
        this.setPosizioneY(y);
    }

    public void setPosizioneX(Double posizioneX) {
        if (Objects.isNull(posizioneX)) {
            throw new IllegalArgumentException("Coordinate non correttamente inizializzate");
        }
        this.posizioneX = posizioneX;
    }

    public Double getPosizioneX() {
        return this.posizioneX;
    }

    public void setPosizioneY(Double posizioneY) {
        if (Objects.isNull(posizioneY)) {
            throw new IllegalArgumentException("Coordinate non correttamente inizializzate");
        }
        this.posizioneY = posizioneY;
    }

    public Double getPosizioneY() {
        return this.posizioneY;
    }

    public void setVelocita(Double velocita) {
        if (Objects.isNull(velocita) || velocita < 0) {
            throw new IllegalArgumentException("Velocit� errata.");
        }
        this.velocita = velocita;
    }

    public Double getVelocita() {
        return this.velocita;
    }

    public void setDirezione(Integer direzione) {
        if (Objects.isNull(direzione) || direzione < 0 || direzione > 359) {
            throw new IllegalArgumentException("Direzione non correttamente inizializzata.");
        }
        this.direzione = direzione;
    }

    public Integer getDirezione() {
        return this.direzione;
    }

    private void setLarghezza(Double larghezza) {
        if (Objects.isNull(larghezza) || larghezza < 0) {
            throw new IllegalArgumentException("Larghezza non correttamente inizializzata.");
        }
        this.larghezza = larghezza;
    }

    public Double getLarghezza() {
        return this.larghezza;
    }

    private void setLunghezza(Double lunghezza) {
        if (Objects.isNull(lunghezza) || lunghezza < 0) {
            throw new IllegalArgumentException("Lunghezza non correttamente inizializzata.");
        }
        this.lunghezza = lunghezza;
    }

    public Double getLunghezza() {
        return this.lunghezza;
    }

    public void setPasseggeriABordo(Integer passeggeriABordo) {
        if (Objects.isNull(passeggeriABordo) || passeggeriABordo < 0) {
            throw new IllegalArgumentException("Valore di passeggeri a bordo errato!");
        }
        this.passeggeriABordo = passeggeriABordo;
    }

    public Integer getPasseggeriABordo() {
        return this.passeggeriABordo;
    }

    public void avanza() {
        this.setPosizioneX(this.getPosizioneX() + this.getVelocita() * Math.cos(this.getDirezione() * Math.PI / 180));
        this.setPosizioneY(this.getPosizioneY() + this.getVelocita() * Math.cos(this.getDirezione() * Math.PI / 180));
        this.setDirezione(this.getDirezione() - 10 + (int) (Math.random() * 20));
        this.setVelocita(this.getVelocita() - this.getVelocita() / 2 + Math.random() * this.getVelocita() * 2);
    }

    public double distanzaDa(Nave nave) {
        if (Objects.isNull(nave)) {
            throw new IllegalArgumentException("Oggetto non corretto");
        }
        return Math.sqrt(Math.pow(this.getPosizioneX() - nave.getPosizioneX(), 2) + Math.pow(this.getPosizioneY() - nave.getPosizioneY(), 2));
    }

    public void stampaStato() {
        System.out.println("NAVE \"" + this.getCodiceIdentificativo() + "\""
                + "\nPosizione: (" + String.format("%.2f", this.getPosizioneX()) + " , "
                + String.format("%.2f", this.getPosizioneY()) + ")"
                + "\nVelocità: " + String.format("%.2f", this.getVelocita()) + "mph; Direzione: " + this.getDirezione()
                + "\nLarghezza nave: " + String.format("%.2f", this.getLarghezza()) + "m; "
                + "Lunghezza nave: " + String.format("%.2f", this.getLunghezza()) + "m"
                + "\nPasseggeri a bordo: " + this.getPasseggeriABordo());
    }

}
