/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es04;

import robertobiondo.utilities.MainUtils;

/**
 *
 * @author Bob
 */
public class Main {

    public static void main(String args[]) {
        double x;
        double y;
        double z;
        Point3D punto1;
        Point3D punto2;
        Point3D punto3;
        Point3D punto4;
        Plane piano;
        System.out.println("Programma di test delle classi Point3D e Plane. \nVerrano creati tre punti dello spazio con coordinate inserite dall'utente, e si verificherà poi se"
                + "questi tre punti individuano una piano.\nSe un piano è stato individuato, successivamente verranno richieste le coordinate di un quarto punto,"
                + "e verrà verificato se tale punto appartiene al piano");
        System.out.print("Inserire la coordinata x del primo punto: ");
        x = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata y del primo punto: ");
        y = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata z del primo punto: ");
        z = MainUtils.doubleFromKeyboard();
        punto1 = new Point3D(x, y, z);
        System.out.print("Inserire la coordinata x del secondo punto: ");
        x = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata y del secondo punto: ");
        y = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata z del secondo punto: ");
        z = MainUtils.doubleFromKeyboard();
        punto2 = new Point3D(x, y, z);
        System.out.print("Inserire la coordinata x del terzo punto: ");
        x = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata y del terzo punto: ");
        y = MainUtils.doubleFromKeyboard();
        System.out.print("Inserire la coordinata z del terzo punto: ");
        z = MainUtils.doubleFromKeyboard();
        punto3 = new Point3D(x, y, z);
        System.out.println("Sono stati creati i tre punti: " + punto1 + ", " + punto2 + ", " + punto3);
        piano = new Plane(punto1, punto2, punto3);
        System.out.println(((piano.getValidity()) ? ("I tre punti individuano il piano: " + piano) : ("I tre punti sono allineati e quindi non individuano un piano.")));
        if (piano.getValidity()) {
            System.out.print("Inserire la coordinata x del quarto punto: ");
            x = MainUtils.doubleFromKeyboard();
            System.out.print("Inserire la coordinata y del quarto punto: ");
            System.out.print("Inserire la coordinata z del quarto punto: ");
            z = MainUtils.doubleFromKeyboard();
            y = MainUtils.doubleFromKeyboard();
            punto4 = new Point3D(x, y, z);
            System.out.println(punto4 + ((piano.containsPoint(punto4) ? (" ") : (" non "))) + "appartiene al piano " + piano + ".");
        }
    }

}
