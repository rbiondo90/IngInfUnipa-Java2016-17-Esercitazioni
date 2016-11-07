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
public class Ciclomotore extends VeicoloAMotore {

    private static final int CILINDRATA_DI_DEFAULT = 50;

    public Ciclomotore(int cilindrata) {
        this(new Vector2D(), new Vector2D(), Veicolo.ACCELERAZIONE_DI_DEFAULT, cilindrata);
    }

    public Ciclomotore() {
        this(Ciclomotore.CILINDRATA_DI_DEFAULT);
    }

    public Ciclomotore(Vector2D posizione, Vector2D velocitàIniziale, Vector2D accelerazione, int cilindrata) {
        super(posizione, velocitàIniziale, accelerazione, (cilindrata >= 50 && cilindrata <= 80) ? cilindrata : Ciclomotore.CILINDRATA_DI_DEFAULT, 2, "ciclomotore");
    }

}
