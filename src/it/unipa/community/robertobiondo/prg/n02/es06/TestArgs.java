package it.unipa.community.robertobiondo.prg.n02.es06;

public class TestArgs {

    public static void main(String args[]) {
        //Stampa su schermo la prima stringa scritta dopo il nome del programma in fase di lancio
        //L'if è necessario per evitare un'eccezione nel caso in cui si lanci il programma senza specificare alcun parametro subito dopo
        if (args.length > 0) {
            System.out.println(args[0]);
        }
    }
}
