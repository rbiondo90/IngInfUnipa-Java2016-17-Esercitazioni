package it.unipa.community.robertobiondo.prg.n01.es05;

public class TestMoneta {

    public static void main(String args[]) {
        Moneta coin = new Moneta();
        int ncroci = 0;
        int nteste = 0;
        int i;
        for (i = 0; i < 5; i++) {
            coin.Lancia();
            coin.StampaFaccia();
            if (coin.faccia == 0) {
                ncroci++;
            } else {
                nteste++;
            }
        }
        System.out.println("Numero croci: " + ncroci + "\nNumero teste: " + nteste);
    }
}

//versione del professore:
/* Moneta m = new Moneta();
int contaCroce=0;
for(int i=0;i<5;i++){
	if(m.lancia()==1){
		++contaCroce;
	}
	System.out.println(contaCroce);
}*/
