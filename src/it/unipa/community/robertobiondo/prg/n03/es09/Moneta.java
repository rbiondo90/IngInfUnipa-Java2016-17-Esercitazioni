package it.unipa.community.robertobiondo.prg.n03.es09;

public class Moneta {

    private final String VALUTA = "EURO";
    private float valore;

    public Moneta(float valore) {
        this.setValore(valore);
    }

    /**
     * se il parametro valore è maggiore di zero, assegna il valore e ritorna
     * true, altrimenti il valore rimane a 0 e ritorna false Il valore di
     * ritorno è un boolean per poter essere utilizzato per controllare che
     * l'operazione sia andata a buona fine
     */
    public boolean setValore(float valore) {
        if (valore > 0) {
            this.valore = valore;
            return true;
        } else {
            this.valore = 0;
            return false;
        }
    }
//Ho scelto di implementare il metodo getValore perchè utile nella gestione del portamonete

    public float getValore() {
        return this.valore;
    }

    public String getDescrizione() {
        return (((valore > 2) ? "Banconota" : "Moneta") + " da " + ((valore >= 1) ? (valore + " " + VALUTA) : ((int) (valore * 100)
                + ((valore * 100 > 1) ? (" centesimi") : (" centesimo")) + " di " + VALUTA)));
    }
}
