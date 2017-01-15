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
public class Privato extends Contatto {

    private String cellulare;
    private String idSkype;

    public Privato(String nome, String cognome, String email, String cellulare, String idSkype) {
        super(nome, cognome, email);
        setCellulare(cellulare);
        setIdSkype(idSkype);
    }

    public Privato(String nome, String cognome, String email, String cellulare) {
        this(nome, cognome, email, cellulare, "");
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        if (Objects.isNull(cellulare) || cellulare.isEmpty()) {
            throw new IllegalArgumentException("String vuota o non inizializzata!");
        }
        this.cellulare = cellulare;
    }

    public String getIdSkype() {
        return idSkype;
    }

    public void setIdSkype(String idSkype) {
        if (Objects.isNull(idSkype)) {
            this.idSkype = "";
        }
        this.idSkype = idSkype;
    }

    @Override
    public void modifica() {
        super.modifica();
        System.out.print("Inserire il nuovo numero di cellulare: ");
        String cellulare = AcquisitoreInput.acquisisciStringa();
        if (!cellulare.isEmpty()) {
            setCellulare(cellulare);
        }
        System.out.print("Inserire il nuovo id skype: ");
        String idSkype = AcquisitoreInput.acquisisciStringa();
        if (!idSkype.isEmpty()) {
            setIdSkype(idSkype);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + "Cellulare: " + getCellulare() + ((getIdSkype().isEmpty()) ? "" : "\nId Skipe: " + getIdSkype()) + "\n";
    }
}
