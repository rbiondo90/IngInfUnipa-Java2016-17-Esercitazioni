/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es04;

/**
 *
 * @author Roberto Biondo
 */
public class MyIllegalDateException extends Exception {

    public MyIllegalDateException(String message) {
        super(message);
    }

    public MyIllegalDateException() {
        this("Data non valida!");
    }

    @Override
    public String toString() {
        return ("MyIllegalDateException: " + this.getMessage());
    }
}
