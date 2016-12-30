/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Roberto Biondo
 */
public class InvertitoreFrase {

    private String frase;
    private String fraseInvertita;

    public InvertitoreFrase(CharSequence testo) {
        if (Objects.isNull(testo)) {
            throw new IllegalArgumentException("Il testo da analizzare non può essere null!");
        }
        this.impostaEInvertiFrase(testo);
    }

    private void impostaEInvertiFrase(CharSequence testo) {
        Deque<String> parole = new ArrayDeque<>();
        StringTokenizer tokenTesto = new StringTokenizer(testo.toString(), " ");
        boolean trovatoPunto = false;
        while (tokenTesto.hasMoreTokens() && trovatoPunto == false) {
            String token = tokenTesto.nextToken();
            if (token.contains(".")) {
                parole.offerLast(token.replace(".", ""));
                trovatoPunto = true;
            } else {
                parole.offerLast(token);
            }
        }
        StringBuilder frase = new StringBuilder();
        Iterator<String> iteratoreNormale = parole.iterator();
        while (iteratoreNormale.hasNext()) {
            frase.append(iteratoreNormale.next()).append(" ");
        }
        frase.setCharAt(frase.length()-1,'.');
        this.frase = frase.toString();
        StringBuilder fraseInvertita = new StringBuilder();
        Iterator<String> iteratoreInvertito = parole.descendingIterator();
        while (iteratoreInvertito.hasNext()) {
            fraseInvertita.append(iteratoreInvertito.next()).append(" ");
        }
        fraseInvertita.setCharAt(fraseInvertita.length() -1, '.');
        this.fraseInvertita = fraseInvertita.toString();
    }

    public String getFrase() {
        return this.frase;
    }

    public String getFraseInvertita() {
        return this.fraseInvertita;
    }

    public static void main(String args[]) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Programma che inverte e visualizza una frase.");
        System.out.print("Inserire la frase da invertire: ");
        String testo = tastiera.nextLine();
        InvertitoreFrase inv = new InvertitoreFrase(testo);
        System.out.println(inv.getFrase() + "\n" + inv.getFraseInvertita());
    }

}
