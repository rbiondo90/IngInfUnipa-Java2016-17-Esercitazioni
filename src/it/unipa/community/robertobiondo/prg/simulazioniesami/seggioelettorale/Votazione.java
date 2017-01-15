/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.seggioelettorale;

import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class Votazione {

    private static final Scanner TASTIERA = new Scanner(System.in);

    public static void main(String args[]) {
        Seggio seggio = new Seggio();
        System.out.println("Programma che simula la gestione delle votazioni in un seggio elettorale studentesco.");
        while (true) {
            System.out.print("Inserire la matricola dello studente votante: ");
            long matricola = acquisisciLong(1);
            System.out.print("Inserire il codice di controllo dello studente votante: ");
            long codiceDiControllo = acquisisciLong();
            Studente votante = seggio.studenteAbilitato(matricola, codiceDiControllo);
            System.out.println();
            if (votante == null) {
                System.out.println("Matricola e/o codice di controllo errati!");
            } else if (seggio.giaVotato(votante)) {
                System.out.println("Lo studente " + votante.getCognome() + " " + votante.getNome() + " ha già votato.");
            } else {
                System.out.println("Votazione dello studente " + votante.getCognome() + " " + votante.getNome() + ".\n");
                seggio.stampaCandidati(false);
                System.out.print("\nInserire la matricola del candidato che si vuole votare (quella a sinistra del nome), indicare 0 per lasciare la scheda bianca: ");
                matricola = acquisisciLong(0);
                seggio.registraVoto(votante, matricola);
                System.out.println();
                seggio.spoglio();
            }
            System.out.println();
        }
    }

    public static long acquisisciLong(long minimo) {
        boolean acquisito = false;
        long l = 0;
        do {
            if (TASTIERA.hasNextLong()) {
                l = TASTIERA.nextLong();
                if (l < minimo) {
                    System.out.print("Inserire esclusivamente un numero intero maggiore o uguale a " + minimo + ": ");
                } else {
                    acquisito = true;
                }
            } else {
                TASTIERA.nextLine();
                System.out.print("Inserire esclusivamente un numero intero maggiore o uguale a " + minimo + ": ");
            }
        } while (!acquisito);
        TASTIERA.nextLine();
        return l;
    }

    public static long acquisisciLong() {
        return acquisisciLong(Long.MIN_VALUE);
    }
}
