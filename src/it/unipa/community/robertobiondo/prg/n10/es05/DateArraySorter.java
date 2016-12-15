/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n10.es05;

import it.unipa.community.robertobiondo.prg.n09.es09.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Roberto Biondo
 */
public class DateArraySorter {

    public static void dateArraySorter1(Date[] dates) {
        Arrays.sort(dates);
    }

    public static void printDateArray(Date[] dates) {
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }
    }

    public static void dateArraySorter(Date[] date) {
        boolean sorted = true;
        int endingIndex = date.length - 1;
        do {
            sorted = true;
            for (int i = 0; i < endingIndex; i++) {
                if (date[i].compareTo(date[i + 1]) > 0) {
                    Date tmp = date[i];
                    date[i] = date[i + 1];
                    date[i + 1] = tmp;
                    sorted = false;
                }
            }
            endingIndex--;
        } while (!sorted);
    }

    public static void main(String args[]) {
        Date[] dates = new Date[5];
        dates[0] = new Date();
        dates[1] = dates[0].aggiungiAnni(15);
        dates[2] = dates[0].aggiungiAnni(-4);
        dates[3] = dates[0].aggiungiGiorni(30);
        dates[4] = dates[0].aggiungiGiorni(-15);
        Date[] dates2 = dates.clone();
        List<Date> dates3 = Arrays.asList(dates);
        printDateArray(dates);
        System.out.println("--------");
        dateArraySorter(dates);
        printDateArray(dates);
        System.out.println("--------");

        printDateArray(dates2);
        System.out.println("--------");
        dateArraySorter1(dates2);
        printDateArray(dates2);
        System.out.println("--------");

        System.out.println(dates3);
        System.out.println("--------");
        Collections.sort(dates3);
        System.out.println(dates3);
        System.out.println("--------");

    }
}
