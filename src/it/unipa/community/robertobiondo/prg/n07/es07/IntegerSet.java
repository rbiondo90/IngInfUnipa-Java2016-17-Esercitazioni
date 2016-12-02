/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n07.es07;

import java.util.Arrays;

/**
 *
 * @author Roberto Biondo
 */
public class IntegerSet {

    private boolean a[];
    private final int SIZE;

    public IntegerSet(int SIZE) {
        try {
            a = new boolean[SIZE];
        } catch (NegativeArraySizeException exception) {
            System.out.println("Set size cannot be negative!\nSet initialized with the default size of 100.");
            a = new boolean[100];
            SIZE = 100;
        } finally {
            this.SIZE = SIZE;
        }
    }

    public IntegerSet() {
        this(100);
    }

    public boolean getElement(int element) {
        try {
            return this.a[element];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
    }

    public int getSize() {
        return this.SIZE;
    }

    public IntegerSet unionOfIntegerSet(IntegerSet set2) {
        if (this == null || set2 == null) {
            return this.clone();
        } else {
            IntegerSet unionSet = new IntegerSet(Math.max(this.getSize(), set2.getSize()));
            for (int i = 0; i < unionSet.getSize(); i++) {
                unionSet.a[i] = this.getElement(i) || set2.getElement(i);
            }
            return unionSet;
        }
    }

    public IntegerSet unionOfIntegerSets(IntegerSet... otherSets) {
        if (otherSets != null && this != null) {
            IntegerSet unionSet = this.unionOfIntegerSet(otherSets[0]);
            for (int i = 1; i < otherSets.length; i++) {
                unionSet = unionSet.unionOfIntegerSet(otherSets[i]);
            }
            return unionSet;
        }
        return this.clone();
    }

    public IntegerSet intersectionOfIntegerSet(IntegerSet set2) {
        if (this == null || set2 == null) {
            return new IntegerSet();
        }
        IntegerSet intersectionSet = new IntegerSet(Math.min(this.getSize(), set2.getSize()));
        for (int i = 0; i < intersectionSet.getSize(); i++) {
            intersectionSet.a[i] = this.getElement(i) && set2.getElement(i);
        }
        return intersectionSet;
    }

    public IntegerSet intersectionOfIntegerSets(IntegerSet... otherSets) {
        if (this == null || otherSets == null) {
            return new IntegerSet();
        } else {
            IntegerSet intersectionSet = this.intersectionOfIntegerSet(otherSets[0]);
            for (int i = 1; i < otherSets.length; i++) {
                intersectionSet = intersectionSet.intersectionOfIntegerSet(otherSets[i]);
            }
            return intersectionSet;
        }

    }

    private void setElement(boolean set, int element) throws ArrayIndexOutOfBoundsException {
        if (element >= this.getSize()) {
            throw new ArrayIndexOutOfBoundsException("Element exceeding set size (" + this.getSize() + "). Set unchanged.");
        }
        this.a[element] = set;
    }

    private void setElements(boolean set, int... elements) throws ArrayIndexOutOfBoundsException {
        StringBuilder exceptionsAtIndexes = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            try {
                this.setElement(set, elements[i]);
            } catch (ArrayIndexOutOfBoundsException exception) {
                if (!(exceptionsAtIndexes.length() == 0)) {
                    exceptionsAtIndexes.append(", ");
                }
                exceptionsAtIndexes.append(elements[i]);
            }
        }
        if (!(exceptionsAtIndexes.length() == 0)) {
            throw new ArrayIndexOutOfBoundsException("Elements exceeding set size (" + this.getSize() + "): " + exceptionsAtIndexes + " .");
        }
    }

    public void insertElement(int element) {
        this.setElement(true, element);
    }

    public void insertElements(int... elements) {
        this.setElements(true, elements);
    }

    public void deleteElement(int element) {
        this.setElement(false, element);
    }

    public void deleteElements(int... elements) {
        this.setElements(false, elements);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.getSize(); i++) {
            if (this.a[i]) {
                s.append(i).append(" ");
            }
        }
        if (s.length() == 0) {
            s.append(" - ");
        }
        return s.toString();
    }

    public void print() {
        System.out.print(this + "\n");
    }

    @Override
    public IntegerSet clone() {
        IntegerSet cloneSet = new IntegerSet(this.getSize());
        cloneSet.a = Arrays.copyOf(this.a, this.getSize());
        return cloneSet;
    }

}
