package it.unipa.community.robertobiondo.prg.n08.es01;

import it.unipa.community.robertobiondo.prg.utilities.math.MathUtils;

public class Razionale extends Numero implements Comparable<Razionale> {

    private int numeratore, denominatore;

    public Razionale() {
        numeratore = 0;
        denominatore = 1;
    }

    public Razionale(int numeratore, int denominatore) {
        this.setNumeratore(numeratore);
        try {
            this.setDenominatore(denominatore);
        } catch (ArithmeticException exc) {
            throw exc;
        }
    }

    public Razionale(double r) {
        String s = String.valueOf(Math.abs(r));
        int digitsDec = s.length() - 1 - s.indexOf('.');
        int denom = 1;
        for (int i = 0; i < digitsDec; i++) {
            r *= 10;
            denom *= 10;
        }
        int numer = (int) Math.round(r);
        if (r < 0) {
            numer *= -1;
        }
        this.setNumeratore(numer);
        this.setDenominatore(denom);
        this.semplifica();
    }

    public Razionale(String s) throws NumberFormatException{
        int n, d;
        s = s.trim();
        try {
            if (s.contains("/")) {
                String splitted[] = s.split("/");
                for (String i : splitted) {
                    i = i.trim();
                }
                n = Integer.parseInt(splitted[0]);
                d = Integer.parseInt(splitted[1]);
                this.setNumeratore(n);
                this.setDenominatore(d);
                this.semplifica();
            } else {
                n = Integer.parseInt(s);
                this.setNumeratore(n);
                this.setDenominatore(1);
            }
        }
        catch(NumberFormatException exc){
            throw new NumberFormatException("Stringa non valida come frazione!");
        }
    }

    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
    }

    public void setDenominatore(int denominatore) throws ArithmeticException {
        if (denominatore == 0) {
            throw new ArithmeticException("Il denominatore di una frazione non può essere zero!");
        } else if (denominatore < 0) {
            this.denominatore = -denominatore;
            this.setNumeratore(-this.getNumeratore());
        } else {
            this.denominatore = denominatore;
        }
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    public void semplifica() {
        int mcd = (int) MathUtils.GCD(getNumeratore(), getDenominatore());
        setNumeratore(getNumeratore() / mcd);
        setDenominatore(getDenominatore() / mcd);
    }

    @Override
    public String toString() {
//le doppie virgolette nell'assegnazione false dell'operatore ternario sono state aggiunte perchè
//senza il compilatore restituiva un errore del tipo "impossibile convertire int in stringa"
        return ((getNumeratore() != 0 && Math.abs(getDenominatore()) != 1)
                ? (getNumeratore() + "/" + getDenominatore()) : (getNumeratore() + ""));
    }

    public Razionale convertiInRazionale(double r) {
        Razionale f = new Razionale(r);
        return f;
    }

    @Override
    public void stampa() {
        System.out.println(this.toString());
    }

    @Override
    public Razionale somma(Numero elemento2) throws IllegalArgumentException {
        if (!(elemento2 instanceof Razionale)) {
            throw new IllegalArgumentException("Il metodo somma si aspetta un Razionale come parametro!");
        }
        Razionale f2 = (Razionale) elemento2;
        Razionale s = new Razionale(1, (int) MathUtils.lcm(this.getDenominatore(), f2.getDenominatore()));
        s.setNumeratore(((s.getDenominatore() / this.getDenominatore()) * this.getNumeratore())
                + ((s.getDenominatore() / f2.getDenominatore()) * f2.getNumeratore()));
        s.semplifica();
        return s;
    }

    @Override
    public Razionale sottrai(Numero elemento2) throws IllegalArgumentException {
        if (!(elemento2 instanceof Razionale)) {
            throw new IllegalArgumentException("Il metodo sottrai si aspetta un Razionale come parametro!");
        }
        return this.somma(((Razionale) elemento2).opposta());
    }

    @Override
    public Razionale moltiplica(Numero elemento2) throws IllegalArgumentException {
        if (!(elemento2 instanceof Razionale)) {
            throw new IllegalArgumentException("Il metodo moltiplica si aspetta un Razionale come parametro!");
        }
        Razionale f2 = (Razionale) elemento2;
        Razionale m = new Razionale((this.getNumeratore() * f2.getNumeratore()), (this.getDenominatore() * f2.getDenominatore()));
        m.semplifica();
        return m;
    }

    @Override
    public Razionale dividi(Numero elemento2) throws IllegalArgumentException, ArithmeticException {
        if (!(elemento2 instanceof Razionale)) {
            throw new IllegalArgumentException("Il metodo dividi si aspetta un Razionale come parametro!");
        }
        return this.moltiplica(((Razionale) elemento2).inversa());
    }

    public Razionale opposta() {
        Razionale opp = new Razionale(-this.getNumeratore(), this.getDenominatore());
        return opp;
    }

    public Razionale inversa() throws ArithmeticException {
        Razionale inv;
        if (this.getNumeratore() != 0) {
            inv = new Razionale(this.getDenominatore(), this.getNumeratore());
            return inv;
        } else {
            throw new ArithmeticException("Non posso invertire lo zero!");
        }
    }

    public Razionale valoreAssoluto() {
        return new Razionale(Math.abs(this.getNumeratore()), this.getDenominatore());
    }

    public double toDouble() {
        return ((double) numeratore / (double) denominatore);
    }

    @Override
    public int compareTo(Razionale razionale) {
        if (razionale != null) {
            return this.getNumeratore() * razionale.getDenominatore() - this.getDenominatore() * razionale.getNumeratore();
        } else {
            throw new NullPointerException();
        }
    }

}
