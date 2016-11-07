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

}
