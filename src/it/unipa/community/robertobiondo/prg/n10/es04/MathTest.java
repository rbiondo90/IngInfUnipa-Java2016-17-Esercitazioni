/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n10.es04;

import robertobiondo.utilities.MainUtils;

/**
 *
 * @author Roberto Biondo
 */
public class MathTest {

    public static void main(String args[]) {
        System.out.println("Inserire un double: ");
        double x = MainUtils.doubleFromKeyboard();
        System.out.println("Inserire un altro double: ");
        double y = MainUtils.doubleFromKeyboard();
        System.out.println("x = " + x);
        System.out.println("|x| = " + Math.abs(x));
        System.out.println("Arrotondamento nearest di x = " + Math.round(x));
        System.out.println("Arrotondamento per eccesso di x = " + Math.ceil(x));
        System.out.println("Arrotondamento per difetto di x = " + Math.floor(x));
        System.out.println("Numero maggiore fra x e y = " + Math.max(x, y));
        System.out.println("Numero minore fra x e y  = " + Math.min(x, y));
        double rand = Math.random();
        System.out.println("x * " + rand + " = " + (x * rand));
        System.out.println("e^x = " + Math.exp(x));
        System.out.println("y^x = " + Math.pow(y,x));
        System.out.println("Radice quadrata di x = " + Math.sqrt(x));
    }
}
