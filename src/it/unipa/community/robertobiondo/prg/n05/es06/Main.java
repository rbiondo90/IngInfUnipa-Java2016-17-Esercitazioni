/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es06;

import robertobiondo.utilities.MainUtils;

/**
 *
 * @author Roberto Biondo
 */
public class Main {

    public static void main(String args[]) {
        Bicicletta bicicletta = new Bicicletta();
        Ciclomotore ciclomotore = new Ciclomotore();
        Automobile automobile = new Automobile();
        int tempo;
        int scelta;
        System.out.print("Programma che simula il movimento di una bicicletta, un ciclomotore di 50 cc e un'automobile di 1000 cc in un intervallo di tempo specificato dall'utente.");
        do {
            Main.printMainMenu();
            scelta = MainUtils.integerFromKeyboard(1, 3);
            switch (scelta) {
                case 1:
                    System.out.print("Inserire l'intervallo di tempo per cui si vogliono far spostare i veicoli: ");
                    tempo = MainUtils.integerFromKeyboard(1, Integer.MAX_VALUE);
                    bicicletta.muovi(tempo);
                    ciclomotore.muovi(tempo);
                    automobile.muovi(tempo);
                    break;
                case 2:
                    bicicletta.gonfiaRuote();
                    ciclomotore.gonfiaRuote();
                    automobile.gonfiaRuote();
                    System.out.println("Ruote gonfiate!");
                    break;
                case 3:
                    break;
            }
        } while (scelta != 3);
    }

    public static void printMainMenu() {
        MainUtils.printMenu("Scegliere se muovere i veicoli o gonfiarne le ruote: ", "Muovi", "Gonfia ruote", "Esci");
    }
}
