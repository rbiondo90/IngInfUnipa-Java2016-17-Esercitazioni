/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n10.es06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Roberto Biondo
 */
public class VectorInteger implements Comparable<VectorInteger> {

    private List<Integer> vector;
    private int dim;

    public VectorInteger(int dim) {
        this.setDim(dim);
        this.vector = new ArrayList<>(this.getDim());
        for (int i = 0; i < this.getDim(); i++) {
            this.vector.add(new Integer(0));
        }
    }

    public VectorInteger() {
        this(10);
    }

    public VectorInteger(Integer... elements) {
        this(Arrays.asList(elements));
    }

    public VectorInteger(Collection<Integer> collection) {
        this.setDim(collection.size());
        this.vector = new ArrayList<>();
        this.vector.addAll(collection);
    }

    public void set(int position, Integer element) {
        if (position < 0 || position >= this.getDim()) {
            throw new IllegalArgumentException("Wrong index!");
        }
        this.vector.set(position, element);
    }

    public Integer get(int position) {
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

    public VectorInteger add(VectorInteger v) {
        if (this.getDim() != v.getDim()) {
            throw new IllegalArgumentException("Cannot sum vectors with different dimensions!");
        }
        VectorInteger sum = new VectorInteger(this.getDim());
        for (int i = 0; i < this.getDim(); i++) {
            sum.set(i, this.get(i) + v.get(i));
        }
        return sum;
    }

    public VectorInteger integerProduct(int d) {
        VectorInteger realProduct = new VectorInteger(this.getDim());
        for (int i = 0; i < this.getDim(); i++) {
            realProduct.set(i, this.get(i) * d);
        }
        return realProduct;
    }

    public VectorInteger opposite() {
        return this.integerProduct(-1);
    }

    public VectorInteger subtract(VectorInteger v) {
        return this.add(v.opposite());
    }

    public double scalarProduct(VectorInteger v) {
        if (this.getDim() != v.getDim()) {
            throw new IllegalArgumentException("Cannot do scalar product of vectors"
                    + " with different sizes");
        }
        double scalarProduct = 0;
        for (int i = 0; i < this.getDim(); i++) {
            scalarProduct += this.get(i) * v.get(i);
        }
        return scalarProduct;
    }

    public double length() {
        return Math.sqrt(this.scalarProduct(this));
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
    public int compareTo(VectorInteger v) {
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
