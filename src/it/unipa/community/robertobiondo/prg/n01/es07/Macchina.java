package it.unipa.community.robertobiondo.prg.n01.es07;

public class Macchina {

    public final int PRESSIONE_MINIMA = 65;
    Ruota ruotaa1 = new Ruota();
    Ruota ruotaa2 = new Ruota();
    Ruota ruotap1 = new Ruota();
    Ruota ruotap2 = new Ruota();

    public void Cammina(float km) {
        ruotaa1.pressione -= km * ruotaa1.coeffpressione;
        ruotaa2.pressione -= km * ruotaa2.coeffpressione;
        ruotap1.pressione -= km * ruotap1.coeffpressione;
        ruotap2.pressione -= km * ruotap2.coeffpressione;
        //Questo metodo riduce la pressione di ogni ruota secondo i km percorsi e il coefficiente di diminuzione delle singole ruote
    }

    public void Monitora() {
        System.out.println("Livelli di pressione delle ruote:");
        System.out.println("\nRuota anteriore sinistra - " + ruotaa1.pressione);
        System.out.println("\nRuota anteriore destra - " + ruotaa2.pressione);
        System.out.println("\nRuota posteriore sinistra - " + ruotap1.pressione);
        System.out.println("\nRuota posteriore destra - " + ruotap2.pressione);
    }

    public void Revisione() {
        if (ruotaa1.pressione < PRESSIONE_MINIMA) {
            ruotaa1.pressione = 100;
            System.out.println("Pressione della ruota anteriore sinistra sotto la soglia minima. Ruota rigonfiata.");
        }
        if (ruotaa2.pressione < PRESSIONE_MINIMA) {
            ruotaa2.pressione = 100;
            System.out.println("Pressione della ruota anteriore destra sotto la soglia minima. Ruota rigonfiata.");
        }
        if (ruotap1.pressione < PRESSIONE_MINIMA) {
            ruotap1.pressione = 100;
            System.out.println("Pressione della ruota posteriore sinistra sotto la soglia minima. Ruota rigonfiata.");
        }
        if (ruotap2.pressione < PRESSIONE_MINIMA) {
            ruotap2.pressione = 100;
            System.out.println("Pressione della ruota posteriore destra sotto la soglia minima. Ruota rigonfiata.");
        }
    }
}
