/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unipa.community.robertobiondo.prg.n08.es01;


/**
 *
 * @author Roberto Biondo
 */
public abstract class Numero {
    
    public abstract Numero somma(Numero x);
    public abstract Numero sottrai(Numero x);
    public abstract Numero moltiplica(Numero x);
    public abstract Numero dividi(Numero x);
    public abstract void stampa();

}
