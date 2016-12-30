/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Roberto Biondo
 */
public class TestCrivelloDiEratostene {

    public static void main(String args[]) {
        System.out.println("Programma che calcola e visualizza i numeri primi da 2 a n, tramite l'algoritmo del Crivello di Eratostene.");
        long n = 0;
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        CrivelloDiEratostene numeriPrimi = null;
        do {
            try {
                System.out.print("Inserire il numero fino al quale si vogliono calcolare i primi: ");
                n = Long.parseLong(tastiera.readLine());
                numeriPrimi = new CrivelloDiEratostene(n);

            } catch (IOException ex) {
                System.out.println("Eccezione: " + ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println("L'algoritmo richiede esclusivamente interi maggiori o uguali a 2!");
            }
        } while (n < 2);
        try {
            tastiera.close();
        } catch (IOException ex) {
            System.out.println("Impossibile chiudere il BufferedReader tastiera.\n" + ex.getMessage());
        }
        System.out.println("Numeri primi individuati: " + "\n" + numeriPrimi);
    }
}
