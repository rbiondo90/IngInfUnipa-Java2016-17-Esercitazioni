package it.unipa.community.robertobiondo.prg.n01.es06;

public class Clienti {

    public static void main(String args[]) {
        FidelityCard cliente1 = new FidelityCard("Mario Rossi");
        FidelityCard cliente2 = new FidelityCard("Luigi Verdi");
        cliente1.AccumulaPunti(150);
        cliente2.AccumulaPunti(300);
        cliente1.AccumulaPunti(1500);
        cliente1.SpendiPunti(100);
        cliente2.SpendiPunti(50);
    }
}

//versione del professore
/* public static void main(String args[]){
	CartaFedeltà c1, c2;
	c1=new CartaFedeltà();
	c2=new CartaFedeltà();
	c1.AccumulaPunti(150);
	c1.stampa();
	
	c2.AccumulaPunti(300);
	c2.stampa();
	
	c1.AccumulaPunti(1500);
	c1.stampa();
	
	c1.UtilizzaPunti(100);
	c1.stampa();
	
	c2.UtilizzaPunti(50);
	c2.stampa();
}*/
