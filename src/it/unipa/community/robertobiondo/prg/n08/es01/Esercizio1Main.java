/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es01;

import it.unipa.community.robertobiondo.prg.utilities.MainUtils;

/**
 *
 * @author Roberto Biondo
 */
public class Esercizio1Main {

    public static void main(String args[]) {
        int scelta;
        int frazioneODouble;
        Razionale r1 = new Razionale();
        Razionale r2 = new Razionale();
        do {
            printMainMenu();
            scelta = MainUtils.integerFromKeyboard(1, 5);
            if (scelta != 5) {
                printNewRazionaleMenu();
                frazioneODouble = MainUtils.integerFromKeyboard(1, 2);
                switch (frazioneODouble) {
                    case 1:
                        System.out.print("\nInserire la prima frazione: ");
                        r1 = razionaleFromKeyboard();
                        System.out.print("\nInserire la seconda frazione: ");
                        r2 = razionaleFromKeyboard();
                        break;
                    case 2:
                        double d1,
                         d2;
                        System.out.print("\nInserire il primo double: ");
                        d1 = MainUtils.doubleFromKeyboard();
                        System.out.print("\nInserire il secondo double: ");
                        d2 = MainUtils.doubleFromKeyboard();
                        r1 = new Razionale(d1);
                        r2 = new Razionale(d2);
                        break;
                }
            }
            switch (scelta) {
                case 1:
                    System.out.println(r1 + ((r2.getDenominatore() > 0) ? " + " : " - ") + r2.valoreAssoluto()
                            + " = " + r1.somma(r2));
                    break;
                case 2:
                    System.out.println(r1 + ((r2.getDenominatore() > 0) ? " - " : " + ") + r2.valoreAssoluto()
                            + " = " + r1.sottrai(r2));
                    break;
                case 3:
                    System.out.println(r1 + ((r2.getDenominatore() > 0) ? (" * " + r2) : " * (" + r2 + ")")
                            + " = " + r1.moltiplica(r2));
                    break;
                case 4:
                    try {
                        System.out.println(r1 + ((r2.getDenominatore() > 0) ? (" / " + r2) : " / (" + r2 + ")")
                                + " = " + r1.dividi(r2));
                    } catch (ArithmeticException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
            }
        } while (scelta != 5);
    }

    public static void printMainMenu() {
        MainUtils.printMenu("Programma di test per la gestione di numeri razionali ed eccezioni ad essi legate.\nScegliere una funzione",
                "Somma", "Sottrazione", "Moltiplicazione", "Divisione", "Esci dal programma");
    }

    public static void printNewRazionaleMenu() {
        MainUtils.printMenu("Si vogliono inserire i razionali direttamente come frazioni oppure come double?", "Frazioni", "Double");
    }

    public static Razionale razionaleFromKeyboard() {
        boolean validità = false;
        Razionale r = new Razionale();
        do {
            try {
                String s = MainUtils.stringFromKeyboard();
                r = new Razionale(s);
                validità = true;
            } catch (NumberFormatException exc) {
                System.out.println(exc.getMessage());
            } catch (ArithmeticException exc) {
                System.out.println(exc.getMessage());
                validità = false;
            }
        } while (!validità);
        return r;
    }

}
