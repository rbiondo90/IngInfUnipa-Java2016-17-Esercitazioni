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
public class Line {

    private Point2D p1;
    private Point2D p2;

    public Line(Point2D p1, Point2D p2) {
        if (Vector.linearIndependence(p1.toVector(), p2.toVector())) {
            this.p1 = p1;
            this.p2 = p2;
        }

    }

    public Point2D getP1() {
        return this.p1;
    }

    public Point2D getP2() {
        return this.p2;
    }

    public boolean containsPoint(Point2D point) {
        if (this.getP1()!= null && this.getP2()!=null) {
            return this.getParameterA() * point.getX() + this.getParameterB() * point.getY() + this.getParameterC() == 0;
        } else {
            return false;
        }
    }

    public double getParameterA() {
        return this.getP2().getY() - this.getP1().getY();
    }

    public double getParameterB() {
        return this.getP1().getX() - this.getP2().getX();
    }

    public double getParameterC() {
        return this.getP1().getY() * this.getP2().getX() - this.getP1().getX() * this.getP2().getY();
    }

    @Override
    public String toString() {
        if (this.getP1() != null && this.getP2() != null) {
            StringBuilder s = new StringBuilder();
            double a, b, c;
            a = this.getParameterA();
            b = this.getParameterB();
            c = this.getParameterC();
            if (a < 0) {
                a *= -1;
                b *= -1;
                c *= -1;
            }
            if (a == 0 && b < 0) {
                b *= -1;
                c *= -1;
            }
            if (MathUtils.isInteger(a) && MathUtils.isInteger(b) && MathUtils.isInteger(c)) {
                long gcd = MathUtils.GCD((long) a, (long) b, (long) c);
                a /= gcd;
                b /= gcd;
                c /= gcd;
            }
            if (a != 0) {
                s.append((a != 1 && (b != 0 || c != 0)) ? a : "").append("x ");
            }
            if (b != 0) {
                if (a != 0) {
                    s.append((b > 0) ? "+ " : "- ");
                }
                s.append((b != 1 && b != -1 && (a != 0 || c != 0)) ? Math.abs(b) : "");
                s.append("y ");
            }
            if (c != 0) {
                s.append((c > 0) ? "+ " : "- ");
                s.append(Math.abs(c)).append(" ");
            }
            s.append("= 0");
            return s.toString();
        } else {
            return "Invalid line.";
        }
    }

    public void print() {
        System.out.println(this);
    }

    public static void main(String args[]) {
        Line l = new Line(new Point2D(4, 6), new Point2D(2, 3));
        l.print();
        System.out.println(l.containsPoint(new Point2D(4, 6)));

    }

}
