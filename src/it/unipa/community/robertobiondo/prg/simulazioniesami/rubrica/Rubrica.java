/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public class Rubrica {

    private List<Contatto> contatti;
    private int indice = -1;

    public Rubrica() {
        contatti = new ArrayList<>();
    }

    public void aggiungiContatto(Contatto contatto) {
        if (Objects.isNull(contatto)) {
            throw new IllegalArgumentException("Oggetto contatto non inizializzato!");
        }
        contatti.add(contatto);
        indice++;
    }

    public void visualizzaContatto() {
        if (vuota()) {
            throw new IllegalStateException("Rubrica vuota! Impossibile visualizzare un contatto!");
        }
        System.out.println(contatti.get(indice));
    }

    public void modificaContatto() {
        if (vuota()) {
            throw new IllegalStateException("Rubrica vuota! Impossibile modificare un contatto!");
        }
        contatti.get(indice).modifica();
    }

    public Contatto rimuoviContatto() {
        if (vuota()) {
            throw new IllegalStateException("Rubrica vuota! Impossibile rimuovere un contatto!");
        }
        Contatto contatto = contatti.remove(indice);
        return contatto;
    }

    public void spostatiAvanti() {
        if (indice < contatti.size() - 1) {
            indice++;
        } else {
            throw new IllegalStateException("Non vi sono elementi successivi nella rubrica!");
        }
    }

    public void spostatiIndietro() {
        if (indice > 0) {
            indice--;
        } else {
            throw new IllegalStateException("Non vi sono elementi precedenti nella rubrica!");
        }
    }

    public void vaiAllInizio() {
        if (vuota()) {
            throw new IllegalStateException("Rubrica vuota! Impossibile spostarne l'indice!");
        }
        indice = 0;
    }

    public void vaiAllaFine() {
        if (vuota()) {
            throw new IllegalStateException("Rubrica vuota! Impossibile spostarne l'indice!");
        }
        indice = contatti.size() - 1;
    }

    public void stampaRubrica() {
        for (int i = 0; i < contatti.size(); i++) {
            System.out.println("CONTATTO " + i);
            System.out.println(contatti.get(i));
            System.out.println("--------------------------");
        }
    }

    public void azzeraRubrica() {
        contatti.clear();
    }

    public boolean vuota() {
        return contatti.isEmpty();
    }
}
