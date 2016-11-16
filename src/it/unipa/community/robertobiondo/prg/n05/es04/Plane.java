/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es04;

import it.unipa.community.robertobiondo.prg.utilities.math.linearAlgebra.Matrix;
import it.unipa.community.robertobiondo.prg.utilities.math.linearAlgebra.Vector;
import it.unipa.community.robertobiondo.prg.utilities.math.MathUtils;

/**
 *
 * @author Bob
 */
public class Plane {

    private Point3D p1, p2, p3;
    private boolean validity = false;

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        if (Vector.linearIndependence((p1.toVector().difference(p2.toVector())),(p3.toVector().difference(p2.toVector())))) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.validity = true;
        }
    }

    public Point3D getP1() {
        return this.p1;
    }

    public Point3D getP2() {
        return this.p2;
    }

    public Point3D getP3() {
        return this.p3;
    }

    public double getParameterA() {
        if (this.validity) {
            double a11 = this.getP2().getY() - this.getP1().getY();
            double a12 = this.getP2().getZ() - this.getP1().getZ();
            double a21 = this.getP3().getY() - this.getP1().getY();
            double a22 = this.getP3().getZ() - this.getP1().getZ();
            Matrix a = new Matrix(2, a11, a12, a21, a22);
            return a.determinant();
        } else {
            return Float.NaN;
        }
    }

    public double getParameterB() {
        if (this.validity) {
            double b11 = this.getP2().getX() - this.getP1().getX();
            double b12 = this.getP2().getZ() - this.getP1().getZ();
            double b21 = this.getP3().getX() - this.getP1().getX();
            double b22 = this.getP3().getZ() - this.getP1().getZ();
            Matrix b = new Matrix(2, b11, b12, b21, b22);
            return -b.determinant();
        } else {
            return Float.NaN;
        }
    }

    public double getParameterC() {
        if (this.validity) {
            double c11 = this.getP2().getX() - this.getP1().getX();
            double c12 = this.getP2().getY() - this.getP1().getY();
            double c21 = this.getP3().getX() - this.getP1().getX();
            double c22 = this.getP3().getY() - this.getP1().getY();
            Matrix c = new Matrix(2, c11, c12, c21, c22);
            return c.determinant();
        } else {
            return Float.NaN;
        }
    }

    public double getParameterD() {
        if (this.validity) {
            double a = this.getParameterA();
            double b = this.getParameterB();
            double c = this.getParameterC();
            double x1 = this.getP1().getX();
            double y1 = this.getP1().getY();
            double z1 = this.getP1().getZ();
            return -(a * x1 + b * y1 + c * z1);
        } else {
            return Float.NaN;
        }
    }

    public boolean containsPoint(Point3D point) {
        if (this.validity) {
            double a = this.getParameterA();
            double b = this.getParameterB();
            double c = this.getParameterC();
            double d = this.getParameterD();
            return a * point.getX() + b * point.getY() + c * point.getZ() + d == 0;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (this.validity) {
            StringBuilder s = new StringBuilder();
            double a, b, c, d;
            a = this.getParameterA();
            b = this.getParameterB();
            c = this.getParameterC();
            d = this.getParameterD();
            if (a < 0) {
                a *= -1;
                b *= -1;
                c *= -1;
                d *= -1;
            }
            if (a == 0 && b < 0) {
                c *= -1;
                d *= -1;
            }
            if (a == 0 && b == 0 && c < 0) {
                b *= -1;
                c *= -1;
                d *= -1;
            }
            if (MathUtils.isInteger(a) && MathUtils.isInteger(b) && MathUtils.isInteger(c) && MathUtils.isInteger(d)) {
                long gcd = MathUtils.GCD((long) a, (long) b, (long) c, (long) d);
                a /= gcd;
                b /= gcd;
                c /= gcd;
                d /= gcd;
            }
            if (a != 0) {
                s.append((a != 1 && (b != 0 || c != 0 || d != 0)) ? MathUtils.doubleFormat(a) : "").append("x ");
            }
            if (b != 0) {
                if (a != 0) {
                    s.append((b > 0) ? "+ " : "- ");
                }
                s.append((b != 1 && b != -1 && (a != 0 || c != 0 || d != 0)) ? MathUtils.doubleFormat(Math.abs(b)) : "");
                s.append("y ");
            }
            if (c != 0) {
                if (a != 0 || b != 0) {
                    s.append((c > 0) ? "+ " : "- ");
                }
                s.append((c != 1 && c != -1 && (a != 0 || b != 0 || d != 0)) ? MathUtils.doubleFormat(Math.abs(c)) : "");
                s.append("z ");
            }
            if (d != 0) {
                s.append((d > 0) ? "+ " : "- ");
                s.append(MathUtils.doubleFormat(Math.abs(d))).append(" ");
            }
            s.append("= 0");
            return s.toString();
        } else {
            return "Not a valid plane.";
        }
    }

    public void print() {
        System.out.println(this);
    }
    
    public boolean getValidity(){
        return this.validity;
    }

}
