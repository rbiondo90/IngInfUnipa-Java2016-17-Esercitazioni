package it.unipa.community.robertobiondo.prg.n04.es03;
import java.util.Scanner;
/**
 *
 * @author Bob
 */
public class Main {
    public static void main(String args[]){
        Stack stack = new Stack();
        Scanner keyboard = new Scanner(System.in);
        int scelta;
        char c;
        do{
            System.out.println("Scegliere un'opzione:\n"
                    + "0 - Esci dal programma\n"
                    + "1 - Inserisci un carattere dallo stack\n"
                    + "2 - Estrai un carattere dallo stack");
            scelta = Integer.parseInt(keyboard.nextLine());
            switch (scelta){
                case 1:
                    System.out.println("Digita il carattere da inserire nello stack: ");
                    c=(keyboard.nextLine().charAt(0));
                    stack.push(c);
                    break;
                case 2:
                    stack.pop();
                    break;
            }    
        }while(scelta!=0);
    }
}
