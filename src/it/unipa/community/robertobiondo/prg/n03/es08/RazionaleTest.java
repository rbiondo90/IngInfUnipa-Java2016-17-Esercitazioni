package it.unipa.community.robertobiondo.prg.n03.es08;
import java.util.Scanner;

public class RazionaleTest{
	public static void main(String args[]){
		Scanner keyboard = new Scanner(System.in);
		String buffer;
		Razionale f1, f2;
		do{
			System.out.print("Inserire la prima frazione: ");
			f1 = new Razionale(buffer = keyboard.nextLine());
		}
		while (!f1.getValidity());
		
		do{
			System.out.print("Inserire la seconda frazione: ");
			f2 = new Razionale(buffer = keyboard.nextLine());
		}
		while (!f2.getValidity());
		System.out.println("Frazione 1: " + f1.toString() + " = " + f1.toDouble() + "\nFrazione 2: " + f2.toString()+ " = " + f2.toDouble());
		
		System.out.println(f1.toString() + " + " + f2.toString() + " = " + f1.somma(f2).toString());
		System.out.println(f1.toString() + " - " + f2.toString() + " = " + f1.sottrai(f2).toString());
		System.out.println(f1.toString() + " * " + f2.toString() + " = " + f1.moltiplica(f2).toString());
		System.out.println(f1.toString() + " / " + f2.toString() + " = " + f1.dividi(f2).toString());
                System.out.println("f1 = " + f1 + " f2 = "+f2 + "f1.compareTo(f2) = "+ f1.compareTo(f2));
	}
}