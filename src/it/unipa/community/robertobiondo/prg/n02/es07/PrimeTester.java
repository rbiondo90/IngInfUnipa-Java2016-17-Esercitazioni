package it.unipa.community.robertobiondo.prg.n02.es07;

public class PrimeTester {

    public boolean isPrime(long z) {
        boolean prime = true;
        //A partire dal 2, verifica il resto della divisione fra z e i
        //il ciclo si ferma quando tutti i numeri più piccoli della metà di z sono stati esaminati, oppure quando viene trovato un divisore
        for (long i = 2; i <= (z / 2) && prime == true; i++) {
            if (z % i == 0) {
                prime = false;
            }
        }
        return prime;
    }
}

/* Versione del professore
Dobbiamo creare un array di booleani posto a vero crivello di eratostene
*/
