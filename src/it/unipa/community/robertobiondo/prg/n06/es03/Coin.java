/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n06.es03;

/**
 *
 * @author Roberto Biondo
 */
public class Coin extends MultiSidedItem {

    public Coin(String sideName1, String sideName2) {
        super(2, sideName1, sideName2);
    }

    public Coin() {
        super(2, "H", "T");
    }
}
