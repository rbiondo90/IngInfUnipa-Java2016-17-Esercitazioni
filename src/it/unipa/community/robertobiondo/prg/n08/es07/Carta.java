/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es07;

import it.unipa.community.robertobiondo.prg.utilities.Utils;

/**
 *
 * @author Roberto Biondo
 */
public class Carta {

    public enum Seme {
        DENARI, COPPE, BASTONI, SPADE;

        @Override
        public String toString() {
            String s = Utils.capitalize(this.name());
            return s;
        }
    }

    public enum ValoreCarta {
        ASSO(1), DUE(2), TRE(3), QUATTRO(4), CINQUE(5), SEI(6), SETTE(7), DONNA(8), CAVALLO(9), RE(10);

        int numeroCarta;

        private ValoreCarta(int numeroCarta) {
            this.numeroCarta = numeroCarta;
        }

        @Override
        public String toString() {
            String s = Utils.capitalize(this.name());
            return s;
        }

        public int punti() {
            switch (this) {
                case ASSO:
                    return 11;
                case TRE:
                    return 10;
                case DONNA:
                    return 2;
                case CAVALLO:
                    return 3;
                case RE:
                    return 4;
                default:
                    return 0;
            }
        }
    }

    private final Seme SEME;
    private final ValoreCarta VALORE_CARTA;

    public Carta(Seme seme, ValoreCarta valoreCarta) {
        this.SEME = seme;
        this.VALORE_CARTA = valoreCarta;
    }

    public Seme getSeme() {
        return this.SEME;
    }

    public ValoreCarta getValoreCarta() {
        return this.VALORE_CARTA;
    }

    public int getPunti() {
        return this.VALORE_CARTA.punti();
    }

    @Override
    public String toString() {
        return "" + this.VALORE_CARTA + " di " + this.SEME;
    }

}
