/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n08.es03;

import robertobiondo.utilities.Utils;
import java.util.Random;

/**
 *
 * @author Roberto Biondo
 */
public class Image {

    private final int R;
    private final int C;
    private int[][] data;

    public Image(int R, int C, int[][] data) throws IllegalArgumentException {
        if (R > 0 && C > 0) {
            this.R = R;
            this.C = C;
            this.setData(data);
        } else {
            throw new IllegalArgumentException("Image's dimensions must be positive!");
        }

    }

    public Image(int R, int C) throws IllegalArgumentException{
        this(R, C, new int[R][C]);
        this.fillWithRandomValues();
    }

    public int getR() {
        return this.R;
    }

    public int getC() {
        return this.C;
    }

    private void setData(int[][] data) {
        if (data.length == this.getR() && data[0].length == this.getC() && Utils.isMatrix(data)) {
            this.data = new int[this.getR()][this.getC()];
            for (int row = 0; row < this.getR(); row++) {
                System.arraycopy(data[row], 0, this.data[row], 0, this.getC());
            }
        }
    }

    private void fillWithRandomValues() {
        Random rand = new Random();
        for (int row = 0; row < this.getR(); row++) {
            for (int column = 0; column < this.getC(); column++) {
                this.data[row][column] = rand.nextInt(256);
            }
        }
    }

    public Image getROIImage(ROI roi) throws IllegalArgumentException{
        if (!roi.isValid() || roi.getBottomY() > this.getR() || roi.getRightX() > this.getC()
                || roi.getHeight() > this.getR() || roi.getWidth() > this.getC()) {
            throw new IllegalArgumentException("Invalid ROI!");
        } else {
            int[][] ROIdata = new int[roi.getHeight()][roi.getWidth()];
            for (int ROIrow = 0; ROIrow < roi.getHeight(); ROIrow++) {
                for (int ROIcol = 0; ROIcol < roi.getWidth(); ROIcol++) {
                    ROIdata[ROIrow][ROIcol] = this.data[ROIrow + roi.getTopY()][ROIcol + roi.getLeftX()];
                }
            }
            return new Image(roi.getHeight(), roi.getWidth(), ROIdata);
        }
    }

    @Override
    public Image clone() {
        Image clone = new Image(this.getR(), this.getC());
        clone.setData(this.data);
        return clone;
    }

    public void print() {
        for (int i = 0; i < getR(); i++) {
            System.out.print("\n" + ((i == 0) ? "(" : " "));
            for (int j = 0; j < getC(); j++) {
                System.out.print(this.data[i][j] + ((j != getC() - 1) ? ", " : "" + ((i == getR() - 1 && j == getC() - 1) ? ")\n" : "")));
            }
        }
    }
}
