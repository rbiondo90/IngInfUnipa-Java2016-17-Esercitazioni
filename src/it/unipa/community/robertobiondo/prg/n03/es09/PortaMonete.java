package it.unipa.community.robertobiondo.prg.n03.es09;

public class PortaMonete {

    private final int DIMENSIONE = 10; //Il portamonete potrà contenere al massimo DIMENSIONE monete
    private Moneta[] monete = new Moneta[DIMENSIONE];

//Costruttore della classe PortaMonete. Riceve in input un numero variabile di float, corrispondenti alle monete del portamonete
//se vengono specificati valori oltre la dimensione del portamonete, essi vengono ignorati.
//inoltre imposta ogni moneta non specificata a 0, valore che identificherà uno spazio vuoto nel portamonete
    public PortaMonete(float... valori) {
        for (int i = 0; i < DIMENSIONE; i++) {
            monete[i] = new Moneta(((i < valori.length) ? valori[i] : 0F));
        }
    }

//Conta quante monete sono presenti nel portamonete
    public int contenuto() {
        int c = 0;
        for (int i = 0; i < DIMENSIONE; i++) {
            if (monete[i].getValore() != 0) {
                c++;
            }
        }
        return c;
    }

    public void stato() {
        System.out.println("\nContenuto del portamonete:\n");
        for (int i = 0; i < DIMENSIONE; i++) {
            if (monete[i].getValore() != 0) {
                System.out.println(monete[i].getDescrizione());
            }
        }
    }

//aggiunge al portamonete una moneta del valore passato come parametro, dopo aver controllato se vi è spazio
    public void aggiungi(float valore) {
        if (contenuto() < DIMENSIONE) {
            monete[primoSpazioLibero()] = new Moneta(valore);
        } else {
            System.out.println("Portamonete pieno! Impossibile aggiungere monete!");
        }
    }

    public int primoSpazioLibero() {
        if (contenuto() == 10) {
            return 0;
        }
        int s = 0;
        for (int i = 0; i < DIMENSIONE; i++) {
            if (monete[i].getValore() == 0) {
                s = i;
                break;
            }
        }
        return s;
    }

    public void preleva(float valore) {
        boolean trovata = false;
        for (int i = 0; i < DIMENSIONE; i++) {
            if (monete[i].getValore() == valore) {
                System.out.println("Prelevata " + monete[i].getDescrizione() + ".");
                monete[i] = new Moneta(0F);
                trovata = true;
                break;
            }
        }
        if (!trovata) {
            System.out.println("Moneta cercata non presente nel portamonete.");
        }
    }
}
