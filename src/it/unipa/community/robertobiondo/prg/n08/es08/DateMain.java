/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es08;


/**
 *
 * @author Roberto Biondo
 */
public class DateMain {

    public static void main(String args[]) {
        Date d1 = null, d2 = null;
        try {
            d1 = new Date(12, "Aprile", 1990);
        } catch (MyIllegalDateException exc) {
            System.out.println(exc);
        }
        try {
            d1.stampa();
        } catch (NullPointerException exc) {
            System.out.println("Oggetto non inizializzato!");
        }
        try {
            d2 = new Date(120, 1990);
        } catch (MyIllegalDateException exc) {
            System.out.println(exc);
        }
        try {
            d2.stampa();
        } catch (NullPointerException exc) {
            System.out.println("Oggetto non inizializzato!");
        }
    }
}
