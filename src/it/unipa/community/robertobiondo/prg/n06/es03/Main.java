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
public class Main {

    public static void main(String args[]) {
        Coin moneta = new Coin("T", "C");
        Dice dadoA6Facce = new Dice();
        int risultato;
        risultato = moneta.roll(true);
        System.out.println("\nE' uscito " + moneta.getSideName(risultato) + ".");
        risultato = dadoA6Facce.roll(true);
        System.out.println("\nE' uscito " + dadoA6Facce.getSideName(risultato) + ".");
    }
}
