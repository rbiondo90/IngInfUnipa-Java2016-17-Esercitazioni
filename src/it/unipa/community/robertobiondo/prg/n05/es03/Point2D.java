/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es03;

import it.unipa.community.robertobiondo.prg.utilities.math.MathUtils;
import it.unipa.community.robertobiondo.prg.utilities.math.linearAlgebra.Vector;

/**
 *
 * @author Bob
 */
public class Point2D {

    private double x;
    private double y;

    public Point2D() {

    }

    public Point2D(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return this.y;
    }

    public double distanceFrom(Point2D point) {
        return Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2));
    }

    public double distanceFromOrigin() {
        return this.distanceFrom(new Point2D(0, 0));
    }
    
    public boolean equals(Point2D p2){
        return this.getX()==p2.getX() && this.getY()==p2.getY();
    }
    
    public Vector toVector(){
        return new Vector(this.getX(),this.getY());
    }

    @Override
    public String toString() {
        return ("(" + MathUtils.doubleFormat(this.getX()) + "," + MathUtils.doubleFormat(this.getY()) + ")");
    }
    
    public void print(){
        System.out.println(this);
    }
    
    @Override
    public Point2D clone(){
        return new Point2D(this.getX(),this.getY());
    }
}
