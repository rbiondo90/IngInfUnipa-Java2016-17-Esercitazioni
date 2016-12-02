/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es05;

import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;
import it.unipa.community.robertobiondo.prg.utilities.math.MathUtils;

/**
 *
 * @author Bob
 */
public class Line {

    private Point2D p1;
    private Point2D p2;

    public Line(Point2D p1, Point2D p2) throws MyIllegalLineException {
        if (p1.equals(p2)) {
            throw new MyIllegalLineException();
        }
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point2D getP1() {
        return this.p1;
    }

    public Point2D getP2() {
        return this.p2;
    }

    public boolean containsPoint(Point2D point) {
        return this.getParameterA() * point.getX() + this.getParameterB() * point.getY() + this.getParameterC() == 0;
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
            s.append((a != 1 && (b != 0 || c != 0)) ? MathUtils.doubleFormat(a) : "").append("x ");
        }
        if (b != 0) {
            if (a != 0) {
                s.append((b > 0) ? "+ " : "- ");
            }
            s.append((b != 1 && b != -1 && (a != 0 || c != 0)) ? MathUtils.doubleFormat(Math.abs(b)) : "");
            s.append("y ");
        }
        if (c != 0) {
            s.append((c > 0) ? "+ " : "- ");
            s.append(MathUtils.doubleFormat(Math.abs(c))).append(" ");
        }
        s.append("= 0");
        return s.toString();
    }

    public void print() {
        System.out.println(this);
    }
}
