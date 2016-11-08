package it.unipa.community.robertobiondo.prg.n02.es05;

public class CambiaRisultato {

    public void cambiaRisultato(Risultato x) {
        x.risultato += 3.14F;
    }

    public void cambiaRisultato(Risultato x, float f) {
        x.risultato += f;
    }
}
