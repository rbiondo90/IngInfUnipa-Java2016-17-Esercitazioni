package it.unipa.community.robertobiondo.prg.n02.es03;

public class Test {

    public static void main(String args[]) {
        /* Il seguente frammento di codice non produce errori in compilazione:
		int arr[] = new int[2];
		byte a = 1, b = 2;
		arr[0] = a;
		arr[1] = b;*/

 /* Nemmeno questo:
		char a = 'a', b = 'b';
		int arr[] = {a,b};*/
 /*Il seguente frammento genera un errore, perch� non � possibile
		assegnare dei singoli char a un array di stringhe:
		String String arr[]={'a','b'};*/
        // Questo � ok: String arr[] = {"a","b"};
        /*ok:
		int arr[][] = {
		{1, 2, 3},
		{1, 2},
		{1, 2, 3, 4, 5}
		};
         */
    }
}
