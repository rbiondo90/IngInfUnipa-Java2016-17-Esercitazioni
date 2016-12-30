/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es01;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Roberto Biondo
 */
public class CrivelloDiEratostene {

    private final Collection<Long> NUMERI_PRIMI;

    public CrivelloDiEratostene(long n) {
        if (n < 2) {
            throw new IllegalArgumentException("L'algoritmo richiede un numero intero maggiore o uguale a 2!");
        }
        this.NUMERI_PRIMI = new TreeSet<>();
        for (long i = 2L; i <= n; i++) {
            NUMERI_PRIMI.add(i);
        }
        long soglia = (long) Math.sqrt(n);
        for (long i = 2L; i <= soglia; i++) {
            long j = 2L;
            while (i * j <= n) {
                NUMERI_PRIMI.remove(i * j);
                j++;
            }
        }
    }

    public Collection<Long> getNumeriPrimi() {
        return this.NUMERI_PRIMI;
    }

    @Override
    public String toString() {
        Iterator<Long> iteratore = NUMERI_PRIMI.iterator();
        StringBuilder s = new StringBuilder();
        long counter = 1;
        s.append("[");
        while (iteratore.hasNext()) {
            if (counter % 15 == 0) {
                s.append("\n");
            }
            s.append(iteratore.next());
            if (iteratore.hasNext()) {
                s.append(", ");
            } else {
                s.append("]");
            }
            counter++;
        }
        return s.toString();
    }
}
