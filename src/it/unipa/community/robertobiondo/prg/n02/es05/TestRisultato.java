package it.unipa.community.robertobiondo.prg.n02.es05;

public class TestRisultato {

    public static void main(String args[]) {
        Risultato r1 = new Risultato(0F);
        r1.stampaRisultato();
        CambiaRisultato cr1 = new CambiaRisultato();
        cr1.cambiaRisultato(r1);
        r1.stampaRisultato();
    }
}
