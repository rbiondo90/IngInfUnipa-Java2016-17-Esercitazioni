/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.es09;

import it.unipa.community.robertobiondo.prg.n08.es08.MyIllegalDateException;

/**
 *
 * @author Roberto Biondo
 */
public class MainN09es09 {

    public static void main(String args[]) {
        Date d1 = new Date();
        Date d2 = null;
        Date d3 = null;
        try {
            d2 = new Date(12, 04, 1990);
            d3 = new Date(12, "Aprile", 1990);
        } catch (MyIllegalDateException exc) {
            System.out.println("Data non valida!");
        }
        System.out.println(d1 + " = " + d2 + " ? " + d1.equals(d2));
        System.out.println(d2 + " = " + d3 + " ? " + d2.equals(d3));
        System.out.println("HashCode di " + d1 + " = " + d1.hashCode());
        System.out.println("HashCode di " + d2 + " = " + d2.hashCode());
        System.out.println("HashCode di " + d3 + " = " + d3.hashCode());

        Razionale r1 = new Razionale(0.5);
        Razionale r2 = new Razionale("1/2");
        Razionale r3 = new Razionale();
        System.out.println(r1 + " = " + r2 + " ? " + r1.equals(r2));
        System.out.println(r2 + " = " + r3 + " ? " + r2.equals(r3));
        System.out.println("HashCode di " + r1 + " = " + r1.hashCode());
        System.out.println("HashCode di " + r2 + " = " + r2.hashCode());
        System.out.println("HashCode di " + r3 + " = " + r3.hashCode());

        Complex c1 = new Complex(0.5);
        Complex c2 = new Complex(new Razionale(1, 2).toDouble());
        Complex c3 = new Complex(1, 4);
        System.out.println(c1 + " = " + c2 + " ? " + c1.equals(c2));
        System.out.println(c2 + " = " + c3 + " ? " + c2.equals(c3));
        System.out.println("HashCode di " + c1 + " = " + c1.hashCode());
        System.out.println("HashCode di " + c2 + " = " + c2.hashCode());
        System.out.println("HashCode di " + c3 + " = " + c3.hashCode());
    }
}
