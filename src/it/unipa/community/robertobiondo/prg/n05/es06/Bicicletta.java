/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es06;

/**
 *
 * @author Bob
 */
public class Bicicletta extends Veicolo {

    public Bicicletta() {
        this(new Vector2D(0, 0), new Vector2D(0, 0), Veicolo.ACCELERAZIONE_DI_DEFAULT);
    }

    public Bicicletta(Vector2D posizione, Vector2D velocitàIniziale, Vector2D accelerazione) {
        super(posizione, velocitàIniziale, accelerazione, 2, "bicicletta");
    }

    @Override
    public void muovi(double deltaT) {
        if (this.controlloPressione()) {
            double posizioneIniziale = this.getPosizione().getLength();
            double posizioneX = this.getPosizione().getX()+this.getVelocitàIniziale().getX()*deltaT + this.getAccelerazione().getX()*Math.pow(deltaT,2)*0.5;
            double posizioneY = Math.cos(posizioneX);
            this.setPosizione(new Vector2D(posizioneX,posizioneY));
            double mPercorsi = Math.abs(posizioneIniziale - this.getPosizione().getLength());
            System.out.print("\nIl veicolo " + this.getNomeVeicolo() + " si è spostato di " + String.format("%.2f", mPercorsi)
                    + " metri in " + String.format("%.0f", deltaT) + " secondi.");
            this.usuraRuote(mPercorsi);
        } else {
            System.out.println("\nPressione ruote troppo bassa. Effettuare un controllo prima di muovere il veicolo.");
        }

    }

}
