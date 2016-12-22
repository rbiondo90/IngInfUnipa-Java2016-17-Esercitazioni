package it.unipa.community.robertobiondo.prg.n11.es02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class GestoreTrafficoPorto {

    private static BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {
        Porto porto = new Porto();
        System.out.println("Programma che simula la gestione delle navi presenti in un porto.");
        int scelta;
        do {
            stampaMenu();
            scelta = acquisisciScelta(6);
            switch (scelta) {
                case 1:
                    if (porto.aggiungiNave(generaNave())) {
                        System.out.println("Nave aggiunta correttamente.");
                    } else {
                        System.out.println("Nave già presente o nave inizializzata non valida. Nessuna modifica effettuata.");
                    }
                    break;
                case 2:
                    System.out.print("Inserire il nome della nave che si vuole eliminare: ");
                    String nome = acquisisciStringa();
                    if (porto.rimuoviNave(nome)) {
                        System.out.println("Nave rimossa correttamente.");
                    } else {
                        System.out.println("Nave non trovata! Nessuna modifica effettuata.");
                    }
                    break;
                case 3:
                    if (porto.getNumeroNavi() == 0) {
                        System.out.println("Nessuna nave presente.");
                    } else {
                        porto.avanzaTutteLeNavi();
                        System.out.println("Tutte le navi sono avanzate.");
                    }
                    break;
                case 4:
                    porto.stampaStatoNaviPresenti();
                    break;
                case 5:
                    porto.verificaCollisioni();
                    break;
            }
        } while (scelta != 6);
    }

    private static void stampaMenu() {
        System.out.println("\nScegliere l'operazione da svolgere:\n\n"
                + "1)Aggiungere una nave\n"
                + "2)Eliminare una nave\n"
                + "3)Far avanzare tutte le navi\n"
                + "4)Stampa la lista delle navi\n"
                + "5)Controlla se ci sono navi in rotta di collisione\n"
                + "6)Uscire dal programma\n");
    }

    private static int acquisisciScelta(int max) {
        int scelta = 0;
        boolean acquisita = false;
        do {
            try {
                scelta = Integer.parseInt(acquisisciStringa());
                if (scelta < 1 || scelta > max) {
                    throw new IllegalArgumentException("Errore! Inserire solo valori compresi tra 1 e " + max + "!");
                }
                acquisita = true;
            } catch (IllegalArgumentException | InputMismatchException exc) {
                System.out.println(exc.getMessage());
            }
        } while (!acquisita);
        return scelta;
    }

    private static String acquisisciStringa() {
        String s = null;
        boolean acquisita = false;
        do {
            try {
                s = tastiera.readLine();
                acquisita = true;
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        } while (!acquisita);
        return s;
    }

    private static Nave generaNave() {
        Nave nave = null;
        boolean inizializzata = false;
        do {
            try {
                System.out.print("Inserire il nome della nave da aggiungere: ");
                String nome = acquisisciStringa();
                Double posizioneX = Math.random() * 100;
                Double posizioneY = Math.random() * 100;
                Double velocita = Math.random() * 75;
                Integer direzione = (int) Math.round(Math.random() * 360);
                Double larghezza = 1 + Math.random() * 25;
                Double lunghezza = larghezza * 3 + Math.random() * larghezza * 2;
                Integer passeggeriABordo = (int) (1 + Math.random() * larghezza * lunghezza / 10);
                nave = new Nave(nome, posizioneX, posizioneY, velocita, direzione, larghezza, lunghezza, passeggeriABordo);
                inizializzata = true;
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        } while (!inizializzata);
        return nave;
    }
}
