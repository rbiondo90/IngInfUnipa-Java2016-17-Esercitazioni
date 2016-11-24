/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n07.es04;

/**
 *
 * @author Roberto Biondo
 */
public class AritmeticaTest {

    public static void main(String args[]) {
        Razionale r1 = new Razionale(1, 2);
        Razionale r2 = new Razionale(2, 1);
        r1.stampa();
        r2.stampa();
        r1.somma(r2).stampa();
        r1.sottrai(r2).stampa();
        r1.moltiplica(r2).stampa();
        r1.dividi(r2).stampa();
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(2, 1);
        c1.stampa();
        c2.stampa();
        c1.somma(c2).stampa();
        c1.sottrai(c2).stampa();
        c1.moltiplica(c2).stampa();
        c1.dividi(c2).stampa();

    }
}
