package it.unipa.community.robertobiondo.prg.n05.es06;

import java.util.Random; //Importo la classe per utilizzare oggetti random

public class Ruota{
	Random rand = new Random();
	private double pressione;
	private double coeffPressione;
        
	public Ruota(){
		pressione=100;
		coeffPressione = rand.nextDouble(); //il coefficiente di riduzione della pressione viene generato casualmente tra 0 e 1
	}
        
        public void setPressione(double pressione){
            this.pressione=pressione;
        }
        
        public double getPressione(){
            return this.pressione;
        }
        
        public double getCoeffPressione(){
            return this.coeffPressione;
        }
}