/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es03;

import it.unipa.community.robertobiondo.prg.n05.es03.Point2D;

/**
 *
 * @author Roberto Biondo
 */
public class ROI {

    private Point2D topLeft;
    private Point2D bottomRight;

    public ROI(Point2D topLeft, Point2D bottomRight) {
        this.setTopLeft(topLeft);
        this.setBottomRight(bottomRight);
    }

    public void setTopLeft(Point2D topLeft) {
        this.topLeft = topLeft.clone();
    }

    public void setBottomRight(Point2D bottomRight) {
        this.bottomRight = bottomRight.clone();
    }

    public int getWidth() {
        return (int) (bottomRight.getX() - topLeft.getX());
    }

    public int getHeight() {
        return (int) (bottomRight.getY() - topLeft.getY());
    }

    public int getTopY() {
        return (int) this.topLeft.getY();
    }

    public int getBottomY() {
        return (int) this.bottomRight.getY();
    }

    public int getLeftX() {
        return (int) this.topLeft.getX();
    }

    public int getRightX() {
        return (int) this.bottomRight.getX();
    }

    public boolean isValid() {
        return (this.getWidth() > 0 && this.getHeight() > 0);
    }
}
