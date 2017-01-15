/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tennis;

import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class TestIncontro {

    public static void main(String args[]) {
        Giocatore giocatore1;
        Giocatore giocatore2;
        System.out.println("Programma che simula una partita di tennis fra due giocatori.");
        System.out.print("Inserire nome, cognome e posizione in classifica del giocatore 1 separati da uno spazio: ");
        giocatore1 = acquisisciGiocatore();
        System.out.print("Inserire nome, cognome e posizione in classifica del giocatore 2 separati da uno spazio: ");
        giocatore2 = acquisisciGiocatore();
        Incontro incontro = new Incontro(giocatore1, giocatore2);
        incontro.simulaIncontro();
    }

    private static Giocatore acquisisciGiocatore() {
        Scanner tastiera = new Scanner(System.in);
        Giocatore giocatore = null;
        boolean acquisito = false;
        do {
            String s = tastiera.nextLine();
            try {
                String[] split = s.split(" ");
                giocatore = new Giocatore(split[0], split[1], Integer.parseInt(split[2]));
                acquisito = true;
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException exc) {
                System.out.println("Erorre nei dati inseriti: " + exc.getMessage());
                System.out.print("Reinserire i dati del giocatore: ");
            }
        } while (!acquisito);
        return giocatore;
    }
}
