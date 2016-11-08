package it.unipa.community.robertobiondo.prg.n02.es10;

public class TestMatematica {

    public static void main(String args[]) {
        Matematica calcolatrice = new Matematica();
        int[] vettore1 = calcolatrice.generaVettore(3);
        int[] vettore2 = calcolatrice.generaVettore(3);
        int[] vettore3 = calcolatrice.generaVettore(5);
        calcolatrice.stampaVettore(vettore1);
        calcolatrice.stampaVettore(vettore2);
        calcolatrice.stampaVettore(vettore3);
        calcolatrice.stampaVettore(calcolatrice.sommaVettori(vettore1, vettore2));
        calcolatrice.stampaVettore(calcolatrice.sommaVettori(vettore1, vettore3));
        int[][] matrice1 = calcolatrice.generaMatrice(3, 5);
        int[][] matrice2 = calcolatrice.generaMatrice(3, 5);
        int[][] matrice3 = calcolatrice.generaMatrice(5, 3);
        calcolatrice.stampaMatrice(matrice1);
        calcolatrice.stampaMatrice(matrice2);
        calcolatrice.stampaMatrice(matrice3);
        calcolatrice.stampaMatrice(calcolatrice.sommaMatrici(matrice1, matrice2));
        calcolatrice.stampaMatrice(calcolatrice.sommaMatrici(matrice1, matrice3));
    }
}
