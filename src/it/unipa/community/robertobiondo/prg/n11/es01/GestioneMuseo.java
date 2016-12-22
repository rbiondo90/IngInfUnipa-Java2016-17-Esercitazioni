package it.unipa.community.robertobiondo.prg.n11.es01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class GestioneMuseo {

    private static BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        System.out.println("Programma che simula la gestione delle opere d'arte di un museo.\n");
        Museo museo = generaMuseo();
        System.out.println();
        int scelta;
        do {
            stampaMenu();
            scelta = acquisisciScelta(5);
            System.out.println();
            switch (scelta) {
                case 1:
                    museo.stampaListaOpere();
                    break;
                case 2:
                    if (museo.aggiungiOpera(generaOpera())) {
                        System.out.println("Opera aggiunta con successo!");
                    } else {
                        System.out.println("Opera gi� presente o non valida!");
                    }
                    break;
                case 3:
                    System.out.print("Inserire il nome dell'opera da rimuovere: ");
                    String nomeOperaDaRimuovere = tastiera.readLine();
                    if (museo.rimuoviOpera(nomeOperaDaRimuovere)) {
                        System.out.println("\"" + nomeOperaDaRimuovere + "\" rimossa con successo.");
                    } else {
                        System.out.println("Opera non presente nel museo.");
                    }
                    break;
                case 4:
                    System.out.println("Inserire il nome dell'opera che si vuole visualizzare: ");
                    String nomeOperaDaVisualizzare = tastiera.readLine();
                    OperaDArte operaDaVisualizzare = museo.ottieniOpera(nomeOperaDaVisualizzare);
                    if (operaDaVisualizzare != null) {
                        System.out.println(operaDaVisualizzare);
                    } else {
                        System.out.println("Opera non presente nel museo!");
                    }
                    break;
            }
        } while (scelta != 5);
    }

    private static Museo generaMuseo() {
        boolean inizializzato = false;
        Museo museo = null;
        do {
            try {
                System.out.print("Inserire il nome del museo: ");
                String nome = acquisisciStringa();
                System.out.print("Inserire l'indirizzo del museo: ");
                String indirizzo = acquisisciStringa();
                museo = new Museo(nome, indirizzo);
                inizializzato = true;
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        } while (!inizializzato);
        return museo;
    }

    private static void stampaMenu() {
        System.out.println("\nScegliere l'operazione da svolgere:\n\n"
                + "1)Visualizzare la lista delle opere presenti\n"
                + "2)Aggiungere un'opera al museo\n"
                + "3)Rimuovere un'opera dal museo\n"
                + "4)Visualizzare i dettagli di un'opera\n"
                + "5)Uscire dal programma\n");
    }

    private static int acquisisciScelta(int max) {
        int scelta = 0;
        boolean acquisita = false;
        do {
            try {
                scelta = Integer.parseInt(acquisisciStringa());
                if (scelta < 1 || scelta > max) {
                    throw new IllegalArgumentException();
                }
                acquisita = true;
            } catch (IllegalArgumentException | InputMismatchException exc) {
                System.out.print("Errore! Inserire un intero compreso tra 1 e 5: ");
            }
        } while (!acquisita);
        return scelta;
    }

    private static OperaDArte generaOpera() {
        System.out.println("Scegliere il tipo di opera che si vuole aggiungere:\n"
                + "1)Scultura\n"
                + "2)Dipinto\n"
                + "3)Torna al menu principale\n");
        OperaDArte opera = null;
        int scelta = acquisisciScelta(3);
        boolean inizializzato = false;
        if (scelta != 3) {
            do {
                try {
                    System.out.print("Inserire il titolo dell'opera: ");
                    String nome = acquisisciStringa();
                    System.out.print("Inserire l'autore dell'opera: ");
                    String autore = acquisisciStringa();
                    System.out.print("Inserire la data di creazione dell'opera: ");
                    String dataDiCreazione = acquisisciStringa();
                    switch (scelta) {
                        case 1:
                            System.out.print("Inserire il materiale di cui � fatta la scultura: ");
                            String materiale = acquisisciStringa();
                            System.out.print("Inserire l'altezza della scultura in centimetri: ");
                            Double altezzaScultura = Double.parseDouble(acquisisciStringa());
                            opera = new Scultura(nome, autore, dataDiCreazione, materiale, altezzaScultura);
                            break;
                        case 2:
                            System.out.print("Inserire la tecnica utilizzata per realizzare il dipinto: ");
                            String tecnica = acquisisciStringa();
                            System.out.print("Inserire l'altezza del dipinto in centimetri: ");
                            Double altezzaDipinto = Double.parseDouble(acquisisciStringa());
                            System.out.print("Inserire la larghezza del dipinto in centimetri: ");
                            Double larghezza = Double.parseDouble(acquisisciStringa());
                            opera = new Dipinto(nome, autore, dataDiCreazione, tecnica, altezzaDipinto, larghezza);
                            break;
                    }
                    inizializzato = true;
                } catch (InputMismatchException | IllegalArgumentException exc) {
                    System.out.println(exc.getMessage());
                }
            } while (!inizializzato);
        }
        System.out.println();
        return opera;
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

}
