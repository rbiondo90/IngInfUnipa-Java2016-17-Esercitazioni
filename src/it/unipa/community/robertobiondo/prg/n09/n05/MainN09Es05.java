/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.n05;

import robertobiondo.utilities.MainUtils;

/**
 *
 * @author Roberto Biondo
 */
public class MainN09Es05 {

    public static void main(String args[]) {
        int scelta = 0;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        while (scelta != 7) {
            printMainMenu();
            scelta = MainUtils.integerFromKeyboard(0, 7);
            switch (scelta) {
                case 1:
                    try {
                        System.out.print("Digitare una stringa da aggiungere allo stack: ");
                        stringStack.push(MainUtils.stringFromKeyboard(0, 15));
                    } catch (StackException exc) {
                        System.out.println("Lo stack è pieno, non posso aggiungere elementi!");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Digitare un intero da da aggiungere allo stack : ");
                        integerStack.push(MainUtils.integerFromKeyboard());
                    } catch (StackException exc) {
                        System.out.println("Lo stack è pieno, non posso aggiungere elementi!");
                    }
                    break;
                case 3:
                    try {
                        String s = stringStack.pop();
                        System.out.println("Elemento prelevato: " + s + ".");
                    } catch (StackException exc) {
                        System.out.println("Stack vuoto, nessun elemento da prelevare.");
                    }
                    break;
                case 4:
                    try {
                        Integer i = integerStack.pop();
                        System.out.println("Elemento prelevato: " + i + ".");
                    } catch (StackException exc) {
                        System.out.println("Stack vuoto, nessun elemento da prelevare.");
                    }
                    break;
                case 5:
                    System.out.println(stringStack);
                    break;
                case 6:
                    System.out.println(integerStack);
                    break;
            }
        }
    }

    public static void printMainMenu() {
        MainUtils.printMenu("Programma che simula la gestione di uno stack di interi ed uno di stringhe",
                "Aggiungere una stringa", "Aggiungere un intero", "Prelevare una stringa", "Prelevare un intero",
                "Stampare lo stack di stringhe", "Stampare lo stack di interi", "Uscire");
    }

}
