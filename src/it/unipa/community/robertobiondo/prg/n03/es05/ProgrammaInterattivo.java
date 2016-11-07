package it.unipa.community.robertobiondo.prg.n03.es05;

import java.util.Scanner;

public class ProgrammaInterattivo{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		String stringa = "";
		System.out.println("Digita qualcosa e batti enter, oppure " + "scrivi \"fine\" per terminare il programma");
		//nel comando successivo ho usato il metodo nextLine() invece che next() perchè il secondo utilizzava come terminatore di default lo spazio
		//quindi stampava una stringa separata per ogni spazio digitato
		while(!(stringa = scanner.nextLine()).equals("fine")){
			if(stringa.equals("censura") || stringa.equals("censor")) {
				System.out.println("Hai digitato una parola censurata!");
			}
			else {
				System.out.println("Hai digitato " + stringa.toUpperCase() + "!");
			}
		}
		System.out.println("Fine programma!");
	}
}