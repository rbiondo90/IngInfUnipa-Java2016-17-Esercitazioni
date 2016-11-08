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
public abstract class Veicolo {

    private Vector2D posizione;
    private Vector2D velocitàIniziale;
    private Vector2D accelerazione;
    private final Ruota ruote[];
    private final String NOME_VEICOLO;
    public static final Vector2D ACCELERAZIONE_DI_DEFAULT = new Vector2D(1/Math.sqrt(2),1/Math.sqrt(2));

    public Veicolo(int numeroRuote, String nomeVeicolo) {
        this(new Vector2D(), new Vector2D(), Veicolo.ACCELERAZIONE_DI_DEFAULT, numeroRuote, nomeVeicolo);
    }

    public Veicolo(Vector2D posizione, Vector2D velocitàIniziale, Vector2D accelerazione, int numeroRuote, String nomeVeicolo) {
        this.setPosizione(posizione);
        this.setVelocitàIniziale(velocitàIniziale);
        this.setAccelerazione(accelerazione);
        this.ruote = new Ruota[numeroRuote];
        for (int i = 0; i < numeroRuote; i++) {
            ruote[i] = new Ruota();
        }
        this.NOME_VEICOLO = nomeVeicolo;
    }

    public void setPosizione(Vector2D posizione) {
        this.posizione = posizione.clone();
    }

    public Vector2D getPosizione() {
        return this.posizione;
    }

    public void setVelocitàIniziale(Vector2D velocitàIniziale) {
        this.velocitàIniziale = velocitàIniziale.clone();
    }

    public Vector2D getVelocitàIniziale() {
        return this.velocitàIniziale;
    }

    public void setAccelerazione(Vector2D accelerazione) {
        this.accelerazione = accelerazione.clone();
    }

    public Vector2D getAccelerazione() {
        return this.accelerazione;
    }

    public Ruota getRuota(int numeroRuota) {
        return (this.ruote.length > numeroRuota) ? this.ruote[numeroRuota] : null;
    }

    public int getNumeroRuote() {
        return ruote.length;
    }

    public String getNomeVeicolo() {
        return this.NOME_VEICOLO;
    }

    public void muovi(double deltaT) {
        if (this.controlloPressione()) {
            double posizioneIniziale = this.getPosizione().getLength();
            this.setPosizione(this.getPosizione().sum(this.getVelocitàIniziale().scalarMult(deltaT), this.getAccelerazione().scalarMult(Math.pow(deltaT, 2) * 0.5)));
            double mPercorsi = Math.abs(posizioneIniziale - this.getPosizione().getLength());
            System.out.print("\nIl veicolo " + this.getNomeVeicolo() + " si è spostato di " + String.format("%.2f", mPercorsi) +
                    " metri in " + String.format("%.0f", deltaT) + " secondi.");
            this.usuraRuote(mPercorsi);
        } else {
            System.out.println("\nPressione ruote troppo bassa. Effettuare un controllo prima di muovere il veicolo.");
        }

    }

    public boolean controlloPressione() {
        for (int i = 0; i < this.getNumeroRuote(); i++) {
            if (this.getRuota(i).getPressione() < 20) {
                return false;
            }
        }
        return true;
    }

    public void usuraRuote(double kmPercorsi) {
        for (int i = 0; i < this.getNumeroRuote(); i++) {
            this.getRuota(i).setPressione(this.getRuota(i).getPressione() - this.getRuota(i).getCoeffPressione() * kmPercorsi);
            if (this.getRuota(i).getPressione() < 0) {
                this.getRuota(i).setPressione(0);
            }
        }
    }

    public void gonfiaRuote() {
        for (int i = 0; i < this.getNumeroRuote(); i++) {
            this.getRuota(i).setPressione(100);
        }
    }

}
