/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.utilities;

import java.util.Random;

/**
 *
 * @author Roberto Biondo
 */
public class Utils {

    public static Random random = new Random();

    public static boolean containsEmptyString(String[] vector) {
        if (vector != null) {
            for (int i = 0; i < vector.length; i++) {
                if (vector[i] != null && vector[i].isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMatrix(int[][] intArray) {
        for (int col = 0; col < intArray.length - 1; col++) {
            if (intArray[col].length != intArray[col + 1].length) {
                return false;
            }
        }
        return true;
    }

    public static int randomIntInRange(int min, int max) {
        if (min < 0) {
            min = 0;
        }
        if (max < 0) {
            max = 0;
        }
        if (max < min) {
            int tmp = min;
            min = max;
            max = min;
        }
        return (min + random.nextInt(max + 1 - min));
    }

    public static int randomInt(int max) {
        return randomIntInRange(0, max);
    }

    public static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s.toUpperCase();
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
