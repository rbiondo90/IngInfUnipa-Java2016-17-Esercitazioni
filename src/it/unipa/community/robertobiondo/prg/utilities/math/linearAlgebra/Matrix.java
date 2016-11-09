package it.unipa.community.robertobiondo.prg.utilities.math.linearAlgebra;

import it.unipa.community.robertobiondo.prg.utilities.math.Rational;

public class Matrix {//Classe importata da miei progetti personali per utilità nell'esercizio
    private int rows, cols;
    private double[][] matrix;

    public Matrix(int rows, int cols) {
        matrix = new double[rows][];
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < rows; i++) {
            matrix[i] = new double[cols];
        }
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(int n, double... elements) {
        this(n);
        int k = 0;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getRows() && k < elements.length; j++, k++) {
                this.setElement(elements[k], i, j);
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Matrix randMatrix(int min, int max) {
        if (min > max) {
            return null;
        }
        max += -min + 1;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                this.setElement(Math.floor(min + max * Math.random()), i, j);
            }
        }
        return this;
    }

    public void setElement(double a, int row, int col) {
        if (row < this.getRows() && col < this.getCols()) {
            this.matrix[row][col] = a;
        }
    }

    public double getElement(int row, int col) {
        if (row < this.getRows() && col < this.getCols()) {
            return this.matrix[row][col];
        } else {
            return Float.NaN;
        }
    }

    public void setRow(Vector vect, int row) {
        if (vect.getDim() == this.getCols() && row < this.getRows()) {
            this.matrix[row] = vect.getVector();
        }
    }

    public void setCol(Vector vect, int col) {
        if (vect.getDim() == this.getRows() && col < this.getCols()) {
            for (int i = 0; i < this.getRows(); i++) {
                this.setElement(vect.getElement(i), i, col);
            }
        }
    }

    public Vector getRow(int row) {
        if (row < this.getRows()) {
            return new Vector(this.matrix[row].clone());
        } else {
            return null;
        }
    }

    public Vector getCol(int col) {
        if (col < this.getCols()) {
            double c[] = new double[this.getRows()];
            for (int i = 0; i < this.getRows(); i++) {
                c[i] = this.getElement(i, col);
            }
            return new Vector(c);
        } else {
            return null;
        }
    }

    public void print() {
        for (int i = 0; i < getRows(); i++) {
            System.out.print("\n" + ((i == 0) ? "(" : " "));
            for (int j = 0; j < getCols(); j++) {
                System.out.print(this.getElement(i, j) + ((j != getCols() - 1) ? ", " : "" + ((i == getRows() - 1 && j == getCols() - 1) ? ")\n" : "")));
            }
        }
    }

    public void printRational() {
        for (int i = 0; i < getRows(); i++) {
            System.out.print("\n" + ((i == 0) ? "(" : " "));
            Rational r = new Rational();
            for (int j = 0; j < getCols(); j++) {
                System.out.print((r.toRational(this.getElement(i, j)).toString() + ((j != getCols() - 1) ? ", " : "" + ((i == getRows() - 1 && j == getCols() - 1) ? ")\n" : ""))));
            }
        }
    }

    public double determinant() {
        if (this.isSquare()) {
            if (this.getRows() == 1) {
                return this.getElement(0, 0);
            }
            double det = 0;
            if (this.getRows() == 2) {
                return (this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0]);
            } else {
                Matrix ordered = this.orderRowsForStartingZeros(-1);
                for (int i = 0; i < ordered.getCols(); i++) {
                    if (ordered.getElement(0, i) != 0) {
                        det += Math.pow(-1, i) * ordered.getElement(0, i) * (ordered.subMatrix(0, i).determinant());
                    }
                }
            }
            return det;
        } else {
            return Float.NaN;
        }
    }

    public Matrix subMatrix(int row, int column) {
        return this.subMatrixByRow(row).subMatrixByColumn(column);
    }

    public Matrix subMatrixByColumn(int column) {
        if (this.getCols() < column) {
            return new Matrix(1);
        } else {
            Matrix subMatrix = new Matrix((this.getRows()), (this.getCols() - 1));
            for (int i = 0, j = 0; i < subMatrix.getRows(); i++, j++) {
                if(j==column) j++;
                subMatrix.setCol(this.getCol(j),i);

            }
            return subMatrix;
        }
    }

    public Matrix subMatrixByRow(int row) {
        if (this.getRows() < row) {
            return new Matrix(1);
        } else {
            Matrix subMatrix = new Matrix((this.getRows() - 1), (this.getCols()));
            for (int i = 0, j = 0; i < subMatrix.getRows(); i++, j++) {
                if (j == row) {
                    j++;
                }
                for (int k = 0; k < subMatrix.getCols(); k++) {
                    subMatrix.setElement(this.getElement(j, k), i, k);
                }
            }
            return subMatrix;
        }
    }

    public Matrix transposed() {
        Matrix t = new Matrix(this.getCols(), this.getRows());
        for (int i = 0; i < t.getRows(); i++) {
            t.setCol(this.getRow(i).clone(), i);
        }
        return t;
    }

    public Matrix sum(Matrix mat2) {
        if (!this.sameDimension(mat2)) {
            return new Matrix(1);
        } else {
            Matrix s = new Matrix(this.getRows(), this.getCols());
            for (int i = 0; i < s.getRows(); i++) {
                for (int j = 0; j < s.getCols(); j++) {
                    s.setElement(this.getElement(i, j) + mat2.getElement(i, j), i, j);
                }
            }
            return s;
        }
    }

    private boolean sameDimension(Matrix mat2) {
        return (this.getRows() == mat2.getRows() && this.getCols() == mat2.getCols());
    }

    private boolean isSquare() {
        return this.getRows() == this.getCols();
    }

    public Matrix product(Matrix mat2) {
        if (this.getCols() == mat2.getRows()) {
            Matrix p = new Matrix(this.getRows(), mat2.getCols());
            for (int i = 0; i < p.getRows(); i++) {
                for (int j = 0; j < p.getCols(); j++) {
                    int element = 0;
                    for (int k = 0; k < this.getCols(); k++) {
                        element += this.getElement(i, k) * mat2.getElement(k, j);
                    }
                    p.setElement(element, i, j);
                }
            }
            return p;
        } else {
            return new Matrix(1);
        }
    }

    public Matrix identity() {
        if (this.isSquare()) {
            Matrix id = new Matrix(this.getRows());
            for (int i = 0; i < id.getRows(); i++) {
                for (int j = 0; j < this.getCols(); j++) {
                    id.setElement((i == j) ? 1 : 0, i, j);
                }
            }
            return id;
        } else {
            return null;
        }
    }

    @Override
    public Matrix clone() {
        Matrix dup = new Matrix(this.getRows(), this.getCols());
        for (int i = 0; i < dup.getRows(); i++) {
            dup.setRow(this.getRow(i), i);
        }
        return dup;
    }

    public Matrix lambdaRow(double lambda, int row) {
        if (row < this.getRows()) {
            Matrix l = this.clone();
            l.setRow(l.getRow(row).lambdaVector(lambda), row);
            return l;
        } else {
            return new Matrix(1);
        }
    }

    public Matrix lambdaColumn(double lambda, int column) {
        if (column - 1 <= this.getCols()) {
            column -= 1;
            Matrix l = this.clone();
            for (int i = 0; i < this.getRows(); i++) {
                l.setElement(lambda * this.getElement(i, column), i, column);
            }
            return l;
        } else {
            return new Matrix(1);
        }
    }

    public Matrix lambdaProduct(double lambda) {
        Matrix l = this.clone();
        for (int i = 0; i < l.getRows(); i++) {
            l = l.lambdaRow(lambda, i);
        }
        return l;
    }

    public boolean equals(Matrix mat2) {
        if (!this.sameDimension(mat2)) {
            return false;
        } else {
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getCols(); j++) {
                    if (this.getElement(i, j) != mat2.getElement(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public boolean isSymmetric() {
        return this.isSquare() && this.equals(this.transposed());
    }

    public boolean isAntiSymmetric() {
        return this.isSquare() && this.equals(this.transposed().lambdaProduct(-1));
    }

    public boolean isUpperTriangular() {
        if (!this.isSquare()) {
            return false;
        }
        for (int i = 1; i < this.getRows(); i++) {
            for (int j = 0; j < i; j++) {
                if (this.getElement(i, j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isLowerTriangular() {
        if (!this.isSquare()) {
            return false;
        }
        for (int i = 0; i < this.getRows() - 1; i++) {
            for (int j = i + 1; j < this.getCols(); j++) {
                if (this.getElement(i, j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDiagonal() {
        return (this.isUpperTriangular() && this.isLowerTriangular());
    }

    public boolean isEchelon() {
        int pivot = -1;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols() && i < this.getRows(); j++) {
                if (this.getElement(i, j) != 0) {
                    if (j <= pivot) {
                        return false;
                    }
                    pivot = j;
                    i++;
                    j = -1;
                }
            }
        }
        return true;
    }

    public Matrix rowSwap(int row1, int row2) {
        if (this.getRows() <= row1 || this.getRows() <= row2) {
            return null;
        }
        Matrix swapped = this.clone();
        swapped.setRow(this.getRow(row1), row2);
        swapped.setRow(this.getRow(row2), row1);
        return swapped;
    }

    public Matrix colSwap(int col1, int col2) {
        if (this.getCols() <= col1 || this.getCols() <= col2) {
            return null;
        }
        Matrix swapped = this.clone();
        swapped.setCol(this.getCol(col1), col2);
        swapped.setCol(this.getCol(col2), col1);
        return swapped;
    }

    public int startingZerosInRow(int row) {
        if (this.getRows() <= row) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < this.getCols(); i++) {
            if (this.getElement(row, i) == 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private Matrix orderRowsForStartingZeros(int orderModifier) { //0 per ordine crescente, -1 per ordine decrescente
        orderModifier = (orderModifier != 0 && orderModifier != -1) ? 0 : orderModifier;
        Matrix o = this.clone();
        boolean ordered;
        do {
            ordered = true;
            for (int i = 0; i < this.getRows() - 1; i++) {
                if (orderModifier == 0) {
                    if (o.startingZerosInRow(i) > o.startingZerosInRow(i + 1)) {
                        o = o.rowSwap(i, i + 1);
                        ordered = false;
                    }
                } else if (o.startingZerosInRow(i) < o.startingZerosInRow(i + 1)) {
                    o = o.rowSwap(i, i + 1);
                    ordered = false;
                }
            }
        } while (!ordered);
        return o;
    }

    private Matrix orderRowsForStartingZeros() {
        return this.orderRowsForStartingZeros(0);
    }

    public Matrix gaussianElimination() {
        if (this.isEchelon()) {
            return this;
        }
        Matrix gaussMat = this.clone();
        int s1, s2;
        double lambda;
        gaussMat = gaussMat.orderRowsForStartingZeros();
        while (!gaussMat.isEchelon()) {
            for (int i = 0; i < this.getRows() - 1; i++) {
                s1 = gaussMat.startingZerosInRow(i);
                s2 = gaussMat.startingZerosInRow(i + 1);
                if (s1 == s2) {
                    lambda = gaussMat.getElement(i, s1) / gaussMat.getElement(i + 1, s1);
                    Vector rowToInsert = gaussMat.getRow(i + 1).lambdaVector(-lambda).sum(gaussMat.getRow(i));
                    gaussMat.setRow(rowToInsert, i);
                }
            }
            gaussMat = gaussMat.orderRowsForStartingZeros();
        }
        return gaussMat;
    }

    public int rank() {
        Matrix gaussReduced = this.gaussianElimination();
        int rank = 0;
        for (int i = 0; i < this.getRows(); i++) {
            if (gaussReduced.startingZerosInRow(i) != gaussReduced.getCols()) {
                rank++;
            }
        }
        return rank;
    }

    public double cofactor(int row, int column) {
        double c = (this.isSquare()) ? (Math.pow(-1, (row + column)) * this.subMatrix(row, column).determinant()) : Float.NaN;
        return c;
    }

    public Matrix adjugate() {
        Matrix a = new Matrix(this.getRows());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                a.setElement(this.cofactor(i, j), i, j);
                if (a.getElement(i, j) == -0.0) {
                    a.setElement(0, i, j);
                }
            }
        }
        return a.transposed();
    }

    public Matrix inverse() {
        double d = this.determinant();
        if (d != 0) {
            return this.adjugate().lambdaProduct(1 / this.determinant());
        } else {
            return new Matrix(0);
        }
    }
}
