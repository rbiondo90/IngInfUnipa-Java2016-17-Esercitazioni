/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.n05;

/**
 *
 * @author Roberto Biondo
 */
public class StackException extends RuntimeException {

    public StackException(String message) {
        super(message);
    }

    public StackException() {
        this("Stack exception!");
    }
}
