/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.rubrica;

import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class AcquisitoreInput {

    private static final Scanner TASTIERA = new Scanner(System.in);

    public static String acquisisciStringa(int lunghezzaMinima) {
        if (lunghezzaMinima < 0) {
            throw new IllegalArgumentException("La lunghezza minima della stringa richiesta non può essere minore di zero!");
        }
        boolean acquisita = false;
        String s = "";
        do {
            s = TASTIERA.nextLine();
            if (s.length() < lunghezzaMinima) {
                System.out.print("Input non corretto! Inserire una stringa di almeno " + lunghezzaMinima + " caratteri: ");
            } else {
                acquisita = true;
            }
        } while (!acquisita);
        return s;
    }

    public static String acquisisciStringa() {
        return acquisisciStringa(0);
    }

    public static char acquisisciCarattere(char da, char a) {
        boolean acquisito = false;
        char c = 0;
        do {
            String s = acquisisciStringa(1).trim();
            if (s.length() == 1) {
                c = s.charAt(0);
                if (c >= da && c <= a) {
                    acquisito = true;
                }
            }
            if (!acquisito) {
                System.out.print("Digitare un singolo carattere compreso tra " + da + " e " + a + ":");
            }
        } while (!acquisito);
        return c;
    }

}
