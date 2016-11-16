/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es05;

import it.unipa.community.robertobiondo.prg.n06.es06.Scalable;
import it.unipa.community.robertobiondo.prg.utilities.math.MathUtils;

/**
 *
 * @author Bob
 */
public class Circle extends Shape implements Scalable {

    private double radius;

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.setRadius(radius);
    }

    public Circle(double radius) {
        this("", false, radius);
    }

    private void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            radius = 0;
        }
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public void scale(double factor) {
        if (factor > 0) {
            this.setRadius(this.getRadius() * factor);
        }
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    @Override
    public String toString() {
        if (this.getRadius() != 0) {
            StringBuilder s = new StringBuilder(super.toString());
            s.append("with radius of ").append(MathUtils.doubleFormat(this.getRadius())).append("cm.");
            s.append("\nPerimeter = ").append(MathUtils.doubleFormat(this.perimeter())).append("cm.");
            s.append("\nArea = ").append(MathUtils.doubleFormat(this.area())).append("cm^2.");
            return s.toString().replace("generic shape", "circle");
        } else {
            return "Not a valid circle.";
        }
    }

    public void print() {
        System.out.println(this);
    }
}
