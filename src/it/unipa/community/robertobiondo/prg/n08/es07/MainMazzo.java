/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es07;

/**
 *
 * @author Roberto Biondo
 */
public class MainMazzo {

    public static void main(String args[]) {
        Mazzo mazzo = new Mazzo();
        mazzo.mescola();
        mazzo.stampa();
        mazzo.pesca(38);
        mazzo.stampa();
        mazzo.pesca(10,true);
        mazzo.stampa();
    }
}
