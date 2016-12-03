/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n07.es06;

import it.unipa.community.robertobiondo.prg.n06.es06.Scalable;
import robertobiondo.utilities.math.MathUtils;

/**
 *
 * @author Bob
 */
public class Rectangle extends Shape implements Scalable {

    private double width;
    private double length;

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
    public void scale(double factor) {
        if (factor > 0) {
            this.setLength(this.getLength() * factor);
            this.setWidth(this.getWidth() * factor);
        }
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
    public String toString() {
        if (this.getWidth() != 0 && this.getLength() != 0) {
            StringBuilder s = new StringBuilder(super.toString());
            s.append("with width of ").append(MathUtils.doubleFormat(this.getWidth())).append("cm");
            if (this.getWidth() != this.getLength()) {
                s.append(" and length of ").append(MathUtils.doubleFormat(this.getLength())).append("cm.");
            } else {
                s.append(".");
            }
            s.append("\nPerimeter = ").append(MathUtils.doubleFormat(this.perimeter())).append("cm.");
            s.append("\nArea = ").append(MathUtils.doubleFormat(this.area())).append("cm^2.");
            return s.toString().replace("generic shape", "rectangle");
        } else {
            return "Not a valid rectangle.";
        }
    }

    @Override
    public void draw() {
        System.out.println(this);
    }
}
