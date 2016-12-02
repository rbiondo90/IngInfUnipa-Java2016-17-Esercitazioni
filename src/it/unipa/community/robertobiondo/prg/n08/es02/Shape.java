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
public abstract class Shape implements Comparable {

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

    public abstract double perimeter();

    public abstract double area();

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("A ").append(color).append(" ").append((filled) ? "full " : "empty ").append("generic shape").append(" ");
        return s.toString();
    }

    @Override
    public int compareTo(Object shape) throws IllegalArgumentException{
        if (!(shape instanceof Shape)) {
            throw new IllegalArgumentException("Expecting a Shape object!");
        }
        double comparison = this.area() - ((Shape) shape).area();
        if (comparison > 0) {
            return 1;
        } else if (comparison < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public abstract void draw();
}
