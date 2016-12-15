/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unipa.community.robertobiondo.prg.n10.es05;

import it.unipa.community.robertobiondo.prg.n09.es09.Date;
import java.util.Comparator;

/**
 *
 * @author Roberto Biondo
 */
public class DateComparator implements Comparator<Date>{

    @Override
    public int compare(Date d1, Date d2) {
        return d1.compareTo(d2);
    }

}
