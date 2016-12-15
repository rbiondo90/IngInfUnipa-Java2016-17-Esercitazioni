/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n10.es06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Roberto Biondo
 */
public class Vector<T extends Number> implements Comparable<Vector<T>> {

    private ArrayList<T> vector;
    private int dim;

    public Vector(int dim) {
        this.setDim(dim);
        this.vector = new ArrayList<>(this.getDim());
        for (int i = 0; i < this.getDim(); i++) {
            this.vector.add((T) new Integer(0));
        }
    }

    public Vector() {
        this(10);
    }

    public Vector(T... elements) {
        this(Arrays.asList(elements));
    }

    public Vector(Collection<T> collection) {
        this.setDim(collection.size());
        this.vector = new ArrayList<>();
        this.vector.addAll(collection);
    }

    public void set(int position, T element) {
        if (position < 0 || position >= this.getDim()) {
            throw new IllegalArgumentException("Wrong index!");
        }
        this.vector.set(position, element);
    }

    public T get(int position) {
        if (position < 0 || position >= this.getDim()) {
            throw new IllegalArgumentException("Wrong index!");
        }
        return this.vector.get(position);
    }

    private void setDim(int dim) {
        if (dim < 1) {
            throw new IllegalArgumentException("Vector's dimension cannot be " + dim + "! Only values >=1 are accepted.");
        }
        this.dim = dim;
    }

    public int getDim() {
        return this.dim;
    }

    public Vector add(Vector<T> v) {
        if (this.getDim() != v.getDim()) {
            throw new IllegalArgumentException("Cannot sum vectors with different dimensions!");
        }
        Vector sum = new Vector(this.getDim());
        for (int i = 0; i < this.getDim(); i++) {
            sum.set(i, this.get(i).doubleValue() + v.get(i).doubleValue());
        }
        return sum;
    }

    public Vector realProduct(double d) {
        Vector realProduct = new Vector(this.getDim());
        for (int i = 0; i < this.getDim(); i++) {
            realProduct.set(i, this.get(i).doubleValue() * d);
        }
        return realProduct;
    }

    public Vector opposite() {
        return this.realProduct(-1);
    }

    public Vector subtract(Vector<T> v) {
        return this.add(v.opposite());
    }

    public double scalarProduct(Vector v) {
        if (this.getDim() != v.getDim()) {
            throw new IllegalArgumentException("Cannot do scalar product of vectors"
                    + " with different sizes");
        }
        double scalarProduct = 0;
        for (int i = 0; i < this.getDim(); i++) {
            scalarProduct += this.get(i).doubleValue() * v.get(i).doubleValue();
        }
        return scalarProduct;
    }

    public double length() {
        double squareSum = 0;
        for (int i = 0; i < this.getDim(); i++) {
            squareSum += Math.pow(this.get(i).doubleValue(), 2);
        }
        return Math.sqrt(squareSum);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.getDim(); i++) {
            if (i == 0) {
                s.append("[");
            }
            s.append(this.get(i));
            if (i != this.getDim() - 1) {
                s.append(", ");
            } else {
                s.append("]");
            }
        }
        return s.toString();
    }

    @Override
    public int compareTo(Vector<T> v) {
        double mod1 = this.length();
        double mod2 = v.length();
        if (mod1 > mod2) {
            return 1;
        }
        if (mod1 == mod2) {
            return 0;
        } else {
            return -1;
        }
    }
}
