/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es04;

import it.unipa.community.robertobiondo.prg.n12.es03.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Roberto Biondo
 */
public class TestRaggruppatoreDiParole {

    public static void main(String args[]) {
        String testo = "";
        RaggruppatoreDiParole rp;
        Scanner tastiera = new Scanner(System.in);
        String nomeFile = null;
        if (args.length > 0) {
            nomeFile = args[0];
        }
        System.out.println("Programma che legge le parole presenti in un file di testo e le inserisce in una mappa, raggruppandole per lettera iniziale.");
        try {
            if (nomeFile == null) {
                System.out.print("Inserisci il nome di un file di testo: ");
                nomeFile = tastiera.nextLine();
            }
            BufferedReader inFile = new BufferedReader(new FileReader(nomeFile));
            String toAdd;
            do {
                toAdd = inFile.readLine();
                if (toAdd != null) {
                    testo = testo + toAdd + "\n";
                }
            } while (toAdd != null);
            rp = new RaggruppatoreDiParole(testo);
            System.out.println(rp);
        } catch (FileNotFoundException ex) {
            System.out.println("File " + nomeFile + " non trovato. Il programma verrà terminato.");
        } catch (IOException ex) {
            System.out.println("Eccezione: " + ex.getMessage());
        }
    }
}
