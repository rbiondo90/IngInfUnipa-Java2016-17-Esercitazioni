/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es03;

import it.unipa.community.robertobiondo.prg.utilities.MainUtils;

/**
 *
 * @author Bob
 */
public class Main {

    public static void main(String args[]) {
        double x;
        double y;
        Point2D punto1;
        Point2D punto2;
        Point2D punto3;
        Line retta;
        System.out.println("Programma di test delle classi Point2D e Line. \nVerrano creati due punti del piano con coordinate inserite dall'utente, e si verificherà poi se"
                + "questi due punti individuano una retta (ovvero se non sono uguali)"
                + ".\nSe una retta è stata individuata, successivamente verranno richieste le coordinate di un terzo punto,"
                + "e verrà verificato se tale punto appartiene alla retta");
        System.out.print("Inserire la coordinata x del primo punto: ");
        x = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata y del primo punto: ");
        y = MainUtils.doubleFromKeyboard();
        punto1 = new Point2D(x, y);
        System.out.print("Inserire la coordinata x del secondo punto: ");
        x = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata y del secondo punto: ");
        y = MainUtils.doubleFromKeyboard();
        punto2 = new Point2D(x, y);
        System.out.println("Sono stati creati i due punti: " + punto1 + ", " + punto2);
        retta = new Line(punto1, punto2);
        System.out.println(((retta.getValidity()) ? ("I due punti individuano la retta: " + retta) : ("I due punti sono uguali e quindi non individuano una retta.")));
        if (retta.getValidity()) {
            System.out.print("Inserire la coordinata x del terzo punto: ");
            x = MainUtils.doubleFromKeyboard();
            System.out.print("Inserire la coordinata y del terzo punto: ");
            y = MainUtils.doubleFromKeyboard();
            punto3 = new Point2D(x, y);
            System.out.println(punto3 + ((retta.containsPoint(punto3)? (" "): (" non ")))+ "appartiene alla retta "+retta+".");
        }
    }

}
