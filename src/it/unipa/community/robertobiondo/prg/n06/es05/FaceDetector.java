/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n06.es05;

import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;
import it.unipa.community.robertobiondo.prg.n06.es04.Image;
import it.unipa.community.robertobiondo.prg.n06.es04.ROI;
import it.unipa.community.robertobiondo.prg.utilities.Utils;

/**
 *
 * @author Roberto Biondo
 */
public class FaceDetector extends Detector {

    @Override
    //Devo fare in modo che venga generato un ROI che abbia la minore fra altezza e larghezza non inferiore di più del 20% rispetto alla maggiore
    public ROI detect(Image image) {
        Point2D topLeft, bottomRight;
        //larghezza - grandezza pilotante, viene scelta nel range fra 1 e la dimensione minore dell'immagine
        int width = Utils.randomIntInRange(1, Math.min(image.getR(), image.getC()));
        //altezza - viene scelta in modo che non sia più grande o più piccola di più del 20% rispetto alla larghezza
        int height = Utils.randomIntInRange(width - width / 5, width + width / 5);
        //dopo aver randomizzato in modo corretto altezza e larghezza del ROI, devo randomizzarne anche la posizione tramite i due punti che lo costituiscono
        //il punto topLeft servirà da guida: bottomRight sarà automaticamente spostato dei valori di larghezza e altezza
        //devo inoltre fare in modo che il punto non assuma valori iniziali e finali che sforino le dimensioni dell'immagine
        topLeft = new Point2D(Utils.randomInt(image.getC() - width - 1), Utils.randomInt(image.getR() - height - 1));
        bottomRight = new Point2D(topLeft.getX() + width, topLeft.getY() + height);
        return new ROI(topLeft, bottomRight);
    }

    public static void main(String args[]) {
        Image image = new Image(8, 8);
        FaceDetector detector = new FaceDetector();
        image.print();
        image.getROIImage(detector.detect(image)).print();
    }
}
