package it.unipa.community.robertobiondo.prg.n07.es04;

import robertobiondo.utilities.math.MathUtils;

public class Razionale implements Comparable<Razionale>, AritmeticaRazionale {

    private int numeratore, denominatore;
    private boolean validity = true;

    public Razionale() {
        numeratore = 0;
        denominatore = 1;
    }

    public Razionale(int numeratore, int denominatore) {
        setNumeratore(numeratore);
        setDenominatore(denominatore);
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

    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
    }

    public void setDenominatore(int denominatore) {
        if (denominatore == 0) {
            this.setValidity(false);
        } else {
            this.setValidity(true);
            if (denominatore < 0) {
                this.denominatore = -denominatore;
                this.setNumeratore(-this.getNumeratore());
            } else {
                this.denominatore = denominatore;
            }
        }
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        if (this.getValidity()) {
            return denominatore;
        } else {
            return -1;
        }
    }

    public boolean getValidity() {
        return this.validity;
    }

    private void setValidity(boolean validity) {
        this.validity = validity;
    }

    public void semplifica() {
        if (this.getValidity()) {
            int mcd = (int) MathUtils.GCD(getNumeratore(), getDenominatore());
            setNumeratore(getNumeratore() / mcd);
            setDenominatore(getDenominatore() / mcd);
        }
    }

    @Override
    public String toString() {
//le doppie virgolette nell'assegnazione false dell'operatore ternario sono state aggiunte perch�  senza il compilatore restituiva un errore del tipo "impossibile convertire int in stringa"
        return ((this.getValidity()) ? ((getNumeratore() != 0 && Math.abs(getDenominatore()) != 1) ? (getNumeratore() + "/" + getDenominatore()) : (getNumeratore() + "")) : "NaN");
    }

    public Razionale convertiInRazionale(double r) {
        Razionale f = new Razionale(r);
        return f;
    }

    @Override
    public void stampa() {
        System.out.println(this.toString());
    }

    public Razionale somma(Razionale f2) {
        if (this.getValidity() && f2.getValidity()) {
            Razionale s = new Razionale(1, (int) MathUtils.lcm(this.getDenominatore(), f2.getDenominatore()));
            s.setNumeratore(((s.getDenominatore() / this.getDenominatore()) * this.getNumeratore()) + ((s.getDenominatore() / f2.getDenominatore()) * f2.getNumeratore()));
            s.semplifica();
            return s;
        } else {
            return null;
        }
    }

    public Razionale opposta() {
        if (this.getValidity()) {
            Razionale opp = new Razionale(-this.getNumeratore(), this.getDenominatore());
            return opp;
        }
        return null;
    }

    public Razionale sottrai(Razionale f2) {
        return this.somma(f2.opposta());
    }

    public Razionale moltiplica(Razionale f2) {
        if (this.getValidity() && f2.getValidity()) {
            Razionale m = new Razionale((this.getNumeratore() * f2.getNumeratore()), (this.getDenominatore() * f2.getDenominatore()));
            m.semplifica();
            return m;
        } else {
            return null;
        }
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

    public Razionale dividi(Razionale f2) {
        return this.moltiplica(f2.inversa());
    }

    public Razionale(String s) {
        int n, d;
        n = d = 1;
        s = s.trim();
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
