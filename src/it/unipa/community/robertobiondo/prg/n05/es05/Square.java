/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es05;

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
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return super.toString().replace("rectangle", "square");
    }

    @Override
    public void print() {
        System.out.println(this);
    }

}
