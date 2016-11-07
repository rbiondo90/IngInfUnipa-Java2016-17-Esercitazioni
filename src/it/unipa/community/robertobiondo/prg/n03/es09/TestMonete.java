package it.unipa.community.robertobiondo.prg.n03.es09;

public class TestMonete{
	public static void main(String args[]){
		Moneta mon020 = new Moneta(0.20F);
		Moneta mon001 = new Moneta(0.01F);
		Moneta mon1= new Moneta(1F);
		System.out.println(mon020.getDescrizione());
		System.out.println(mon001.getDescrizione());
		System.out.println(mon1.getDescrizione());
		PortaMonete portamonete1 = new PortaMonete(0.20F,0.01F,1F,2F,0.50F,0.02F,0.10F,0.05F);
		PortaMonete portamonete2 = new PortaMonete(0.20F,0.01F,1F,2F,0.50F,0.02F,0.10F,0.05F,5F,10F,20F);
		portamonete1.stato();
		portamonete2.stato();
		portamonete1.aggiungi(10F);
		portamonete1.stato();
		portamonete2.aggiungi(10F);
		portamonete1.aggiungi(100F);
		portamonete1.stato();
		portamonete1.preleva(1F);
		portamonete1.stato();
		portamonete1.preleva(1F);
	}
	
}