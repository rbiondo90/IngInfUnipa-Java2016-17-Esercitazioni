/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es01;

import it.unipa.community.robertobiondo.prg.utilities.MainUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bob
 */
public class Main {

    public static List<Abbonato> abbonati = new ArrayList<>();
    public static List<AbbonatoPremium> abbonatiPremium = new ArrayList<>();

    public static void main(String args[]) {
        int scelta;
        do {
            Main.printMainMenu();
            scelta = MainUtils.integerFromKeyboard(1, 4);
            switch (scelta) {
                case 1:
                    Main.addSubscriber();
                    break;
                case 2:
                    Main.printSubscribersDetails();
                    System.out.println();
                    Main.printPremiumSubscribersDetails();
                    break;
                case 3:
                    Main.manageBuys();
                    break;
                case 4:
                    break;
            }

        } while (scelta != 4);
    }

    public static void printMainMenu() {
        MainUtils.printMenu("Questo programma simula la gestione dell'elenco abbonati di una videoteca. Scegliere l'operazione da svolgere.", "Aggiungere un abbonato",
                "Visualizzare l'elenco abbonati", "Gestire gli acquisti di un abbonato premium", "Uscire dal programma");
    }

    public static void printNewSubscriberMenu() {
        MainUtils.printMenu("Si vuole aggiungere un semplice abbonato o un abbonato premium?", "Abbonato", "Abbonato premium", "Torna al menu principale");
    }

    public static void printNewPremiumSubscriberMenu() {
        MainUtils.printMenu("Si vuole creare un nuovo abbonato con privilegi premium o promuovere un abbonato esistente?", "Crea da zero", "Promuovi", "Torna al menu principale");
    }

    public static void printManagePremiumSubscriberMenu() {
        MainUtils.printMenu("Scegliere l'operazione da effettuare: ", "Registra spesa effettuata", "Registra acquisti bonus utilizzati", "Torna al menu principale");
    }

    public static void printSubscribersDetails() {
        if (!abbonati.isEmpty()) {
            System.out.print("\n-------------------------------------------------------\n"
                    + "DETTAGLI ABBONATI\n");
            for (int i = 0; i < abbonati.size(); i++) {
                System.out.print("\n" + (i + 1));
                System.out.print("\n" + abbonati.get(i).toString());
                System.out.print("-------------------------------------------------------");
            }
            System.out.print("\n");
        } else {
            System.out.println("Nessun abbonato registrato.");
        }
    }

    public static void printPremiumSubscribersDetails() {
        if (!abbonatiPremium.isEmpty()) {
            System.out.print("\n-------------------------------------------------------\n"
                    + "DETTAGLI ABBONATI PREMIUM");
            for (int i = 0; i < abbonatiPremium.size(); i++) {
                System.out.print("\n" + (i + 1));
                System.out.print("\n" + abbonatiPremium.get(i).toString());
                System.out.print("-------------------------------------------------------");
            }
            System.out.print("\n");
        } else {
            System.out.println("Nessun abbonato premium registrato.");
        }
    }

    public static void printSubscriberList() {
        if (!abbonati.isEmpty()) {
            System.out.print("\n-------------------------------------------------------\n"
                    + "LISTA ABBONATI\n");
            for (int i = 0; i < abbonati.size(); i++) {
                System.out.print("\n" + (i + 1) + " - " + abbonati.get(i).getCognome() + " " + abbonati.get(i).getNome());
            }
            System.out.print("\n\n-------------------------------------------------------\n");
        } else {
            System.out.println("Nessun abbonato registrato.");
        }
    }

    public static void printPremiumSubscriberList() {
        if (!abbonatiPremium.isEmpty()) {
            System.out.print("\n-------------------------------------------------------\n"
                    + "LISTA ABBONATI PREMIUM");
            for (int i = 0; i < abbonatiPremium.size(); i++) {
                System.out.print("\n" + (i + 1) + " - " + abbonatiPremium.get(i).getCognome() + " " + abbonatiPremium.get(i).getNome());
            }
            System.out.print("\n\n-------------------------------------------------------\n");
        } else {
            System.out.println("Nessun abbonato premium registrato.");
        }
    }

    public static void addSubscriber() {
        Main.printNewSubscriberMenu();
        int scelta = MainUtils.integerFromKeyboard(1, 3);
        switch (scelta) {
            case 1:
                abbonati.add(Main.acquireSubscriberFromKeyboard());
                break;
            case 2:
                Main.addPremiumSubscriber();
                break;
            case 3:
                break;
        }
    }

    public static void addPremiumSubscriber() {
        Main.printNewPremiumSubscriberMenu();
        int scelta = MainUtils.integerFromKeyboard(1, 3);
        switch (scelta) {
            case 1:
                abbonatiPremium.add(Main.acquirePremiumSubscriberFromKeyboard());
                break;
            case 2:
                Main.promoteSubscriber();
                break;
            case 3:
                break;
        }
    }

    public static Abbonato acquireSubscriberFromKeyboard() {
        Persona abbonato = MainUtils.personFromKeyboard(18);
        System.out.print("Inserire la percentuale di sconto a cui avrà diritto l'abbonato: ");
        int sconto = MainUtils.integerFromKeyboard(0, 80);
        return new Abbonato(abbonato, (byte) sconto);
    }

    public static AbbonatoPremium acquirePremiumSubscriberFromKeyboard() {
        Abbonato abbonato = Main.acquireSubscriberFromKeyboard();
        return new AbbonatoPremium(abbonato);
    }

    public static void promoteSubscriber() {
        if (!abbonati.isEmpty()) {
            Main.printSubscriberList();
            System.out.print("Digitare il numero dell'abbonato da promuovere a premium, oppure digitare " + (abbonati.size() + 1) + " per annullare: ");
            int scelta = MainUtils.integerFromKeyboard(1, abbonati.size() + 1) - 1;
            if (scelta != abbonati.size()) {
                abbonatiPremium.add(new AbbonatoPremium(abbonati.get(scelta)));
                System.out.println("Abbonato " + abbonati.get(scelta).getCognome() + " " + abbonati.get(scelta).getNome() + " promosso a premium!");
                abbonati.remove(scelta);
            }

        } else {
            System.out.println("Lista abbonati vuota! Impossibile promuovere.");
        }
    }

    public static void manageBuys() {
        if (!abbonatiPremium.isEmpty()) {
            Main.printPremiumSubscriberList();
            System.out.print("Digitare il numero dell'abbonato premium da gestire, oppure digitare " + (abbonatiPremium.size() + 1) + " per annullare: ");
            int scelta = MainUtils.integerFromKeyboard(1, abbonati.size() + 1) - 1;
            if (scelta != abbonatiPremium.size()) {
                Main.printManagePremiumSubscriberMenu();
                int operazione = MainUtils.integerFromKeyboard(1, 3);
                switch (operazione) {
                    case 1:
                        Main.addBuy(abbonatiPremium.get(scelta));
                        break;
                    case 2:
                        Main.useBonusBuy(abbonatiPremium.get(scelta));
                        break;
                    case 3:
                        break;
                }
            }
        } else {
            System.out.println("Lista abbonati premium vuota!");
        }
    }

    public static void addBuy(AbbonatoPremium abbonatoPremium) {
        System.out.print("\nInserire il totale in euro dei nuovi acquisti effettuati dall'abbonato premium " + abbonatoPremium.getCognome() + " " + abbonatoPremium.getNome() + " :");
        int importo = MainUtils.integerFromKeyboard(1, Integer.MAX_VALUE);
        abbonatoPremium.accumulaSpesa(importo);
    }

    public static void useBonusBuy(AbbonatoPremium abbonatoPremium) {
        if (abbonatoPremium.getAcquistiBonus() == 0) {
            System.out.println("L'abbonato " + abbonatoPremium.getCognome() + " " + abbonatoPremium.getNome() + " non dispone di alcun acquisto bonus");
        }
        else {
            System.out.print("Digitare il numero di acquisti bonus effettuati da registrare (disponibili "+abbonatoPremium.getAcquistiBonus() +"): ");
            int acquisti = MainUtils.integerFromKeyboard(1, abbonatoPremium.getAcquistiBonus());
            abbonatoPremium.effettuaAcquistiBonus(acquisti);
        }
    }

}
