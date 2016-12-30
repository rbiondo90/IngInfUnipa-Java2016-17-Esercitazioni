/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es04;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Roberto Biondo
 */
public class RaggruppatoreDiParole {

    private Map<Character, Collection<String>> insiemiDiParole;
    private CharSequence testo;

    public RaggruppatoreDiParole(CharSequence testo) {
        if (Objects.isNull(testo)) {
            throw new IllegalArgumentException("Il testo da analizzare non può essere null!");
        }
        this.testo = testo;
        this.insiemiDiParole = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(testo.toString(), " ,)([]{}//.;:-_+*^'!?|\"\\£$%&/=\n\t");
        while (st.hasMoreTokens()) {
            this.aggiungiParola(st.nextToken());
        }
    }

    private void aggiungiParola(String parola) {
        Character letteraIniziale = parola.toUpperCase().charAt(0);
        this.insiemiDiParole.putIfAbsent(letteraIniziale, new TreeSet<>());
        Collection<String> insiemeLetteraCorrente = this.insiemiDiParole.get(letteraIniziale);
        insiemeLetteraCorrente.add(parola.toLowerCase());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<Character> iteratoreLettere = this.insiemiDiParole.keySet().iterator();
        while (iteratoreLettere.hasNext()) {
            Character letteraCorrente = iteratoreLettere.next();
            s.append("\n-------------------------------------------\n");
            s.append("Parole con la lettera " + letteraCorrente + ":\n");
            s.append(this.insiemiDiParole.get(letteraCorrente));
        }
        s.append("\n-------------------------------------------\n");
        return s.toString();
    }
}
