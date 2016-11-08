package it.unipa.community.robertobiondo.prg.n01.es06;

public class FidelityCard{
	public String nomecliente;
	public int punti;
	public final float VALORE_PUNTO = 10;
	public FidelityCard(String nome){
		//metodo costruttore per inizializzare la fidelity card di un nuovo cliente, di cui il nome viene passato come parametro
		nomecliente=nome;
		punti=0;
	}
	public void AccumulaPunti(float spesa){
		punti += spesa/VALORE_PUNTO; //1 punto ogni 10 � di spesa
		System.out.println("Sono stati guadagnati " + (int)(spesa/VALORE_PUNTO) + " punti.\nCard aggiornata:\n");
		StampaCard();
	}//accresce i punti sulla card di un cliente, sulla base della spesa fatta e del valore di ogni punto
	//poi stampa lo stato della card
	public void SpendiPunti(int x){
		if(x>punti) System.out.println("Non hai abbastanza punti.");
		else {
			punti -= x;
			System.out.println("Sono stati spesi " + x + " punti.\nCard aggiornata:\n");
			StampaCard();
		}
	}
	public void StampaCard(){
		System.out.println("Fidelity Card di " + nomecliente + "\nSaldo punti: " + punti+"\n");
	}
}
//versione del professore
/* public class CartaFedeltà{
	public int saldo;
	public int final VALORE_PUNTO=10;
	
	public void AccumulaPunti(int spesa){
		saldo = saldo + spesa/VALORE_PUNTO;
	}
	public void UtilizzaPunti(int punti){
		if(punti<=saldo){
			saldo -= punti;
			System.out.println("Punti utilizzati");
		}
		else{
			System.out.println("Non hai abbastanza punti.");
		}
	}
	public void Stampa(){
		System.out.println("Saldo: " +  saldo);
	}
}*/