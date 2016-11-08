package it.unipa.community.robertobiondo.prg.n02.es09;

import java.util.Random;

public class SommaMatrici {

    public static void main(String args[]) {
        int mat1[][] = randMat(3, 5);
        int mat2[][] = randMat(3, 5);
        printMat(mat1);
        printMat(mat2);
        int mat3[][] = emptyMat(3, 5);
        for (int i = 0; i < mat3.length; i++) {
            for (int j = 0; j < mat3[i].length; j++) {
                mat3[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        printMat(mat3);
    }

    public static int[][] randMat(int rows, int cols) {
        Random rand = new Random();
        int matrix[][] = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }
        return matrix;
    }

    public static void printMat(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                System.out.print("\n[ ");
            } else {
                System.out.print("\n  ");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != (matrix[i].length - 1)) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print("]\n");
    }

    public static int[][] emptyMat(int rows, int cols) {
        Random rand = new Random();
        int matrix[][] = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}
