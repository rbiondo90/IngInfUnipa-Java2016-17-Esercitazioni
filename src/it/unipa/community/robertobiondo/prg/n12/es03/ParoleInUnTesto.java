/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es03;

import java.util.Collection;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * @author Roberto Biondo
 */
public class ParoleInUnTesto {

    private final Collection<String> parole = new TreeSet<>();
    private final CharSequence testo;

    public ParoleInUnTesto(CharSequence testo) {
        if (Objects.isNull(testo)) {
            throw new IllegalArgumentException("Il testo da analizzare non può essere null!");
        }
        this.testo = testo;
        StringTokenizer st = new StringTokenizer(testo.toString(), " ,)([]{}//.;:-_+*^'!?|\"\\£$%&/=\n\t");
        while (st.hasMoreTokens()) {
            this.parole.add(st.nextToken());
        }
    }

    @Override
    public String toString() {
        return ("Testo:\n\"" + this.testo + "\"\nParole nel testo:\n" + this.parole.toString() + "\nNumero di parole presenti nel testo: " + parole.size()).replace(",", "\n");
    }
}
