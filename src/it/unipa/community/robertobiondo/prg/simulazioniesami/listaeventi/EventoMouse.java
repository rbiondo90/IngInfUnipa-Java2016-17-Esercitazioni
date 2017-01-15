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
public class EventoMouse extends Evento {

    private int posizioneX;
    private int posizioneY;

    public EventoMouse(int codiceIdentificativo, String descrizione, int posizioneX, int posizioneY) {
        super(codiceIdentificativo, descrizione);
        this.setPosizione(posizioneX, posizioneY);
    }

    private void setPosizioneX(int posizioneX) {
        if (posizioneY < 0) {
            throw new IllegalArgumentException("La posizione su schermo non può essere un numero negativo!");
        }
        this.posizioneX = posizioneX;
    }

    public int getPosizioneX() {
        return this.posizioneX;
    }

    private void setPosizioneY(int posizioneY) {
        if (posizioneY < 0) {
            throw new IllegalArgumentException("La posizione su schermo non può essere un numero negativo!");
        }
        this.posizioneY = posizioneY;
    }

    public int getPosizioneY() {
        return this.posizioneY;
    }

    private void setPosizione(int posizioneX, int posizioneY) {
        this.setPosizioneX(posizioneX);
        this.setPosizioneY(posizioneY);
    }

    @Override
    public String toString() {
        return super.toString().replace("GENERICO", "MOUSE").concat("Posizione puntatore: " + this.getPosizioneX() + "," + this.getPosizioneY() + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o) || !(o instanceof EventoMouse)) {
            return false;
        }
        EventoMouse e = (EventoMouse) o;
        return this.getPosizioneX() == e.getPosizioneX() && this.getPosizioneY() == e.getPosizioneY();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 11 * hash + this.posizioneX;
        hash = 11 * hash + this.posizioneY;
        return hash;
    }

}
