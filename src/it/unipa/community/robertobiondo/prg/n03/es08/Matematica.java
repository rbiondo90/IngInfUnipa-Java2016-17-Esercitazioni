package it.unipa.community.robertobiondo.prg.n03.es08;

public class Matematica{
	public static int MCD(int a, int b){
		if (a==0 || b == 0) return 1;
		int min = minimo(Math.abs(a),Math.abs(b));
		int max = massimo(Math.abs(a),Math.abs(b));
		int resto = max % min;
		if (resto==0) return min;
		else return MCD (min, resto);
	}

	public static int mcm(int a, int b){
		return Math.abs((a * b)/MCD(a,b));
	}
	
	public static int massimo(int a, int b){
		if (a<b) return b;
		else return a;
	}
	
	public static int minimo (int a, int b){
		if (a<b) return a;
		else return b;
	}
}