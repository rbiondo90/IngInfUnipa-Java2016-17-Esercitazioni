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
        Vector<Byte> vb = new Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Vector<Long> vl = new Vector(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Vector<Double> vd = new Vector(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0);
        System.out.println(vb + "\n" + vl + "\n" + vd);
        List<Double> ld = new ArrayList<>();
        Double[] dv = new Double[]{1D, 2D, 3D, 4D, 5D, 6D, 7D, 8D, 9D, 10D};
        Vector<Double> vd2 = new Vector<>(dv);
        System.out.println(vd2);
        System.out.println(vd.add(vd2));
        System.out.println(vd.subtract(vd2));
        System.out.println(vd.scalarProduct(vd2));
        Vector<Double> vd3 = new Vector(1,2,3,4);
        //Lancia eccezione vd.add(vd3);
        System.out.println(vd.realProduct(15));
    }
}
