/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n05.es06;

import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;

/**
 *
 * @author Bob
 */
public class Vector2D extends Point2D {

    public Vector2D() {
        super();
    }

    public Vector2D(double x, double y) {
        super(x, y);
    }

    public double getLength() {
        return this.distanceFromOrigin();
    }

    public double getPhase() {
        return Math.atan2(this.getY(), this.getX());
    }

    public Vector2D sum(Vector2D v2) {
        return new Vector2D(this.getX() + v2.getX(), this.getY() + v2.getY());
    }

    public Vector2D sum(Vector2D... vectors) {
        Vector2D partialSum = this.clone();
        for (int i = 0; i < vectors.length; i++) {
            partialSum = partialSum.sum(vectors[i]);
        }
        return partialSum;
    }

    public Vector2D scalarMult(double scalar) {
        return new Vector2D(scalar * this.getX(), scalar * this.getY());
    }

    @Override
    public Vector2D clone() {
        return new Vector2D(this.getX(), this.getY());
    }
}
