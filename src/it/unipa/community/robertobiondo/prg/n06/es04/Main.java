/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n06.es04;

import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;

/**
 *
 * @author Roberto Biondo
 */
public class Main {

    public static void main(String args[]) {
        Image image = new Image(6, 6);
        image.print();
        ROI roi = new ROI(new Point2D(1, 0), new Point2D(6, 6));
        image.getROIImage(roi).print();
    }
}
