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
public abstract class VeicoloAMotore extends Veicolo {

    private final int CILINDRATA;

    public VeicoloAMotore(int cilindrata, int numeroRuote, String nomeVeicolo) {
        this(new Vector2D(0, 0), new Vector2D(0, 0), Veicolo.ACCELERAZIONE_DI_DEFAULT.scalarMult(cilindrata / 100), cilindrata, numeroRuote, nomeVeicolo);
    }

    public VeicoloAMotore(Vector2D posizione, Vector2D velocitàIniziale, Vector2D accelerazione, int cilindrata, int numeroRuote, String nomeVeicolo) {
        super(posizione, velocitàIniziale, accelerazione.scalarMult(Math.log(cilindrata)), numeroRuote, nomeVeicolo);
        this.CILINDRATA = cilindrata > 0 ? cilindrata : 100;
    }

    public int getCilindrata() {
        return this.CILINDRATA;
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
