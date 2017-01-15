/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.listaeventi;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class GestioneEventi {

    private static Scanner tastiera = new Scanner(System.in);

    public static void main(String args[]) {
        while(true){
            System.out.println(acquisisciIntero(0,10));
        }
    }

    private static String acquisisciStringa() {
        String s = null;
        do {
            s = tastiera.nextLine();
            if (s == null || s.isEmpty()) {
                System.out.println("Inserire una stringa valida!");
            }
        } while (s == null || s.isEmpty());
        return s;
    }

    private static int acquisisciIntero(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Il parametro \"min\" deve essere minore del parametro \"max\"!");
        }
        int i = 0;
        boolean acquisito = false;
        do {
            try {
                i = tastiera.nextInt();
                if (i >= min && i <= max) {
                    acquisito = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException exc) {
                System.out.println("Input non corretto! Inserire un intero compreso tra " + min + " e " + max + ".");
                tastiera.nextLine();
            }
        } while (!acquisito);
        tastiera.nextLine();
        return i;
    }
    
    private static void printMenu(){
        
    }
}
