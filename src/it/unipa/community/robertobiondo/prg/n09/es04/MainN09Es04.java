/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.es04;

import it.unipa.community.robertobiondo.prg.n08.es02.Circle;
import it.unipa.community.robertobiondo.prg.n08.es02.Rectangle;
import it.unipa.community.robertobiondo.prg.n08.es02.Shape;
import it.unipa.community.robertobiondo.prg.n08.es02.Square;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Bob
 */
public class MainN09Es04 {

    public static void main(String args[]) {
        ArrayList<Shape> listaForme = new ArrayList<>();
        listaForme.add(new Square(2));
        listaForme.add(new Circle(1));
        listaForme.add(new Rectangle(2,3));
        printShapeList(listaForme);
        /*CODICE CHE NON COMPILA
        printShapeList(new ArrayList<String>();
        */
    }

    public static void printShapeList(ArrayList<? extends Shape> shapeList) {
        Iterator<? extends Shape> iterator = shapeList.iterator();
        while (iterator.hasNext()) {
            iterator.next().draw();
        }
    }
}
