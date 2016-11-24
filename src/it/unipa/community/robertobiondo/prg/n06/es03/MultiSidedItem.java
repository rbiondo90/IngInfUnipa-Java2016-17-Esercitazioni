/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n06.es03;

import it.unipa.community.robertobiondo.prg.utilities.Utils;

/**
 *
 * @author Roberto Biondo
 */
public abstract class MultiSidedItem {

    private final int SIDES_NUMBER;
    private final String[] SIDES_NAMES;

    public MultiSidedItem(final int numberOfSides, final String... sidesNames) {
        if (numberOfSides > 0) {
            this.SIDES_NUMBER = numberOfSides;
            if (sidesNames != null && sidesNames.length == numberOfSides && !Utils.containsEmptyString(sidesNames)) {
                this.SIDES_NAMES = sidesNames;
            } else {
                this.SIDES_NAMES = this.defaultSidesNames();
            }
        } else {
            this.SIDES_NUMBER = 1;
            this.SIDES_NAMES = this.defaultSidesNames();
        }
    }

    public MultiSidedItem(final int numberOfSides) {
        this(numberOfSides, null);
    }

    private String[] defaultSidesNames() {
        String[] defaultFaceNames = new String[this.getSidesNumber()];
        for (int i = 0; i < this.getSidesNumber(); i++) {
            defaultFaceNames[i] = "" + (i + 1);
        }
        return defaultFaceNames;
    }

    public int getSidesNumber() {
        return this.SIDES_NUMBER;
    }

    public String getSideName(int sideNumber) {
        if (this.SIDES_NAMES != null && sideNumber <= this.getSidesNumber() && sideNumber > 0) {
            return this.SIDES_NAMES[sideNumber - 1];
        } else {
            return "";
        }
    }

    private void draw(final int result) {
        int rotations = Utils.randomIntInRange(3, 10);
        StringBuilder roll = new StringBuilder();
        for (int i = 1; i <= rotations; i++) {
            int rolledValue = this.roll();
            roll.append(this.getSideName(rolledValue)).append(" ");
        }
        roll.append(this.getSideName(result)).append(".");
        System.out.print(roll);
    }

    public int roll(boolean draw) {
        int result = Utils.randomIntInRange(1, this.getSidesNumber());
        if (draw) {
            this.draw(result);
        }
        return result;
    }

    public int roll() {
        return this.roll(false);
    }

}
