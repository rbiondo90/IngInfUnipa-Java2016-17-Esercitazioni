package it.unipa.community.robertobiondo.prg.n04.es02;
import it.unipa.community.robertobiondo.prg.n03.es08.Razionale;

public class Complex{
	private double parteReale;
	private double parteImmaginaria;
        
        public Complex(double parteReale, double parteImmaginaria){
            this.setParteReale(parteReale);
            this.setParteImmaginaria(parteImmaginaria);
        }
        
        public Complex(){
            this(0,0);
        }
        
        public Complex(double parteReale){
            this(parteReale,0);
        }
	
	public void setParteReale(double parteReale){
            this.parteReale=parteReale;
	}
        
        public void setParteImmaginaria(double parteImmaginaria){
            this.parteImmaginaria=parteImmaginaria;
        }
        
        public double getParteReale(){
            return this.parteReale;
        }
        
        public double getParteImmaginaria(){
            return this.parteImmaginaria;
        }
        
        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            if(this.getParteReale()!=0) {
                s.append(this.getParteReale());
                s.append((this.getParteImmaginaria()>0)? " + ":"");
            }
            if(this.getParteImmaginaria()!=0){
                s.append((this.getParteImmaginaria()<0)?" - ":"");
                s.append("i").append(Math.abs(this.getParteImmaginaria()));
            }
            if(this.getParteImmaginaria()==0 && this.getParteReale()==0) s.append("0");
            return s.toString();
        }
        
        public String toStringFormaRazionale(){
            StringBuilder s = new StringBuilder();
            Razionale r = new Razionale();
            if(this.getParteReale()!=0) {
                s.append(r.convertiInRazionale(this.getParteReale()));
                s.append((this.getParteImmaginaria()>0)? " + ":"");
            }
            if(this.getParteImmaginaria()!=0){
                s.append((this.getParteImmaginaria()<0)?" - ":"");
                s.append("i").append(r.convertiInRazionale(this.getParteImmaginaria()).valoreAssoluto());
            }
            if(this.getParteImmaginaria()==0 && this.getParteReale()==0) s.append("0");
            return s.toString();
        }
        
        public void stampa(){
            System.out.println(this.toString());
        }
        
        public void stampaInFormaRazionale(){
            System.out.println(this.toStringFormaRazionale());
        }
        
        public static void stampa(Complex c){
            c.stampa();
        }
        
        
        public static Complex somma(Complex c1, Complex c2){
            return c1.somma(c2);
        }
        
        public Complex somma(Complex c2){
            return new Complex(this.getParteReale()+c2.getParteReale(),this.getParteImmaginaria()+c2.getParteImmaginaria());      
        }
        
        private Complex opposto(){
            return new Complex(-this.getParteReale(),-this.getParteImmaginaria());
        }
        
        public Complex sottrazione(Complex c2){
            return this.somma(c2.opposto());
        }
        
        public static Complex sottrazione(Complex c1, Complex c2){
            return c1.sottrazione(c2);
        }
    }