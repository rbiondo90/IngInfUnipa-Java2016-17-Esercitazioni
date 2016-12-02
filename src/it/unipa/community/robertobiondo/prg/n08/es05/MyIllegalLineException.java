/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unipa.community.robertobiondo.prg.n08.es05;

/**
 *
 * @author Roberto Biondo
 */
public class MyIllegalLineException extends Exception{
    public MyIllegalLineException(){
        super("Not a valid line!");
    }
}
