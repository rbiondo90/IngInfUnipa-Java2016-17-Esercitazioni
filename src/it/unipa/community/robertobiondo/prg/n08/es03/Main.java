/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es03;

import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;

/**
 *
 * @author Roberto Biondo
 */
public class Main {

    public static void main(String args[]) {
        Image image = new Image(6, 6);
        image.print();
        ROI roi = new ROI(new Point2D(4, 4), new Point2D(6, 6));
        image.getROIImage(roi).print();
        try {
            image = new Image(10, 10);
        }
        catch(NegativeArraySizeException exc){
            System.out.println("Dimensioni immagine non valide!");
        }
        roi = new ROI(new Point2D(15,20),new Point2D(231,2432));
        try{
            image.getROIImage(roi).print();
        }
        catch(IllegalArgumentException exc){
            System.out.println(exc.getMessage());
        }
    }
}
