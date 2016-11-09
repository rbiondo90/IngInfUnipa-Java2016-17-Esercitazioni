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
public abstract class Shape {

    private static final String SHAPE_NAME = "generic shape";

    private String color = "black";
    private boolean filled = false;

    public Shape(String color, boolean filled) {
        this.setColor(color);
        this.setFilled(filled);
    }

    public void setColor(String color) {
        if (!color.isEmpty()) {
            this.color = color;
        }
    }

    public String getColor() {
        return this.color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean getFilled() {
        return this.filled;
    }

    public String getShapeName() {
        return this.SHAPE_NAME;
    }

    public abstract double perimeter();

    public abstract double area();

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("A ").append(color).append(" ").append((filled) ? "full " : "empty ").append(this.getShapeName()).append(" ");
        return s.toString();
    }
}
