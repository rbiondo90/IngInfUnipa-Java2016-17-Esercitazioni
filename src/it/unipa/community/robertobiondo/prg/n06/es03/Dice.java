/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unipa.community.robertobiondo.prg.n06.es03;

/**
 *
 * @author Roberto Biondo
 */
public class Dice extends MultiSidedItem{
    
    public Dice(int sidesNumber,String... sidesNames){
        super(sidesNumber,sidesNames);
    }
    
    public Dice(int sidesNumber){
        super(sidesNumber);
    }
    
    public Dice(){
        this(6);
    }
    
    public Dice(String... sidesNames){
        this(6,sidesNames);
    }

}
