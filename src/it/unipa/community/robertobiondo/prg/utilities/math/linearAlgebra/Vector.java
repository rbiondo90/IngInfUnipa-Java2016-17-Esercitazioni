/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robertobiondo.utilities.math.linearAlgebra;

/**
 *
 * @author Bob
 */
public class Vector {//Classe importata da miei progetti personali per utilità nell'esercizio
    private double[] vector;
    private int dim;
    
    public Vector(int dim){
        this.vector= new double[dim];
        this.setDim(dim);
    }
    
    public Vector(double... elements){
        this.setDim(elements.length);
        this.vector=new double[this.getDim()];
        for(int i=0;i<elements.length;i++){
            this.setElement(elements[i],i);
        }
    }
    
    private void setDim(int dim){
        this.dim=dim;
    }
   
    public int getDim(){
        return this.dim;
    }
    
    public void setElement(double element, int position){
        if(position<this.dim){
            this.vector[position] = element;
        }
    }
    
    public double getElement(int position){
        if(position<this.dim){
            return this.vector[position];
        }
        else return Float.NaN;
    }
    
    public double[] getVector(){
        return this.clone().vector;
    }
    
    public Vector rand(int min, int max){
        max+= -min + 1;
	for(int i=0;i<this.getDim();i++){
            this.setElement(Math.floor(min + max*Math.random()),i);
        }

        return this;
    }
        
    public Vector clone(){
        Vector c = new Vector(this.getDim());
        for (int i=0;i<c.getDim();i++){
            c.setElement(this.getElement(i),i);
        }
        return c;
    }
    
    public Vector sum(Vector v2){
        Vector s=null;
        if(this.dim==v2.dim){
            s=new Vector(this.dim);
            for(int i=0;i<s.dim;i++){
                s.setElement(this.getElement(i)+v2.getElement(i), i);
            }
        }
        return s;
    }
    
    public Vector difference(Vector v2){
        return this.sum(v2.lambdaVector(-1));
    }
    
    public Vector lambdaVector(double lambda){
        Vector lv= this.clone();
        for(int i=0;i<lv.getDim();i++){
            lv.setElement(lambda * this.getElement(i), i);
        }
        return lv;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<this.getDim();i++){
            if(i==0) str.append("( ");
            str.append(this.getElement(i));
            if(i!=this.getDim()-1) str.append(" , ");
            else str.append(" )");
        }
        return str.toString();
    }
    
    public void print(){
        System.out.println(this.toString());
    }
    
    public boolean equals(Vector vector2){
        if(this.getDim()==vector2.getDim()){
            boolean flag=true;
            for(int i=0;i<this.getDim();i++){
                if(this.getElement(i)!=vector2.getElement(i)) break;
            }
            return flag;
        }
        else return false;
    }
    
    public double scalarProduct(Vector vector2){
        if(this.getDim()!=vector2.getDim()) return Float.NaN;
        double s=0;
        for(int i=0;i<this.getDim();i++){
            s+= this.getElement(i)*vector2.getElement(i);
        }
        return s;
    }
    
    public static double scalarProduct(Vector vector1, Vector vector2){
        return vector1.scalarProduct(vector2);
    }
    
    public double length(){
        double l=0;
        for(int i=0;i<this.getDim();i++){
            l+=Math.pow(this.getElement(i),2);
        }
        return Math.sqrt(l);
    }
    
    public Vector versor(){
        Vector u = this.clone();
        for(int i=0;i<this.getDim();i++){
            u.setElement(this.getElement(i)/this.length(),i);
        }
        return u;
    }
    public Matrix toMatrix(String format){
        Matrix m;
        if(format.equals("column")){
            m = new Matrix(this.getDim(),1);
            m.setCol(this, 0);
        }
        else if(format.equals("row")){
            m = new Matrix(1,this.getDim());
            m.setRow(this,0);
        }
        else if(format.equals("diagonal")){
            m = new Matrix(this.getDim());
            for(int i=0;i<m.getRows();i++){
                m.setElement(this.getElement(i),i,i);
            }
        }
        else {
            m = new Matrix(1);
        }
        return m;
    }
    
    
    public Matrix toMatrix(){
        return this.toMatrix("column");
    }
    
    public static boolean linearIndependence(Vector... vectors){
        for(int i=0;i<vectors.length-1;i++){
            for(int j=i+1;j<vectors.length;j++){
                if(vectors[i].getDim()!=vectors[j].getDim()){
                    return false;
                }
            }
        }
        if(vectors.length>vectors[0].getDim()){
            return false;
        }
        Matrix vectorMatrix = new Matrix(vectors.length,vectors[0].getDim());
        for(int i = 0;i<vectorMatrix.getRows();i++){
            vectorMatrix.setRow(vectors[i],i);
        }
        return vectorMatrix.rank()==vectors.length;
    }
}
