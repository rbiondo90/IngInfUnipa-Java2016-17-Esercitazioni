package it.unipa.community.robertobiondo.prg.n02.es05;

public class TestRisultatoFloat {

    public static void main(String args[]) {
        Risultato r1 = new Risultato(1.5F);
        CambiaRisultato cr1 = new CambiaRisultato();
        r1.stampaRisultato();
        cr1.cambiaRisultato(r1, 1.5F);
        r1.stampaRisultato();

    }
}
