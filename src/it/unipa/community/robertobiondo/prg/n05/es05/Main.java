/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es05;

import it.unipa.community.robertobiondo.prg.utilities.MainUtils;

/**
 *
 * @author Bob
 */
public class Main {

    public static void main(String args[]) {
        int scelta;
        do {
            Main.printMainMenu();
            scelta = MainUtils.integerFromKeyboard(1, 4);
            switch (scelta) {
                case 1:
                    System.out.print("Inserire il raggio del cerchio in cm: ");
                    double raggio = MainUtils.doubleFromKeyboard();
                    Circle cerchio = new Circle(raggio);
                    cerchio.print();
                    break;
                case 2:
                    System.out.print("Inserire la base del rettangolo in cm: ");
                    double base = MainUtils.doubleFromKeyboard();
                    System.out.print("Inserire l'altezza del rettangolo in cm: ");
                    double altezza = MainUtils.doubleFromKeyboard();
                    Rectangle rettangolo = new Rectangle(base,altezza);
                    rettangolo.print();
                    break;
                case 3:
                    System.out.print("Inserire il lato del quadrato in cm: ");
                    double lato = MainUtils.doubleFromKeyboard();
                    Square quadrato = new Square(lato);
                    quadrato.print();
                    break;
                case 4:
                    break;

            }
        } while (scelta != 4);
    }

    public static void printMainMenu() {
        MainUtils.printMenu("Programma di test per la creazione di forme geometriche.\nScegliere la forma da creare", "Cerchio", "Rettangolo", "Quadrato", "Esci dal programma");
    }
}
