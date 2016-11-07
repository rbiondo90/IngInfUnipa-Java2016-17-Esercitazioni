package it.unipa.community.robertobiondo.prg.utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import it.unipa.community.robertobiondo.prg.n04.es04.Date;
import it.unipa.community.robertobiondo.prg.n05.es01.Persona;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bob
 */
public class MainUtils {

    public static Scanner keyboard = new Scanner(System.in);

    public static int integerFromKeyboardInRange(int minimum, int maximum) {
        if (maximum < minimum) {
            minimum = Integer.MIN_VALUE;
            maximum = Integer.MAX_VALUE;
        }
        int choice = 0;
        do {
            if (!keyboard.hasNextInt()) {
                keyboard.nextLine();
                System.out.println("Inserire solo interi compresi tra " + minimum + " e " + maximum + ".");
                continue;
            } else {
                choice = keyboard.nextInt();
                keyboard.nextLine();
                if (choice >= minimum && choice <= maximum) {
                    break;
                } else {
                    System.out.println("Valore non valido! Inserire solo interi compresi tra " + minimum + " e " + maximum + ".");
                }
            }

        } while (true);
        return choice;
    }

    public static int integerFromKeyboard() {
        return integerFromKeyboardInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void printMenu(String description, String... choices) {
        System.out.print("\n" + description + "\n");
        for (int i = 0; i < choices.length; i++) {
            System.out.print("\n" + (i + 1) + ") " + choices[i]);
        }
        System.out.println();
    }

    public static String stringFromKeyboard() {
        return stringFromKeyboard(1, Integer.MAX_VALUE);
    }

    public static String stringFromKeyboard(List<String> fixedValues) {
        String s;
        do {
            s = stringFromKeyboard();
            if (fixedValues.contains(s.toLowerCase())) {
                break;
            } else {
                System.out.println("Stringa inserita non valida. Valori consentiti: " + listToString(fixedValues));
            }
        } while (true);
        return s;
    }

    public static String stringFromKeyboard(int fixedSize) {
        return stringFromKeyboard(fixedSize, fixedSize);
    }

    public static String stringFromKeyboard(int minLength, int maxLength) {
        if (minLength > maxLength) {
            minLength = 0;
            maxLength = Integer.MAX_VALUE;
        }
        if (minLength < 0) {
            minLength = 0;
        }
        if (maxLength < 0) {
            maxLength = Integer.MAX_VALUE;
        }
        String s;
        do {
            s = keyboard.nextLine();
            if (s.length() >= minLength && s.length() <= maxLength) {
                break;
            } else {
                System.out.println("Errore! La lunghezza della stringa deve essere "
                        + ((minLength != maxLength) ? ("compresa fra " + minLength + " e " + maxLength) : ("uguale a " + minLength)) + ".");
            }
        } while (true);
        return s;
    }

    public static Date dateFromKeyboard(int minAge) {
        Date data = new Date();
        String dataString;
        do {
            dataString = keyboard.next();
            if (dataString.split("/").length != 3) {
                keyboard.nextLine();
                System.out.println("Valore non valido! Inserire una data nel formato GG/MM/AAAA");
            } else {
                data = new Date(dataString);
                keyboard.nextLine();
                if (data.anniDiDifferenza(Date.ottieniDataCorrente()) < minAge || !data.getValidita()) {
                    System.out.println("Errore! anni minori di " + minAge + " o valori inseriti non corretti.");
                } else {
                    break;
                }
            }
        } while (true);
        return data;
    }

    public static Date dateFromKeyboard() {
        return dateFromKeyboard(0);
    }

    public static Persona personFromKeyboard(int etaMinima) {
        if (etaMinima < 0) {
            etaMinima = 0;
        }
        System.out.println("Inserire i dati della persona.");
        System.out.print("\nNome: ");
        String nome = MainUtils.stringFromKeyboard();
        System.out.print("Cognome: ");
        String cognome = MainUtils.stringFromKeyboard();
        System.out.print("Data di nascita " + ((etaMinima != 0) ? "(almeno " + etaMinima + " anni, formato GG/MM/AAAA)" : "") + ":");
        Date dataDinascita = MainUtils.dateFromKeyboard(etaMinima);
        System.out.print("Codice fiscale (16 lettere): ");
        String codiceFiscale = MainUtils.stringFromKeyboard(16);
        System.out.print("Indirizzo: ");
        String indirizzo = MainUtils.stringFromKeyboard();
        System.out.print("Città: ");
        String citta = MainUtils.stringFromKeyboard();
        System.out.print("Cap: ");
        String cap = MainUtils.stringFromKeyboard(5);
        return new Persona(dataDinascita, nome, cognome, codiceFiscale, indirizzo, citta, cap);
    }

    public static Persona personFromKeyboard() {
        return personFromKeyboard(0);
    }

    public static String listToString(List list) {
        StringBuilder s = new StringBuilder();
        s.append("( ");
        for (int i = 0; i < list.size(); i++) {
            s.append("<").append(list.get(i)).append(">");
            if (i != list.size() - 1) {
                s.append(", ");
            }
        }
        s.append(" )");
        return s.toString();
    }
}
