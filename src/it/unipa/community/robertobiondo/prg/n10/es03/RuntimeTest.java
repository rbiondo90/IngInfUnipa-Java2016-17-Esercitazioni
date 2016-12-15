/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n10.es03;

import java.io.IOException;

/**
 *
 * @author Roberto Biondo
 */
public class RuntimeTest {

    public static void main(String args[]) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria libera della JVM: " + runtime.freeMemory() + " bytes.");
        String notepad = "notepad";
        String path = (args.length != 0) ? args[0] : "";
        try {
            runtime.exec(notepad + " " + path);
        } catch (IOException exc) {
            System.out.println("Programma " + notepad + "non trovato o file " + path + " non trovato.");
        }
    }
}
