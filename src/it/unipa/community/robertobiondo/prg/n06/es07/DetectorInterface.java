/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unipa.community.robertobiondo.prg.n06.es07;

import it.unipa.community.robertobiondo.prg.n06.es04.Image;
import it.unipa.community.robertobiondo.prg.n06.es04.ROI;

/**
 *
 * @author Roberto Biondo
 */
public interface DetectorInterface {

    public abstract ROI detect(Image image);
}
