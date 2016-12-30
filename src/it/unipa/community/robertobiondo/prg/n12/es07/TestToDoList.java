/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es07;

import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class TestToDoList {

    public static void main(String args[]) {
        System.out.println("Programma che simula la gestione di una to do list.");
        System.out.println("Digitare \"add \"descrizione\" priorità\" per aggiungere una attività alla to do list, \"next\" per visualizzare la cosa da fare con massima priorità,"
                + "\"quit\" per uscire dal programma.");
        String sceltaUtente = "";
        Scanner tastiera = new Scanner(System.in);
        ToDoList lista = new ToDoList();
        do {
            sceltaUtente = tastiera.nextLine().trim();
            if (sceltaUtente.startsWith("add")) {
                aggiungiTask(lista, sceltaUtente);
            } else if (sceltaUtente.equals("next")) {
                ottieniTask(lista);
            } else if (sceltaUtente.equals("quit")) {
                break;
            } else {
                System.out.println("Scelta non valida! Digitare \"add \"descrizione\" priorità\" per aggiungere una attività alla to do list, \"next\" per visualizzare la cosa da fare con massima priorità,"
                        + "\"quit\" per uscire dal programma.");
            }

        } while (!sceltaUtente.equals("quit"));
    }

    public static void aggiungiTask(ToDoList lista, String testo) {
        String[] comandi = testo.split("\"");
        boolean errore = false;
        if (comandi.length != 3) {
            errore = true;
        } else {
            try {
                lista.add(comandi[1].trim(), Integer.parseInt(comandi[2].trim()));
            } catch (IllegalArgumentException ex) {
                errore = true;
            }
        }
        if (errore) {
            System.out.println("Stringa non corretta! Inserire \"add\" seguito dalla descrizione dell'attività circondata da \"\", seguito da una priorità da 1 a 9.");
        } else {
            System.out.println("Aggiunta l'attività " + comandi[1] + " con priorità " + comandi[2] + ".");
        }
    }

    public static void ottieniTask(ToDoList lista) {
        System.out.println("Prossima attività: " + lista.next());
    }

}
