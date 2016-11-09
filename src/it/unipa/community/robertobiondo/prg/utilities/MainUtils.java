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
 * Class containing static methods serving as utilities in Main classes
 *
 * @author Roberto Biondo
 */
public class MainUtils {

    /**
     * A simple scanner for acquiring data from keyboard
     */
    public static Scanner keyboard = new Scanner(System.in);

    /**
     * Acquires an integer from keyboard, with value between minimum and
     * maximum. Note that is not necessary to pass first the minimum to the
     * metod, as if minimum results smaller than maximum, they will be switched.
     *
     * @param minimum the minimum integer accepted
     * @param maximum the maximum integer accepted
     * @return the integer inserted by the user
     */
    public static int integerFromKeyboard(int minimum, int maximum) {
        if (maximum < minimum) {
            int tmp = minimum;
            minimum = maximum;
            maximum = tmp;
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

    /**
     * Acquires an integer from keyboard.
     *
     * @return the integer inserted by the user
     */
    public static int integerFromKeyboard() {
        return integerFromKeyboard(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Acquires a double from keyboard, with value between minimum and maximum.
     * Note that is not necessary to pass first the minimum to the metod, as if
     * minimum results smaller than maximum, they will be switched. Values have
     * to be inserted as "integerpart,fractionarypart".
     *
     * @param minimum the minimum double accepted
     * @param maximum the maximum double accepted
     * @return the double inserted by the user
     */
    public static double doubleFromKeyboard(double minimum, double maximum) {
        if (maximum < minimum) {
            double tmp = minimum;
            minimum = maximum;
            maximum = tmp;
        }
        double choice = 0;
        do {
            if (!keyboard.hasNextDouble()) {
                keyboard.nextLine();
                System.out.println("Inserire solo numeri in virgola mobile compresi tra " + minimum + " e " + maximum + ".");
                continue;
            } else {
                choice = keyboard.nextDouble();
                keyboard.nextLine();
                if (choice >= minimum && choice <= maximum) {
                    break;
                } else {
                    System.out.println("Valore non valido! Inserire solo numberi in virgola mobile compresi tra " + minimum + " e " + maximum + ".");
                }
            }

        } while (true);
        return choice;
    }

    /**
     * Acquires a double from keyboard. Values have to be inserted as
     * "integerpart,fractionarypart".
     *
     * @return the double inserted by the user
     */
    public static double doubleFromKeyboard() {
        return MainUtils.doubleFromKeyboard(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    /**
     * Prints a generic menu with the format:
     * <p>
     * Description
     * <p>
     * 1)Choice
     * <p>
     * 2)Choice
     * <p>
     * ...
     * <p>
     * n)Choice n
     *
     * @param description the menu's description that will be printed before it
     * @param choices the menu's choices that will be printed
     */
    public static void printMenu(String description, String... choices) {
        System.out.print("\n" + description + "\n");
        for (int i = 0; i < choices.length; i++) {
            System.out.print("\n" + (i + 1) + ") " + choices[i]);
        }
        System.out.println();
    }

    /**
     * Acquires a String from keyboard
     *
     * @return the acquired String
     */
    public static String stringFromKeyboard() {
        return stringFromKeyboard(1, Integer.MAX_VALUE);
    }

    /**
     * Acquires a String from keyboard, accepting only a fixed set of values
     *
     * @param fixedValues the range of values the user can insert
     * @return the acquired String
     */
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

    /**
     * Acquires a String of fixed number of prints from keyboard
     *
     * @param fixedSize the number of prints allowed
     * @return the acquired String
     */
    public static String stringFromKeyboard(int fixedSize) {
        return stringFromKeyboard(fixedSize, fixedSize);
    }

    /**
     * Acquires from keyboard a String with number of prints between a fixed
     * range
     *
     * @param minLength the minimum number of prints of the String
     * @param maxLength the maximum number of prints
     * @return the acquired String
     */
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

    /**
     * Acquires from keyboard a Date between the range of minDate and maxDate.
     * <p>
     * If minDate is antecedend maxDate, the two will be switched. The user must
     * input the Date in the format "DD/MM/YYYY".
     * <p>
     *
     * @param minDate the minimum Date accepted
     * @param maxDate the maximum Date accepted
     * @return the Date inserted from keyboard
     */
    public static Date dateFromKeyboard(Date minDate, Date maxDate) {
        if (minDate != null && maxDate != null) {
            if (minDate.anniPassati(maxDate) < 0) {
                Date tmp = minDate.clone();
                minDate = maxDate.clone();
                maxDate = tmp.clone();
            }
        }
        Date data = new Date();
        String dataString;
        boolean correct = true;
        do {
            if (!correct) {
                System.out.println("Errore! Inserire una data" + ((minDate != null) ? (" successiva al " + minDate) : "")
                        + ((minDate != null && maxDate != null) ? " e" : "") + ((maxDate != null) ? (" precedente il " + maxDate) : "") + ".");
            }
            data = MainUtils.dateFromKeyboard();
            if (minDate != null) {
                if (maxDate != null) {
                    correct = data.giorniPassati(minDate) <= 0 && data.giorniPassati(maxDate) >= 0;
                } else {
                    correct = data.giorniPassati(minDate) <= 0;
                }
            } else if (maxDate != null) {
                correct = data.giorniPassati(maxDate) >= 0;
            }
        } while (!correct);
        return data;
    }

    /**
     * Acquires from keyboard a Date not antecedent minDate
     * <p>
     * The user must input the Date in the format "DD/MM/YYYY".
     *
     * @param minDate the minimum Date accepted
     * @return the Date digited by the user
     */
    public static Date dateFromKeyboard(Date minDate) {
        return dateFromKeyboard(minDate, null);
    }

    /**
     * Acquires from keyboard a Date at least etaMinima years antecedent current
     * date.
     * <p>
     * The user must input the Date in the format "DD/MM/YYYY".
     *
     * @param etaMinima the minimum year interval accepted from the date given
     * by the user and the current date
     * @return the date digited by the user
     */
    public static Date dateFromKeyboard(int etaMinima) {
        return dateFromKeyboard(null, Date.ottieniDataCorrente().aggiungiAnni(-etaMinima));
    }

    /**
     * Acquires a Date from keyboard.
     * <p>
     * The user must input the Date in the format "DD/MM/YYYY".
     *
     * @return the date digited
     */
    public static Date dateFromKeyboard() {
        Date data = new Date();
        boolean correct = false;
        String dataString;
        do {
            dataString = keyboard.next();
            if (dataString.split("/").length != 3) {
                keyboard.nextLine();
                System.out.println("Valore non valido! Inserire una data nel formato GG/MM/AAAA");
            } else {
                data = new Date(dataString);
                keyboard.nextLine();
                correct = data.getValidita();
            }
        } while (!correct);
        return data;
    }

    /**
     * Acquires from keyboard all the necessary data to build an Object of the
     * class Persona (representing a Person's data).
     * <p>
     * The user will be prompted to insert:
     * <p>
     * Name - a String.<p>
     * Surname - a String.<p>
     * Birth Date - a Date distant from current date for not lesser of etaMinima
     * in the format "DD/MM/YYYY"
     * <p>
     * Codice Fiscale - a String of 16 prints.<p>
     * Address - a String.<p>
     * City - a String.<p>
     * Address code -a String of 5 prints.<p>
     *
     * @param etaMinima the minimum age of the person generated
     * @return an Object of the class Persona with the data digited by the user
     */
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

    /**
     * Acquires from keyboard all the necessary data to build an Object of the
     * class Persona (representing a Person's data).
     * <p>
     * The user will be prompted to insert:
     * <p>
     * Name - a String.<p>
     * Surname - a String.<p>
     * Birth Date - a Date in the format "GG/DD/YYYY"
     * .<p>
     * Codice Fiscale - a String of 16 prints.<p>
     * Address - a String.<p>
     * City - a String.<p>
     * Address code -a String of 5 prints.<p>
     * @return an Object of the class Persona with the data digited by the user
     */
    public static Persona personFromKeyboard() {
        return personFromKeyboard(0);
    }

    /**
     * Generates a String from a List.
     * <p>
     * Format: <element 1>,<element 2>,...,<element n>
     *
     * @param list the list to be read on
     * @return the String containing the list elements
     */
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
