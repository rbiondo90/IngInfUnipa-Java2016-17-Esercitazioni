/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Roberto Biondo
 */
public class TestDatabaseStudenti {

    private static BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {
        DatabaseStudenti studenti = new DatabaseStudenti();
        System.out.println("Programma che simula la gestione di un database di studenti.\n");
        int scelta;
        String nome;
        String voto;
        do {
            stampaMenu();
            scelta = acquisisciScelta(5);
            switch (scelta) {
                case 1:
                    boolean acquisito = false;
                    boolean inserito = false;
                    nome = null;
                    voto = null;
                    do {
                        try {
                            System.out.print("Inserire il nome dello studente: ");
                            nome = acquisisciStringa();
                            System.out.print("Inserire il voto dello studente: ");
                            voto = acquisisciStringa();
                            inserito = studenti.aggiungiStudente(nome, voto);
                            acquisito = true;
                        } catch (IllegalArgumentException exc) {
                            System.out.println(exc.getMessage());
                        }
                    } while (!acquisito);
                    if (inserito) {
                        System.out.println("Studente " + nome + " inserito nel database con voto " + studenti.getVoto(nome) + ".");
                    } else {
                        System.out.println("Studente " + nome + " già presente nel database.");
                    }
                    break;
                case 2:
                    System.out.println("Digitare il nome delo studente di cui si vuole modificare il voto:");
                    studenti.stampaDatabase();
                    nome = acquisisciStringa();
                    String votoAttuale;
                    try {
                        votoAttuale = studenti.getVoto(nome);
                        if (votoAttuale != null) {
                            boolean aggiornato = false;
                            System.out.print("Voto attuale di " + nome + ": " + votoAttuale + ".\nInserire il nuovo voto: ");
                            do {
                                try {
                                    voto = acquisisciStringa();
                                    studenti.setVoto(nome, voto);
                                    aggiornato = true;
                                } catch (IllegalArgumentException exc) {
                                    System.out.print(exc.getMessage() + "\nInserire il nuovo voto: ");
                                }
                            } while (!aggiornato);
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.print(ex.getMessage());
                    }
                    break;
                case 3:
                    studenti.stampaDatabase();
                    System.out.print("Inserisci il nome dello studente da rimuovere: ");
                    nome = acquisisciStringa();
                    if (studenti.rimuoviStudente(nome)) {
                        System.out.println("Studente " + nome + " rimosso dal database.");
                    } else {
                        System.out.println("Studente " + nome + " non trovato nel database.");
                    }
                    break;
                case 4:
                    studenti.stampaDatabase();
                    break;
            }
            System.out.println();
        } while (scelta != 5);
    }

    public static void stampaMenu() {
        System.out.println("Scegliere l'operazione da svolgere: "
                + "\n1)Aggiungere uno studente alla lista"
                + "\n2)Modificare il voto di uno studente"
                + "\n3)Rimuovere uno studente dalla lista"
                + "\n4)Visualizzare la lista"
                + "\n5)Uscire dal programma");
    }

    public static String acquisisciStringa() {
        String s = null;
        do {
            try {
                s = tastiera.readLine();
            } catch (IOException ex) {
                System.out.printf("Eccezione! " + ex.getMessage() + "\nDigitare nuovamente la stringa: ");
            }
        } while (s == null);
        return s;
    }

    public static int acquisisciScelta(int max) {
        if (max < 1) {
            throw new IllegalArgumentException("Valore massimo richiesto non valido!");
        }
        int scelta = 0;
        do {
            try {
                scelta = Integer.parseInt(acquisisciStringa());
                if (scelta < 1 || scelta > max) {
                    throw new IllegalArgumentException("Inserire esclusivamente un numero intero compreso tra 1 e " + max);
                }
            } catch (IllegalArgumentException ex) {
                System.out.print(ex.getMessage() + ":");
            }
        } while (scelta < 1 || scelta > max);
        return scelta;
    }
}
