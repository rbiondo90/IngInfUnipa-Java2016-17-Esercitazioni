/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es02;

import it.unipa.community.robertobiondo.prg.utilities.MainUtils;
import it.unipa.community.robertobiondo.prg.n04.es04.Date;
import it.unipa.community.robertobiondo.prg.n05.es01.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bob
 */
public class Main {

    public static void main(String args[]) {
        List<Persona> persone = new ArrayList<Persona>();
        Scanner keyboard = new Scanner(System.in);
        int scelta;
        do {
            Main.printMainMenu();
            scelta = MainUtils.integerFromKeyboard(1, 3);
            switch (scelta) {
                case 1:
                    Main.recordCreation(persone);
                    break;
                case 2:
                    Main.printAllRecords(persone);
                    break;
            }
        } while (scelta != 3);
    }

    public static void printMainMenu() {
        MainUtils.printMenu("Questo programme crea e visualizza degli oggetti della classe Persona e delle sue sottoclassi.", "Crea un nuovo record",
                "Visualizza record esistenti", "Esci dal programma");
    }

    public static void printCreationMenu() {
        MainUtils.printMenu("Si vuole registrare un professore o uno studente?", "Nuovo professore", "Nuovo studente", "Torna al menu principale");
    }

    public static void printStudentCreationMenu() {
        MainUtils.printMenu("Si tratta di uno studente triennale o magistrale?", "Studente triennale", "Studente magistrale", "Torna al menu di creazione");
    }

    public static void recordCreation(List<Persona> persone) {
        int scelta;
        Persona persona = MainUtils.personFromKeyboard(18);
        Main.printCreationMenu();
        scelta = MainUtils.integerFromKeyboard(1, 3);
        switch (scelta) {
            case 1:
                Professore professore = Main.professorFromKeyboard(persona);
                persone.add(professore);
                break;
            case 2:
                Main.studentCreation(persone, persona);
                break;
            case 3:
                break;
        }
    }

    public static void studentCreation(List<Persona> persone, Persona persona) {
        int scelta;
        Main.printStudentCreationMenu();
        scelta = MainUtils.integerFromKeyboard(1, 3);
        switch (scelta) {
            case 1:
                Studente studente = studentFromKeyboard(persona);
                System.out.print("Scuola superiore di provenienza: ");
                String scuolaDiProvenienza = MainUtils.stringFromKeyboard();
                persone.add(new StudenteTriennale(studente, scuolaDiProvenienza));
                break;
            case 2:
                studente = studentFromKeyboard(persona);
                System.out.print("Laurea trienneale di provenienza: ");
                String laureaDiProvenienza = MainUtils.stringFromKeyboard();
                persone.add(new StudenteMagistrale(studente, laureaDiProvenienza));
                break;
            case 3:
                break;
        }
    }

    public static void printAllRecords(List<Persona> record) {
        for (int i = 0; i < record.size(); i++) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nRECORD NUMERO " + (i + 1));
            record.get(i).stampaDati();
            System.out.println("\n-----------------------------------------------------------------");
        }
    }

    public static Professore professorFromKeyboard(Persona persona) {
        System.out.println("Inserire i dati del professor " + persona.getCognome() + " " + persona.getNome() + ": ");
        System.out.print("\nData di assunzione: ");
        Date dataDiAssunzione = MainUtils.dateFromKeyboard(25);
        System.out.print("Ruolo: ");
        String ruolo = MainUtils.stringFromKeyboard(Arrays.asList("professore associato", "professore ordinario", "ricercatore", "pa", "po", "r"));
        System.out.print("Dipartimento: ");
        String dipartimento = MainUtils.stringFromKeyboard();
        System.out.print("Salario: ");
        int salario = MainUtils.integerFromKeyboard(0, Integer.MAX_VALUE);
        return new Professore(persona, dataDiAssunzione, ruolo, dipartimento, salario);
    }

    public static Studente studentFromKeyboard(Persona persona) {
        System.out.println("Inserire i dati dello studente " + persona.getCognome() + " " + persona.getNome() + ": ");
        System.out.print("\nData di  iscrizione: ");
        Date dataIscrizione = MainUtils.dateFromKeyboard(persona.getDataDiNascita().aggiungiAnni(18));
        System.out.print("Corso di laurea: ");
        String corsoDiLaurea = MainUtils.stringFromKeyboard();
        System.out.print("Numero di matricola: ");
        int matricola = MainUtils.integerFromKeyboard(0, 99999);
        return new Studente(persona, dataIscrizione, matricola, corsoDiLaurea);
    }

}
