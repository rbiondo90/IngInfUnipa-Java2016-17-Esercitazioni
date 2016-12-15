package it.unipa.community.robertobiondo.prg.n09.es09;

import it.unipa.community.robertobiondo.prg.n09.es06.Numero;
import it.unipa.community.robertobiondo.prg.n09.es06.Aritmetica;
import java.util.Objects;

public class Complex extends Numero implements Aritmetica<Complex> {

    private double parteReale;
    private double parteImmaginaria;

    public Complex(double parteReale, double parteImmaginaria) {
        this.setParteReale(parteReale);
        this.setParteImmaginaria(parteImmaginaria);
    }

    public Complex() {
        this(0, 0);
    }

    public Complex(double parteReale) {
        this(parteReale, 0);
    }

    public void setParteReale(double parteReale) {
        this.parteReale = parteReale;
    }

    public void setParteImmaginaria(double parteImmaginaria) {
        this.parteImmaginaria = parteImmaginaria;
    }

    public double getParteReale() {
        return this.parteReale;
    }

    public double getParteImmaginaria() {
        return this.parteImmaginaria;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (this.getParteReale() != 0) {
            s.append(this.getParteReale());
            s.append((this.getParteImmaginaria() > 0) ? " + " : "");
        }
        if (this.getParteImmaginaria() != 0) {
            s.append((this.getParteImmaginaria() < 0) ? " - " : "");
            s.append("i").append(Math.abs(this.getParteImmaginaria()));
        }
        if (this.getParteImmaginaria() == 0 && this.getParteReale() == 0) {
            s.append("0");
        }
        return s.toString();
    }

    public void stampa() {
        System.out.println(this.toString());
    }

    public static void stampa(Complex c) {
        c.stampa();
    }

    public static Complex somma(Complex c1, Complex c2) {
        return c1.somma(c2);
    }

    @Override
    public Complex somma(Complex c2) {
        return new Complex(this.getParteReale() + c2.getParteReale(), this.getParteImmaginaria() + c2.getParteImmaginaria());
    }

    private Complex opposto() {
        return new Complex(-this.getParteReale(), -this.getParteImmaginaria());
    }

    public Complex coniugato() {
        return new Complex(this.getParteReale(), -this.getParteImmaginaria());
    }

    public double modulo() {
        return Math.sqrt(Math.pow(this.getParteReale(), 2) + Math.pow(this.getParteImmaginaria(), 2));
    }

    private Complex inverso() {
        if (this.modulo() != 0) {
            return new Complex(this.getParteImmaginaria() / (Math.pow(this.modulo(), 2)), -this.getParteImmaginaria() / (Math.pow(this.modulo(), 2)));
        } else {
            return new Complex();
        }
    }

    @Override
    public Complex sottrai(Complex c2) {
        return this.somma(c2.opposto());
    }

    public static Complex sottrai(Complex c1, Complex c2) {
        return c1.sottrai(c2);
    }

    @Override
    public Complex moltiplica(Complex elemento2) {
        Complex c = (Complex) elemento2;
        double parteRealeDelProdotto = this.getParteReale() * c.getParteReale() - this.getParteImmaginaria() * c.getParteImmaginaria();
        double parteImmaginariaDelProdotto = this.getParteReale() * c.getParteImmaginaria() + this.getParteImmaginaria() * c.getParteReale();
        return new Complex(parteRealeDelProdotto, parteImmaginariaDelProdotto);
    }

    @Override
    public Complex dividi(Complex elemento2) {
        return this.moltiplica((elemento2.inverso()));
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.isNull(o) || !(o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;
        return this.getParteImmaginaria() == c.getParteImmaginaria() && this.getParteReale() == c.getParteReale();

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.getParteReale())
                ^ (Double.doubleToLongBits(this.getParteReale()) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.getParteImmaginaria())
                ^ (Double.doubleToLongBits(this.getParteImmaginaria()) >>> 32));
        return hash;
    }

}
