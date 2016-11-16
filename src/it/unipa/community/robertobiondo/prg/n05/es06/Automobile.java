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
public class Automobile extends VeicoloAMotore {

    private static final int CILINDRATA_DI_DEFAULT = 1000;

    public Automobile(Vector2D posizione, Vector2D velocitàIniziale, Vector2D accelerazione, int cilindrata) {
        super(posizione, velocitàIniziale, accelerazione, (cilindrata >= 500 && cilindrata <= 5000) ? cilindrata : Automobile.CILINDRATA_DI_DEFAULT, 4, "automobile");
    }

    public Automobile(int cilindrata) {
        this(new Vector2D(), new Vector2D(), Veicolo.ACCELERAZIONE_DI_DEFAULT, cilindrata);
    }

    public Automobile() {
        this(Automobile.CILINDRATA_DI_DEFAULT);
    }

    @Override
    public void muovi(double deltaT) {
        if (this.controlloPressione()) {
            double posizioneIniziale = this.getPosizione().getLength();
            this.setPosizione(this.getPosizione().sum(this.getVelocitàIniziale().scalarMult(deltaT), this.getAccelerazione().scalarMult(Math.pow(deltaT, 2) * 0.5)));
            double mPercorsi = Math.abs(posizioneIniziale - this.getPosizione().getLength());
            System.out.print("\nIl veicolo " + this.getNomeVeicolo() + " si è spostato di " + String.format("%.2f", mPercorsi)
                    + " metri in " + String.format("%.0f", deltaT) + " secondi.");
            this.usuraRuote(mPercorsi);
        } else {
            System.out.println("\nPressione ruote troppo bassa. Effettuare un controllo prima di muovere il veicolo.");
        }

    }
}
