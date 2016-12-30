/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Roberto Biondo
 */
public class AnalizzatoreCodiceSorgenteJava {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner tastiera = new Scanner(System.in);
        String nomeFile;
        System.out.print("Inserire il nome del file contenente il codice da analizzare: ");
        nomeFile = tastiera.nextLine();
        if (nomeFile.endsWith(".java")) {
            File fileSorgente = new File(nomeFile);
            if (fileSorgente.exists()) {
                Map<String, Set<Integer>> identificatori = analizzaCodice(fileSorgente);
                stampaMappa(identificatori);
            } else {
                System.out.println("File \"" + nomeFile + "\" non trovato. L'applicazione verrà terminata.");
            }
        } else {
            System.out.println("\"" + nomeFile + "\" non è un file contenente codice sorgente Java! L'applicazione verrà terminata.");
        }
    }

    private static Map<String, Set<Integer>> analizzaCodice(File fileSorgente) throws FileNotFoundException {
        Map<String, Set<Integer>> identificatori = new TreeMap<>();
        Scanner out = new Scanner(fileSorgente);
        int rigaCorrente = 1;
        while (out.hasNext()) {
            Scanner in = new Scanner(out.nextLine());
            in.useDelimiter("[^A-Za-z0-9_]+");
            while (in.hasNext()) {
                String identificatore = in.next();
                identificatori.putIfAbsent(identificatore, new TreeSet<>());
                Set<Integer> identificatoreCorrente = identificatori.get(identificatore);
                identificatoreCorrente.add(rigaCorrente);
            }
            rigaCorrente++;
        }
        return identificatori;
    }

    private static void stampaMappa(Map<String, Set<Integer>> mappa) {
        Iterator<String> iteratore = mappa.keySet().iterator();
        while (iteratore.hasNext()) {
            String identificatoreCorrente = iteratore.next();
            System.out.println(identificatoreCorrente + ": " + mappa.get(identificatoreCorrente));
        }
    }
}
