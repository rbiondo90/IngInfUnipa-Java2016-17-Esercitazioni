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
public class CarDetector extends Detector {

    @Override
    //Devo fare in modo che venga generato un ROI che abbia larghezza pari ad almeno due volte la sua altezza, mantenendomi comunque all'interno delle dimensioni dell'immagine
    public ROI detect(Image image) {
        Point2D topLeft, bottomRight;
        //altezza - impostata al massimo a metà del massimo valore di indice delle righe (in modo che la larghezza possa valere due volte l'altezza senza incorrere in overflow)
        int height = Utils.randomIntInRange(1, Math.min((image.getC() / 2), image.getR()));
        if (height == 0) {
            height = 1;
        }
        //larghezza
        int width = Utils.randomIntInRange(height * 2, image.getC());
        //dopo aver randomizzato in modo corretto altezza e larghezza del ROI, devo randomizzarne anche la posizione tramite i due punti che lo costituiscono
        //il punto topLeft servirà da guida: bottomRight sarà automaticamente spostato dei valori di larghezza e altezza
        //devo inoltre fare in modo che il punto non assuma valori iniziali e finali che sforino le dimensioni dell'immagine
        topLeft = new Point2D(Utils.randomInt(image.getC() - width - 1), Utils.randomInt(image.getR() - height - 1));
        bottomRight = new Point2D(topLeft.getX() + width, topLeft.getY() + height);
        return new ROI(topLeft, bottomRight);
    }

    public static void main(String args[]) {
        Image image = new Image(7, 7);
        CarDetector detector = new CarDetector();
        image.print();
        image.getROIImage(detector.detect(image)).print();
    }
}
