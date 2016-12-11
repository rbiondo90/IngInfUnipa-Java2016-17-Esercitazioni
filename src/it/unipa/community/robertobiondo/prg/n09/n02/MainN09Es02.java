/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.n02;

import it.unipa.community.robertobiondo.prg.n08.es02.*;
import robertobiondo.utilities.MainUtils;
import java.util.HashMap;
import java.util.Map;
import robertobiondo.utilities.Utils;

/**
 *
 * @author Bob
 */
public class MainN09Es02 {

    public static void main(String args[]) {
        int scelta;
        Map<String, Shape> forme = new HashMap<>();
        do {
            MainN09Es02.printMainMenu();
            scelta = MainUtils.integerFromKeyboard(1, 3);
            switch (scelta) {
                case 1:
                    newShape(forme);
                    break;
                case 2:
                    pickShape(forme);
                    break;
                case 3:
                    break;

            }
        } while (scelta != 3);
    }

    public static void printNewShapeMenu() {
        MainUtils.printMenu("Scegliere la forma da creare", "Cerchio", "Rettangolo", "Quadrato", "Torna indietro");
    }

    public static void printMainMenu() {
        MainUtils.printMenu("Programma di test per la creazione di forma geometriche e la loro gestione tramite mappe."
                + "\nScegliere l'operazione da effettuare.", "Aggiungere una forma alla lista",
                "Estrarre e visualizzare un elemento", "Uscire dal programma");
    }

    public static void newShape(Map<String, Shape> forme) {
        MainN09Es02.printNewShapeMenu();
        int scelta = MainUtils.integerFromKeyboard(1, 4);
        String shapeName;
        try {
            switch (scelta) {
                case 1:
                    System.out.print("Inserire il nome del cerchio: ");
                    shapeName = MainUtils.stringFromKeyboard(0, 10);
                    double raggio = Utils.randomInt(100);
                    Circle cerchio = new Circle(raggio);
                    if (forme.putIfAbsent(shapeName, cerchio) != null) {
                        System.out.println("Nella mappa è già presente una forma con quel nome! "
                                + "Non sono state apportate modifiche.");
                    }
                    ;
                    break;
                case 2:
                    System.out.print("Inserire il nome del rettangolo: ");
                    shapeName = MainUtils.stringFromKeyboard(0, 10);
                    double base = Utils.randomInt(100);
                    double altezza = Utils.randomInt(100);
                    Rectangle rettangolo = new Rectangle(base, altezza);
                    if (forme.putIfAbsent(shapeName, rettangolo) != null) {
                        System.out.println("Nella mappa è già presente una forma con quel nome! "
                                + "Non sono state apportate modifiche.");
                    }
                    ;
                    break;
                case 3:
                    System.out.print("Inserire il nome del quadrato: ");
                    shapeName = MainUtils.stringFromKeyboard(0, 10);
                    double lato = Utils.randomInt(100);
                    Square quadrato = new Square(lato);
                    if (forme.putIfAbsent(shapeName, quadrato) != null) {
                        System.out.println("Nella mappa è già presente una forma con quel nome! "
                                + "Non sono state apportate modifiche.");
                    }
                    ;
                case 4:
                    break;
            }
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void pickShape(Map<String, Shape> forme) {
        System.out.println("Inserire il nome della figura da cercare nella mappa.");
        String shapeName = MainUtils.stringFromKeyboard(0, 10);
        try {
            forme.get(shapeName).draw();
        } catch (NullPointerException exc) {
            System.out.println("Nella mappa non è presente una forma con il nome " + shapeName + ".");
        }
    }

}
