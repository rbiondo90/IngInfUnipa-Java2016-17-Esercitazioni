/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es02;

/**
 *
 * @author Bob
 */
public class Square extends Rectangle {

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public Square(double side) {
        this("", false, side);
    }

    @Override
    public void setWidth(double side) throws IllegalArgumentException {
        this.setLength(side);
    }

    @Override
    public void setLength(double side) throws IllegalArgumentException {
        try {
            super.setWidth(side);
            super.setLength(side);
        } catch (IllegalArgumentException exc) {
            throw new IllegalArgumentException("Side length cannot be negative!");
        }

    }

    @Override
    public String toString() {
        return super.toString().replace("rectangle", "square");
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

}
