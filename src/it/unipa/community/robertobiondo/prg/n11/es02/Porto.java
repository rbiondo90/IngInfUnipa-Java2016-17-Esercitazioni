package it.unipa.community.robertobiondo.prg.n11.es02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Porto {

    private List<Nave> navi;
    private Double sogliaDiCollisione;

    public Porto(double sogliaDiCollisione) {
        this.navi = new ArrayList<>();
        this.setSogliaDiCollisione(sogliaDiCollisione);
    }

    public Porto() {
        this(10);
    }

    public void setSogliaDiCollisione(Double sogliaDiCollisione) {
        if (Objects.isNull(sogliaDiCollisione) || sogliaDiCollisione < 0) {
            throw new IllegalArgumentException("Soglia di collisione non valida!");
        }
        this.sogliaDiCollisione = sogliaDiCollisione;
    }

    public Double getSogliaDiCollisione() {
        return this.sogliaDiCollisione;
    }

    public boolean aggiungiNave(Nave nave) {
        return navi.add(nave);
    }

    public boolean rimuoviNave(Nave nave) {
        return navi.remove(nave);
    }

    public boolean rimuoviNave(String nomeNave) {
        if (Objects.isNull(nomeNave) || nomeNave.isEmpty()) {
            return false;
        }
        Iterator<Nave> iteratore = navi.iterator();
        while (iteratore.hasNext()) {
            if (iteratore.next().getCodiceIdentificativo().equals(nomeNave)) {
                iteratore.remove();
                return true;
            }
        }
        return false;
    }

    public void avanzaTutteLeNavi() {
        Iterator<Nave> iteratoreNavi = navi.iterator();
        while (iteratoreNavi.hasNext()) {
            iteratoreNavi.next().avanza();
        }
    }

    public void verificaCollisioni() {
        Iterator<Nave> iteratoreEsterno = this.navi.iterator();
        for (int i = 1; iteratoreEsterno.hasNext(); i++) {
            Nave naveDaConfrontare1 = iteratoreEsterno.next();
            ListIterator<Nave> iteratoreInterno = this.navi.listIterator(i);
            while (iteratoreInterno.hasNext()) {
                Nave naveDaConfrontare2 = iteratoreInterno.next();
                if (naveDaConfrontare1.distanzaDa(naveDaConfrontare2) < this.getSogliaDiCollisione()) {
                    System.out.println("Attenzione! La nave " + naveDaConfrontare1.getCodiceIdentificativo()
                            + " è in rotta di collisione con la nave " + naveDaConfrontare2.getCodiceIdentificativo());
                }
            }
        }
    }

    public void stampaStatoNaviPresenti() {
        if (this.getNumeroNavi() == 0) {
            System.out.println("Porto vuoto.");
        } else {
            Iterator<Nave> iteratore = this.navi.iterator();
            while (iteratore.hasNext()) {
                System.out.println("--------------------------------------------------------------------");
                iteratore.next().stampaStato();
                System.out.println();
            }
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public Integer getNumeroNavi() {
        return navi.size();
    }

}
