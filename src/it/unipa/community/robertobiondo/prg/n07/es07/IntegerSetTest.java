/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n07.es07;

/**
 *
 * @author Roberto Biondo
 */
public class IntegerSetTest {

    public static void main(String args[]) {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.print();
        set2.print();
        try {
            set1.insertElements(102, 323, 23);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
        set1.print();
        try {
            set1.insertElements(1, 2, 4, 87, 99, 65);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            set2.insertElements(0, 4, 99, 11, 23, 2);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
        set1.print();
        set2.print();
        set1.unionOfIntegerSet(set2).print();
        set1.intersectionOfIntegerSet(set2).print();
        IntegerSet set3 = new IntegerSet(200);
        set3.insertElements(2,150,12,10,34,123);
        set3.print();
        set3.intersectionOfIntegerSets(set1,set2).print();
        set3.unionOfIntegerSets(set1,set2).print();
    }
}
