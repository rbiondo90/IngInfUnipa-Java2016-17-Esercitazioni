/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es04;

import robertobiondo.utilities.math.linearAlgebra.Vector;
import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;
import robertobiondo.utilities.math.MathUtils;

/**
 *
 * @author Bob
 */
public class Point3D extends Point2D {

    private double z;

    public Point3D() {
        super();
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.setZ(z);
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getZ() {
        return this.z;
    }

    public double distanceFrom(Point3D p) {
        return Math.sqrt((Math.pow(p.getX() - this.getX(), 2)) + (Math.pow(p.getY() - this.getY(), 2)) + (Math.pow(p.getZ() - this.getZ(), 2)));
    }

    @Override
    public double distanceFromOrigin() {
        return this.distanceFrom(new Point3D(0, 0, 0));
    }

    @Override
    public Vector toVector() {
        return new Vector(this.getX(), this.getY(), this.getZ());
    }

    @Override
    public String toString() {
        return "(" + MathUtils.doubleFormat(this.getX()) + "," + MathUtils.doubleFormat(this.getY()) + "," + MathUtils.doubleFormat(this.getZ()) + ")";
    }

    @Override
    public void print() {
        System.out.println(this);
    }

}
