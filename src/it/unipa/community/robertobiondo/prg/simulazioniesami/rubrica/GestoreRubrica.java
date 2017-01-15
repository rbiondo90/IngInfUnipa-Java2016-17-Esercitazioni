/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.rubrica;

/**
 *
 * @author Roberto Biondo
 */
public class GestoreRubrica {

    private static Rubrica rubrica = new Rubrica();

    public static void main(String args[]) {
        char scelta = 0;
        System.out.println("Programma che simula la gestione di una Rubrica.");
        do {
            stampaMenu();
            scelta = AcquisitoreInput.acquisisciCarattere('a', 'j');
            System.out.println();
            switch (scelta) {
                case 'a':
                    aggiungiContatto(0);
                    break;
                case 'b':
                    aggiungiContatto(1);
                    break;
                case 'c':
                    if (rubrica.vuota()) {
                        System.out.println("Rubrica vuota! Nessun contatto da rimuovere!\n");
                    } else {
                        System.out.println("E' stato rimosso il seguente contatto: " + rubrica.rimuoviContatto() + "\n");
                    }
                    break;
                case 'd':
                    if (rubrica.vuota()) {
                        System.out.println("Rubrica vuota! Nessun contatto da modificare!\n");
                    } else {
                        System.out.println("Si sta per modificare il contatto: ");
                        rubrica.visualizzaContatto();
                        rubrica.modificaContatto();
                    }
                    break;
                case 'e':
                    if (rubrica.vuota()) {
                        System.out.println("Rubrica vuota! Nessun contatto da visualizzare!\n");
                    } else {
                        rubrica.visualizzaContatto();
                    }
                    break;
                case 'f':
                    try {
                        rubrica.spostatiAvanti();
                        System.out.println("Indice della rubrica avanzato di una posizione.");
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        System.out.println();
                    }
                    break;
                case 'g':
                    try {
                        rubrica.spostatiIndietro();
                        System.out.println("Indice della rubrica arretrato di una posizione.");
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        System.out.println();
                    }
                    break;
                case 'h':
                    if (rubrica.vuota()) {
                        System.out.println("Rubrica vuota. Nessun contatto presente");
                    } else {
                        rubrica.stampaRubrica();
                    }
                    System.out.println();
                    break;
                case 'i':
                    rubrica.azzeraRubrica();
                    System.out.println("Rubrica svuotata.\n");
                    break;
            }
        } while (scelta != 'j');
    }

    private static void stampaMenu() {
        System.out.println("Scegliere l'operazione da svolgere: "
                + "\na)Aggiungi contatto privato"
                + "\nb)Aggiungi contatto lavoro"
                + "\nc)Elimina contatto corrente"
                + "\nd)Modifica contatto corrente"
                + "\ne)Visualizza contatto corrente"
                + "\nf)Vai al prossimo"
                + "\ng)Vai al precedente"
                + "\nh)Stampa tutto"
                + "\ni)Cancella tutto"
                + "\nj)Esci");
    }

    private static void aggiungiContatto(int tipo) {
        Contatto contatto;
        System.out.print("Inserisci il nome del contatto: ");
        String nome = AcquisitoreInput.acquisisciStringa(1);
        System.out.print("Inserisci il cognome del contatto: ");
        String cognome = AcquisitoreInput.acquisisciStringa(1);
        System.out.print("Inserisci la email: ");
        String email = AcquisitoreInput.acquisisciStringa(1);
        //se il parametro tipo vale 0, acquisisce un contatto privato, altrimenti un contatto di lavoro
        if (tipo == 0) {
            System.out.print("Inserisci il numero di cellulare del contatto: ");
            String cellulare = AcquisitoreInput.acquisisciStringa(1);
            System.out.print("Inserisci l'id skype del contatto: ");
            String idSkype = AcquisitoreInput.acquisisciStringa();
            contatto = new Privato(nome, cognome, email, cellulare, idSkype);
        } else {
            System.out.print("Inserisci il numero di fax del contatto: ");
            String fax = AcquisitoreInput.acquisisciStringa();
            System.out.print("Inserisci la partita IVA del contatto: ");
            String partitaIVA = AcquisitoreInput.acquisisciStringa(1);
            contatto = new Lavoro(nome, cognome, email, fax, partitaIVA);
        }
        rubrica.aggiungiContatto(contatto);
        System.out.println("\nE' stato aggiunto alla rubrica il seguente contatto: \n" + contatto + "\n");
    }
}
