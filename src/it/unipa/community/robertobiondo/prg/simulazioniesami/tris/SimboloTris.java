/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tris;

/**
 *
 * @author Roberto Biondo
 */
public enum SimboloTris {
    VUOTO, CERCHIO, CROCE;

    @Override
    public String toString() {
        switch (this) {
            case CERCHIO:
                return "O";
            case CROCE:
                return "X";
            default:
                return " ";
        }
    }
}
