/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.tris;

import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class Tris {

    private static Scanner tastiera = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Benvenuti nel gioco del tris!");
        int scelta = 0;
        do {
            printMainMenu();
            scelta = acquisisciScelta(2);
            System.out.println();
            if (scelta == 1) {
                Giocatore giocatore1 = inizializzaGiocatore(1);
                Giocatore giocatore2 = inizializzaGiocatore(2);
                ScacchieraTris scacchiera = new ScacchieraTris();
                boolean partitaFinita = false;
                do {
                    System.out.println("Turno di " + giocatore1.getNome());
                    giocatore1.gioca(scacchiera);
                    partitaFinita = controllaStatoPartita(scacchiera, giocatore1);
                    if (partitaFinita) {
                        break;
                    }
                    System.out.println("Turno di " + giocatore2.getNome());
                    giocatore2.gioca(scacchiera);
                    partitaFinita = controllaStatoPartita(scacchiera, giocatore2);
                } while (!partitaFinita);
            }
        } while (scelta != 2);
    }

    private static void printMainMenu() {
        System.out.println("Scegliere l'operazione da effettuare: "
                + "\n1)Iniziare una nuova partita"
                + "\n2)Uscire dal programma");
    }

    private static int acquisisciScelta(int max) {
        if (max < 1) {
            throw new IllegalArgumentException("Valore massimo non valido! Deve essere maggiore di zero!");
        }
        boolean acquisita = false;
        int scelta;
        do {
            while (!tastiera.hasNextInt()) {
                System.out.print("Inserire esclusivamente interi compresi tra 1 e " + max + ":");
                tastiera.nextLine();
            }
            scelta = tastiera.nextInt();
            if (scelta > 0 && scelta <= max) {
                acquisita = true;
            } else {
                System.out.print("Inserire esclusivamente interi compresi tra 1 e " + max + ":");
            }
        } while (!acquisita);
        tastiera.nextLine();
        return scelta;
    }

    private static Giocatore inizializzaGiocatore(int numeroGiocatore) {
        stampaMenuGiocatore(numeroGiocatore);
        int scelta = acquisisciScelta(2);
        SimboloTris simbolo = (numeroGiocatore == 1) ? SimboloTris.CERCHIO : SimboloTris.CROCE;
        switch (scelta) {
            case 1:
                System.out.print("Inserire il nome del giocatore: ");
                String nome = tastiera.nextLine();
                return new GiocatoreUmano(nome, simbolo);
            case 2:
            default:
                return new GiocatoreIA(simbolo);
        }
    }

    private static void stampaMenuGiocatore(int numeroGiocatore) {
        System.out.println("Giocatore " + numeroGiocatore + ":"
                + "\n1)Umano"
                + "\n2)IA");
    }

    private static boolean controllaStatoPartita(ScacchieraTris scacchiera, Giocatore giocatore) {
        scacchiera.stampa();
        if (scacchiera.controllaVittoria() != SimboloTris.VUOTO) {
            System.out.println("Il giocatore " + giocatore.getNome() + " ha vinto la partita! ");
            return true;
        }
        if (scacchiera.scacchieraPiena()) {
            System.out.println("La partita è finita in pareggio.");
            return true;
        }
        return false;
    }
}
