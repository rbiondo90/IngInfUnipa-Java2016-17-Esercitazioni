package it.unipa.community.robertobiondo.prg.n03.es04;

public class Ese04{
	public static void main(String args[]){
		int i = 5;
		int j = ++i; //j = i = 6
		int k = j++; // k = 6, i = 7
		int h = k--; //h = 6, k = 5
		boolean flag = ((i != j) && ((j <= k) || (i <= h)));
		//i!=j � vero perch� i = 7, j = 6
		//j<=k � falso perch� j = 6 e k =5, per� i<=h perch� i=h=6
		// quindi l'espressione completa � vera
		System.out.println(flag);
	}
}