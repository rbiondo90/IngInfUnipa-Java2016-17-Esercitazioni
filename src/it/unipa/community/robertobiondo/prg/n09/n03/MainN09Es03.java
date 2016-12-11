/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.n03;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Bob
 */
public class MainN09Es03 {

    public static void main(String args[]) {
        ArrayList lista = new ArrayList();
        lista.add(new Object());
        lista.add("Ciao!");
        ArrayList<Integer> listaInteri = new ArrayList<>();
        listaInteri.add(1);
        listaInteri.add(2);
        printArrayList(lista);
        printArrayList(listaInteri);
    }
    
    public static void printArrayList(ArrayList arrayList){
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
