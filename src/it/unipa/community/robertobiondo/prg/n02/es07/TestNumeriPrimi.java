package it.unipa.community.robertobiondo.prg.n02.es07;

public class TestNumeriPrimi {

    public static void main(String args[]) {
        PrimeTester ptest = new PrimeTester();
        System.out.println(1 + "\n" + 2);
        //Il ciclo salta i numeri pari maggiori di due perchè non possono essere primi
        for (int i = 3; i < 500; i += 2) {
            if (ptest.isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
