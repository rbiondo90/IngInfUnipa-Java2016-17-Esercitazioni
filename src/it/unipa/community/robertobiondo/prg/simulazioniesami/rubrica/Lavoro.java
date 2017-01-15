/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.rubrica;

import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public class Lavoro extends Contatto {

    private String fax;
    private String partitaIVA;

    public Lavoro(String nome, String cognome, String email, String fax, String partitaIVA) {
        super(nome, cognome, email);
        setFax(fax);
        setPartitaIVA(partitaIVA);
    }

    public Lavoro(String nome, String cognome, String email, String partitaIVA) {
        this(nome, cognome, email, "", partitaIVA);
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        if (Objects.isNull(fax)) {
            this.fax = "";
        }
        this.fax = fax;
    }

    public String getPartitaIVA() {
        return partitaIVA;
    }

    public void setPartitaIVA(String partitaIVA) {
        if (Objects.isNull(partitaIVA) || partitaIVA.isEmpty()) {
            throw new IllegalArgumentException("String vuota o non inizializzata!");
        }
        this.partitaIVA = partitaIVA;
    }

    @Override
    public void modifica() {
        super.modifica();
        System.out.print("Inserire il nuovo numero di fax: ");
        String fax = AcquisitoreInput.acquisisciStringa();
        if (!fax.isEmpty()) {
            setFax(fax);
        }
        System.out.print("Inserire la nuova partita IVA: ");
        String partitaIVA = AcquisitoreInput.acquisisciStringa();
        if (!partitaIVA.isEmpty()) {
            setPartitaIVA(partitaIVA);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + ((getFax().isEmpty()) ? "" : "Fax: " + getFax()) + "\nPartita IVA: " + getPartitaIVA() + "\n";
    }
}
