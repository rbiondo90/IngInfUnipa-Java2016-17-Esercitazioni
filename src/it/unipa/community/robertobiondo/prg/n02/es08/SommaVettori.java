package it.unipa.community.robertobiondo.prg.n02.es08;

import java.util.Random;

public class SommaVettori {

    public static void main(String args[]) {
        int vett1[] = randVect(3);
        int vett2[] = randVect(3);
        printVect(vett1);
        printVect(vett2);
        int vett3[] = new int[3];
        for (int i = 0; i < vett3.length; i++) {
            vett3[i] = vett1[i] + vett2[i];
        }
        printVect(vett3);

    }

    public static int[] randVect(int dim) {
        Random rand = new Random();
        int vettore[] = new int[dim];
        for (int i = 0; i < dim; i++) {
            vettore[i] = rand.nextInt(100);
        }
        return vettore;
    }

    public static void printVect(int vettore[]) {
        for (int i = 0; i < vettore.length; i++) {
            if (i == 0) {
                System.out.print("\n( " + vettore[0] + " , ");
            } else if (i == vettore.length - 1) {
                System.out.print(vettore[i] + " )");
            } else {
                System.out.print(vettore[i] + " , ");
            }
        }
    }
}
