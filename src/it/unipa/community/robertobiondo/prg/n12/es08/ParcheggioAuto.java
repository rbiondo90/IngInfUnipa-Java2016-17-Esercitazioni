/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author Roberto Biondo
 */
public class ParcheggioAuto {

    private Deque<Integer> autoNelVialetto;

    public ParcheggioAuto() {
        autoNelVialetto = new LinkedBlockingDeque(10);
    }

    public void aggiungiAuto(Integer targa) throws IllegalArgumentException {
        if (Objects.isNull(targa) || targa < 1) {
            throw new IllegalArgumentException("La stringa targa non può essere negativa o null!!");
        }
        if (this.autoNelVialetto.offerLast(targa)) {
            System.out.println("Vettura targata \"" + targa + "\" parcheggiata nel viale.");
        } else {
            System.out.println("Parcheggio pieno! Impossibile parcheggiare la vettura.");
        }
    }

    public void rimuoviAuto(Integer targa) throws IllegalArgumentException {
        if (Objects.isNull(targa) || targa < 1) {
            throw new IllegalArgumentException("La stringa targa non può essere negativa o nulla!");
        }
        if (!this.autoNelVialetto.contains(targa)) {
            System.out.println("La vettura targata \"" + targa + "\" non è presente nel parcheggio.");
        } else {
            System.out.println("Preparazione all'uscita della vettura \"" + targa + "\" dal parcheggio.");
            Deque<Integer> autoInStrada = new LinkedBlockingDeque(10);
            while (!autoNelVialetto.getLast().equals(targa)) {
                Integer autoTmp = autoNelVialetto.pollLast();
                System.out.println(("Vettura +\"" + autoTmp + "\" temporaneamente spostata in strada.").replace("+", ""));
                autoInStrada.offerFirst(autoTmp);
            }
            System.out.println("La vettura \"" + autoNelVialetto.pollLast() + "\" ha lasciato il parcheggio.\nRiposizionamento delle vetture temporaneamente spostate.");
            while (!autoInStrada.isEmpty()) {
                this.aggiungiAuto(autoInStrada.pollLast());
            }
        }
    }

    public void stampaStato() {
        Iterator<Integer> iteratore = this.autoNelVialetto.iterator();
        System.out.println("Auto nel vialetto: ");
        while (iteratore.hasNext()) {
            System.out.println(iteratore.next());
        }
    }

    public static void main(String args[]) {
        ParcheggioAuto vialetto = new ParcheggioAuto();
        System.out.println("Programma che simula la gestione di un parcheggio auto in un vialetto tramite una coda LIFO."
                + "\nDigitare esclusivamente numeri interi. Un intero positivo aggiungerà una vettura con targa corrispondente all'intero digitato al parcheggio del viale,"
                + "\nlo stesso numero intero preceduto dal segno meno rimuoverà la vettura dal parcheggio, se presente, e 0 terminerà il programma.");
        int scelta = 0;
        do {
            scelta = acquisisciScelta();
            if (scelta > 0) {
                vialetto.aggiungiAuto(scelta);
                vialetto.stampaStato();
            } else if (scelta < 0) {
                vialetto.rimuoviAuto(Math.abs(scelta));
                vialetto.stampaStato();
            }
        } while (scelta != 0);
    }

    public static int acquisisciScelta() {
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        boolean acquisita = false;
        int scelta = 0;
        do {
            try {
                String s = tastiera.readLine();
                scelta = Integer.parseInt(s);
                acquisita = true;
            } catch (NumberFormatException ex) {
                System.out.print("Valore non valido! Digitare esclusivamente numeri interi: ");
            } catch (IOException ex) {
                System.out.println("Eccezione! " + ex.getMessage());
            }
        } while (!acquisita);
        return scelta;
    }
}
