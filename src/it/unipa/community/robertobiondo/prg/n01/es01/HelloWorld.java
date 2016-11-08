package it.unipa.community.robertobiondo.prg.n01.es01;

public class HelloWorld {

    public static void main(String args[]) {
        System.out.println("Hello World!");
        System.out.println("Ciao Mondo!");
        System.out.println(2432);
        System.out.println(4 + 5);
    }
}
//Togliendo il modificatore static dal metodo main, il programma viene compilato 
//ma in fase di esecuzione si ottiene un errore perchè il metodo main deve essere
// necessariamente dichiarato come static

//Togliendo la prima parentesi graffa nella seconda riga, il compilatore genera
//un errore perch� si aspetta un simbolo alla fine della riga
//(che viene erroneamente indicato come ;) inoltre genera un secondo errore
//nella riga 5, in quanto trova una parentesi graffa chiusa che non � mai stata aperta
//Cancellando l'ultima parentesi graffa, il compilatore genera un errore perch� arriva
//alla fine del file senza incontrare il terminatore che chiude la classe
