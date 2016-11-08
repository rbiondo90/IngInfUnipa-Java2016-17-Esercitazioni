import java.util.Random;

public class Matematica{
	Random rand = new Random();
	
	public int[] generaVettore(int L){
		int vettore [] = new int[L];
		for (int i = 0;i<L;i++){
			vettore[i]=rand.nextInt(100);
		}
		return vettore;
	}
	
	public int[][] generaMatrice(int R, int C){
		int matrix [][] = new int[R][];
		for (int i = 0;i<R;i++){
			matrix [i] = new int[C];
			for (int j=0;j<C;j++){
				matrix[i][j]=rand.nextInt(100);			
			}
		}
		return matrix;
	}
	
	public int[] sommaVettori (int[] a, int[] b){
		//l'array viene inizializzato a null per evitare errori in fase di compilazione
		//e per restituire al chiamante un indicatore di procedura non andata a buon fine
		int somma[] = null;
		if(a.length == b.length){
			somma = new int[a.length];
			for(int i=0; i<somma.length; i++){
				somma[i]=a[i] + b[i];
			}
		}
		if(somma==null) System.out.println("\nsommaVettori: Errore! Vettori di dimensioni differenti!");
		return somma;
	}
	
	public int[][] sommaMatrici (int[][] a, int[][] b){
		int somma[][] = null;
		boolean chk = true;
		if(a.length==b.length){
			for(int i=0;i<a.length && chk == true;i++){
				if(a[i].length!=b[i].length) chk = false;
			}
		}
		else chk = false;
		if (chk){
			somma=new int[a.length][];
			for(int i=0;i<somma.length;i++){
				somma[i]=new int[a[i].length];
				for(int j=0;j<somma[i].length;j++){
					somma[i][j]=a[i][j]+b[i][j];
				}
			}
		}
		else {
			System.out.println("\nsommaMatrici: Errore! Matrici di dimensioni differenti!");
		}
		return somma;
	}

	public void stampaVettore(int vettore[]){
		if(vettore!= null){
			for(int i = 0; i < vettore.length; i++){
				if (i==0) {
					System.out.print("\n( " + vettore[0] + " , ");
				}
				else if (i==vettore.length - 1) {
					System.out.print(vettore[i] + " )");
				}
				else System.out.print(vettore[i] + " , ");
			}
		}
	}

	public void stampaMatrice(int matrix [][]){
		if(matrix!=null){
			for(int i=0;i<matrix.length;i++){
				if (i==0) System.out.print("\n[ ");
				else System.out.print("\n  ");
				for(int j=0;j<matrix[i].length;j++){
					System.out.print(matrix[i][j]);
					if(j!=(matrix[i].length - 1)) System.out.print(", ");
				}
			}
			System.out.print("]\n");
		}
	}
}