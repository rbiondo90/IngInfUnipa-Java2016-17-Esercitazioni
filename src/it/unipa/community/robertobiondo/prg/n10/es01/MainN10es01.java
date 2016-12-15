/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n10.es01;

import it.unipa.community.robertobiondo.prg.n08.es08.MyIllegalDateException;

/**
 *
 * @author Roberto Biondo
 */
public class MainN10es01 {

    public static void main(String args[]) {
        Date d1 = new Date();
        Date d2 = d1.clone();
        System.out.println(String.join(" -- ", d1.toString(), d2.toString()));
        d1 = d1.aggiungiAnni(10);
        System.out.println(String.join(" -- ", d1.toString(), d2.toString()));

        Razionale r1 = new Razionale(0.5);
        Razionale r2 = r1.clone();
        System.out.println(String.join(" -- ", r1.toString(), r2.toString()));
        r1 = r1.somma(r1);
        System.out.println(String.join(" -- ", r1.toString(), r2.toString()));

        Complex c1 = new Complex(0.5);
        Complex c2 = c1.clone();
        System.out.println(String.join(" -- ", c1.toString(), c2.toString()));
        c1 = c1.somma(c1);
        System.out.println(String.join(" -- ", c1.toString(), c2.toString()));
    }
}
