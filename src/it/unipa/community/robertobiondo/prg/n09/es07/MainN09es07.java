/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.es07;

/**
 *
 * @author Roberto Biondo
 */
public class MainN09es07 {

    public static void main(String args[]) {
        String uno = "uno";
        String due = "due";
        String tre = "tre";
        System.out.println(uno + "\n" + due + "\n" + tre);
        String unione = String.join(" ", uno, due, tre);
        System.out.println(unione);
        String unioneMaiuscolaConTrattini = unione.toUpperCase().replace(" ", "--");
        System.out.println(unioneMaiuscolaConTrattini);
        String[] nuovamenteDivise = unioneMaiuscolaConTrattini.toLowerCase().split("--");
        for (int i = 0; i < nuovamenteDivise.length; i++) {
            System.out.println(nuovamenteDivise[i]);
        }
    }
}
