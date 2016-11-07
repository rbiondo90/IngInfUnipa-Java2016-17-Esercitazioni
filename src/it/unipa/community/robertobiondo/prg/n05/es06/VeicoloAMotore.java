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
}
