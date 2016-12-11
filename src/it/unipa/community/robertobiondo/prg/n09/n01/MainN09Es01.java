/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.n01;

import it.unipa.community.robertobiondo.prg.n08.es02.*;
import robertobiondo.utilities.MainUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Bob
 */
public class MainN09Es01 {

    public static void main(String args[]) {
        int scelta;
        List<Shape> forme = new ArrayList<>();
        do {
            MainN09Es01.printMainMenu();
            scelta = MainUtils.integerFromKeyboard(1, 3);
            switch (scelta) {
                case 1:
                    newShape(forme);
                    break;
                case 2:
                    drawShapes(forme);
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
        MainUtils.printMenu("Programma di test per la creazione di forma geometrice.\nScegliere l'operazione da effettuare.", "Aggiungere una forma alla lista",
                "Visualizzare la lista", "Uscire dal programma");
    }

    public static void newShape(List<Shape> forme) {
        MainN09Es01.printNewShapeMenu();
        int scelta = MainUtils.integerFromKeyboard(1, 4);
        try {
            switch (scelta) {
                case 1:
                    System.out.print("Inserire il raggio del cerchio in cm: ");
                    double raggio = MainUtils.doubleFromKeyboard();
                    Circle cerchio = new Circle(raggio);
                    forme.add(cerchio);
                    break;
                case 2:
                    System.out.print("Inserire la base del rettangolo in cm: ");
                    double base = MainUtils.doubleFromKeyboard();
                    System.out.print("Inserire l'altezza del rettangolo in cm: ");
                    double altezza = MainUtils.doubleFromKeyboard();
                    Rectangle rettangolo = new Rectangle(base, altezza);
                    forme.add(rettangolo);
                    break;
                case 3:
                    System.out.print("Inserire il lato del quadrato in cm: ");
                    double lato = MainUtils.doubleFromKeyboard();
                    Square quadrato = new Square(lato);
                    forme.add(quadrato);
                    break;
                case 4:
                    break;
            }
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void drawShapes(List<Shape> forme) {
        if (forme.isEmpty()) {
            System.out.println("Lista vuota!");
        } else {
            System.out.println("---------------------------------");
            Iterator<Shape> iteratore = forme.iterator();
            while (iteratore.hasNext()) {
                iteratore.next().draw();
            }
            System.out.println("---------------------------------");
        }
    }
}
