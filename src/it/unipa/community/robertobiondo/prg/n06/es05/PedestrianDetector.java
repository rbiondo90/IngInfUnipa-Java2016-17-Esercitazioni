/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n06.es05;

import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;
import it.unipa.community.robertobiondo.prg.n06.es04.Image;
import it.unipa.community.robertobiondo.prg.n06.es04.ROI;
import robertobiondo.utilities.Utils;

/**
 *
 * @author Roberto Biondo
 */
public class PedestrianDetector extends Detector {

    @Override
    //Devo fare in modo che venga generato un ROI che abbia altezza almeno tre volte pari alla sua stessa larghezza, mantenendomi comunque all'interno delle dimensioni dell'immagine
    public ROI detect(Image image) {
        Point2D topLeft, bottomRight;
        //larghezza - impostata al massimo ad un terzo del massimo valore di indice delle righe (in modo che l'altezza possa essere tre volte la larghezza senza incorrere in overflow
        int width = Utils.randomIntInRange(1, Math.min((image.getR() / 3), image.getC()));
        if (width == 0) {
            width = 1;
        }
        //altezza
        int height = Utils.randomIntInRange(width * 3, image.getR());
        //dopo aver randomizzato in modo corretto altezza e larghezza del ROI, devo randomizzarne anche la posizione tramite i due punti che lo costituiscono
        //il punto topLeft servirà da guida: bottomRight sarà automaticamente spostato dei valori di larghezza e altezza
        //devo inoltre fare in modo che il punto non assuma valori iniziali e finali che sforino le dimensioni dell'immagine
        topLeft = new Point2D(Utils.randomInt(image.getC() - width - 1), Utils.randomInt(image.getR() - height - 1));
        bottomRight = new Point2D(topLeft.getX() + width, topLeft.getY() + height);
        return new ROI(topLeft, bottomRight);
    }

    public static void main(String args[]) {
        Image image = new Image(8, 8);
        PedestrianDetector detector = new PedestrianDetector();
        image.print();
        image.getROIImage(detector.detect(image)).print();
    }
}
