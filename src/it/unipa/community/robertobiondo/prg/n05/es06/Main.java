/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es06;

/**
 *
 * @author Bob
 */
public class Main {

    public static void main(String args[]) {
        Bicicletta bicicletta = new Bicicletta();
        Ciclomotore ciclomotore = new Ciclomotore();
        Automobile automobile = new Automobile();
        bicicletta.muovi(5);
        ciclomotore.muovi(5);
        automobile.muovi(5);
    }

}
