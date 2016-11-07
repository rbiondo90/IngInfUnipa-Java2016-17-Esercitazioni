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
public class Rectangle extends Shape {

    private double width;
    private double length;
    private static final String SHAPE_NAME = "Rectangle";

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.setWidth(width);
        this.setLength(length);
    }

    public Rectangle(double width, double length) {
        this("", false, width, length);
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public double getWidth() {
        return this.width;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }
    }

    public double getLength() {
        return this.length;
    }

    @Override
    public double perimeter() {
        return 2 * (this.getWidth() + this.getLength());
    }

    @Override
    public double area() {
        return this.getWidth() * this.getLength();
    }

    @Override
    public String getShapeName() {
        return Rectangle.SHAPE_NAME;
    }

    @Override
    public String toString() {
        if (this.getWidth() != 0 && this.getLength() != 0) {
            StringBuilder s = new StringBuilder(super.toString());
            s.append("with a width of ").append(this.getWidth()).append("cm");
            if (this.getWidth() != this.getLength()) {
                s.append(" and a length of ").append(this.getLength()).append("cm.");
            } else {
                s.append(".");
            }
            s.append("\nPerimeter = ").append(this.perimeter()).append("cm.");
            s.append("\nArea = ").append(this.area()).append("cm^2.");
            return s.toString();
        } else {
            return "Not a valid rectangle.";
        }
    }

    public void print() {
        System.out.println(this);
    }

    public static void main(String args[]) {
        Rectangle r = new Rectangle(1, 0.5);
        r.print();
    }
}
