/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es06;

/**
 *
 * @author Roberto Biondo
 */
public class MyIllegalPlaneException extends Exception {

    public MyIllegalPlaneException() {
        super("Not a valid plane!");
    }

    public MyIllegalPlaneException(String message) {
        super(message);
    }
}
