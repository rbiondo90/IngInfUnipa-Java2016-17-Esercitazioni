package it.unipa.community.robertobiondo.prg.n03.es07;

public class TestPunto{
	public static void main(String args[]){
		Punto p1 = new Punto();
		Punto p2 = new Punto();
		p1.randPunto(100);
		p2.randPunto(100);
		System.out.println("p1 = " + p1.toString() + "\np2 = " + p2.toString());
		System.out.println("Distanza di p1 da p2: " + p1.distanzaDa(p2));
		System.out.println("Punto medio tra p1 e p2 : " + p1.puntoMedio(p2).toString());
	}
}