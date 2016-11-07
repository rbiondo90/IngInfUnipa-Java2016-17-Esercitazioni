package it.unipa.community.robertobiondo.prg.n03.es07;

import java.util.Random;

public class Punto{
	private double x, y;
	
	public Punto(double x, double y){
		setX(x);
		setY(y);
	}
	
	public Punto(){
		setX(0.0);
		setY(0.0);
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double distanzaDa(Punto p){
		return Math.sqrt(Math.pow((this.x - p.x),2) + Math.pow((this.y - p.y),2));
	}
	
	public Punto puntoMedio(Punto p){
		return new Punto((this.x + p.x)/2,((this.y + p.y)/2));
	}
	
	/**Assegna dei valori casuali compresi tra 0 e mult ai punti x e y*/
	public void randPunto(int mult) {
		Random r = new Random();
		this.setX((double)mult * r.nextDouble());
		this.setY((double)mult * r.nextDouble());
	}
	
	public String toString(){
		return ("( " + getX() + " , " + getY() + " )");
	}
}