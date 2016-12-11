/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.n08;

/**
 *
 * @author Roberto Biondo
 */
public class MainN09es08 {

    public static void main(String args[]) {
        TextAnalyzer t = new TextAnalyzer("PROGRAMMAZIONE (9 CFU) – A.A. 2016-2017 ES. 09\n"
                + "Inserire nel package it.unipa.community.nomecognome.prg.n09.es0X le seguenti applicazioni.\n"
                + "1) Riprendete la gerarchia di classi dell’esercitazione 7 in cui avete implementato in ogni classe la propria\n"
                + "versione della funzione membro draw() per il tracciamento della figura.\n"
                + "Utilizzate le vostre classi per creare una List<Shape> in cui memorizzare alcuni oggetti delle varie classi\n"
                + "(usate il metodo add()). Dopo aver inserito gli oggetti nella List<Shape> attraversatela interamente\n"
                + "utilizzando un Iterator<Shape> e chiamate il metodo draw() di ciascun oggetto per stampare i dettagli.\n"
                + "2) Utilizzando una Map<String, Shape> scrivete un programma in cui inserite in una mappa usando il\n"
                + "metodo get() forme geometriche di vario tipo con valori casuali e a cui assocerete un nome univoco (ad\n"
                + "esempio “cerchio1”, “quadrato2”, “Miorettangolo”, etc…). Verificate come col metodo get() sia possibile\n"
                + "accedere al valore dell’elemento della mappa in base al valore della chiave.\n"
                + "3) Scrivete un metodo static nella classe che contiene il main a cui passare una ArrayList di oggetti di\n"
                + "qualsiasi tipo e che, tramite un Iterator, stampa l’intera collezione.\n"
                + "4) Scrivete un metodo analogo a quello dell’esercizio precedente ma che riceve un ArrayList di oggetti che\n"
                + "estendono Shape e, tramite un Iterator, invoca il metodo draw() per tutti gli elementi della collezione.\n"
                + "Provate a passare un ArrayList<String> e verificate che non compila.\n"
                + "5) Definite una classe generica Stack<T> che implementi una pila di 100 elementi di tipo T tramite un\n"
                + "array. Le funzioni membro della classe devono essere:\n"
                + "void push(char), char pop(), boolean isEmpty(), boolean isFull().\n"
                + "Scrivete un programma che crea un oggetto Stack<String> e uno Stack<Integer> e verifica il corretto\n"
                + "funzionamento della classe.\n"
                + "6) Prendendo spunto dall’esempio Animale, Carnivoro, Erbivoro visto a lezione si modifichino le classi\n"
                + "Numero, Razionale, Complex delle esercitazioni precedenti in modo da dare un errore in compilazione\n"
                + "quando si tenta di effettuare operazioni non consentite (operazione aritmetica fra Razionale e Complex)\n"
                + "invece di lanciare una IllegalArgumentException a tempo di esecuzione.\n"
                + "Definite un’interfaccia generica per rappresentare Aritmetica<Complex> e Aritmetica<Razionale> in\n"
                + "cui sono definite le 4 operazioni aritmetiche. Le classi Razionale e Complex dovranno quindi\n"
                + "implementare rispettivamente Aritmetica<Razionale> e Aritmetica<Complex>.\n"
                + "7) Scrivete un programma che, utilizzando il metodo join(), concatena le stringhe “uno”, “due”, “tre”\n"
                + "separandole con uno spazio, le memorizza in una nuova stringa e la stampa. Convertite quindi tutta la\n"
                + "stringa in maiuscolo e, utilizzando replace(), sostituite allo spazio due trattini “--\". Stampate quindi il\n"
                + "risultato. Riconvertite ora la stringa in minuscolo e, utilizzando il metodo split(“--\"), estraete nuovamente\n"
                + "le stringhe “uno”, “due”, “tre” e stampatele.\n"
                + "8) Scrivete un programma che, utilizzando il metodo split su una stringa contenente il testo di questo\n"
                + "esercizio, determina il numero totale di parole presenti nel testo e la parola che compare con maggiore\n"
                + "frequenza. Potreste anche pensare di utilizzare una Map<String, Integer> per memorizzare la\n"
                + "frequenza di ciascuna parola utilizzando la parola stessa come chiave.\n"
                + "9) Implementate i metodi equals() e hashcode() per le classi Razionale, Complex e Date e verificatene il\n"
                + "corretto funzionamento con un programma di test.\n"
                + "NOTE PER COMPILAZIONE E TEST A RIGA DI COMANDO IN AMBIENTE LINUX:\n"
                + "Creare una cartella col proprio cognome sulla scrivania con all’interno le directory classes e src.\n"
                + "Aprire una finestra di terminale e digitare:\n"
                + "cd Desktop/cognome/classes oppure cd Scrivania/cognome/classes\n"
                + "Creare i file sorgente con gedit e salvarli nelle sottodirectory di src corrispondenti al package.\n"
                + "Digitare:\n"
                + "javac -d . ../src/it/unipa/.../prg/n09/es0X/*.java (compila e genera il bytecode)\n"
                + "java it.unipa.community.....prg.n09.es0X.Main (esegue il bytecode sulla JVM)");
        System.out.println(t.getText());
        System.out.println("\nParole presenti nel testo: " + t.getWordCount()
                + "\nParola più frequente: \"" + t.getMostFrequentWord() + "\" con frequenza "
                + t.getMostFrequentWordFrequency() + ".");
        System.out.println(t);
    }
}
