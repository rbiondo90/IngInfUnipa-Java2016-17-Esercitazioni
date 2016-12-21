/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n10.es06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Roberto Biondo
 */
public class MainN10Es06 {

    public static void main(String args[]) {
        VectorInteger v1 = new VectorInteger(1, 1, 1);
        System.out.println("Vettore 1: " + v1 + "\nModulo del vettore: " + v1.length());
        VectorInteger v2 = new VectorInteger(0, 1, 0);
        System.out.println("Vettore 2: " + v2 + "\nModulo del vettore: " + v2.length());
        System.out.println("Vettore 1 + vettore 2 : " + v1.add(v2) + "\nVettore 1 - vettore 2: " + v1.subtract(v2));
    }
}
