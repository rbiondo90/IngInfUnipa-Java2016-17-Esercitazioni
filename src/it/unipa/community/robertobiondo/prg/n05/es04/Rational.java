package it.unipa.community.robertobiondo.prg.n05.es04;

import it.unipa.community.robertobiondo.prg.utilities.math.MathUtils;

public class Rational extends Number{//Classe importata da miei progetti personali per utilità nell'esercizio
	private long numerator, denominator;
	private boolean validity = true;
	
	public Rational (){
            this(0,1L);
	}
        
        public Rational(double r){
            String s = String.valueOf(Math.abs(r));
            long digitsDec = s.length() - 1 - s.indexOf('.');
            long denom=1;
            for(long i=0;i<digitsDec;i++){
                r*=10;
                denom*=10;
            }
            long numer = (long) Math.round(r);
            if(r<0) numer*=-1;
            this.setNumerator(numer);
            this.setDenominator(denom);
            this.reduce();
        }
	
	public Rational(long numerator, long denominator){
			setNumerator(numerator);
			setDenominator(denominator);
                        this.reduce();
	}
	
        public Rational (String s){
            long n, d;
            n=d=1;
            s=s.trim();
            if(s.contains("/")){
		String splitted[] = s.split("/");
		for(String i : splitted){
                    i= i.trim();
                    }
		n=Integer.parseInt(splitted[0]);
		d=Integer.parseInt(splitted[1]);
		this.setNumerator(n);
		this.setDenominator(d);
		this.reduce();
            }
            else {
		n=Integer.parseInt(s);
		this.setNumerator(n);
		this.setDenominator(1);
            }
	}
        
        @Override
        public Rational clone(){
            return new Rational(this.getNumerator(),this.getDenominator());
        }
        
        public boolean equals(Rational r2){
            return this.getNumerator()==r2.getNumerator() && this.getDenominator()==r2.getDenominator();
        }
        
        public Rational toRational(double r){
            Rational f = new Rational(r);
            return f;
        }
                
	public void setNumerator(long numerator){
		this.numerator = numerator;
	}

	public void setDenominator(long denominator){
		if(denominator==0) this.setValidity(false);
		else {
			this.setValidity(true);
			if(denominator<0){
				this.denominator=-denominator;
				this.setNumerator(-this.getNumerator());
			}
			else{
				this.denominator=denominator;
			}
		}
	}
	
	public long getNumerator(){
		return numerator;
	}
	
	public long getDenominator(){
		if(this.getValidity()){
			return denominator;
		}
		else {
			return -1;
		}
	}
	
	public boolean getValidity(){
		return this.validity;
	}
	
	private void setValidity(boolean validity){
		this.validity = validity;
	}
	
	public void reduce(){
		if(this.getValidity()){
			long gcd = MathUtils.GCD(getNumerator(),getDenominator());
			setNumerator(getNumerator()/gcd);
			setDenominator(getDenominator()/gcd);
		}
	}
	
	public String toString(){
//le doppie virgolette nell'assegnazione false dell'operatore ternario sono state aggiunte perch�  senza il compilatore restituiva un errore del tipo "impossibile convertire long in stringa"
		return ((this.getValidity())? ((getNumerator()!= 0 && Math.abs(getDenominator())!=1)? (getNumerator() + "/" + getDenominator()) : (getNumerator() + "")): "NaN"); 
	}
	
	public void print(){
		System.out.println(this.toString());
	}
	
	public Rational sum(Rational f2){
		if (this.getValidity() && f2.getValidity()){
			Rational s = new Rational(1,MathUtils.lcm(this.getDenominator(),f2.getDenominator()));
			s.setNumerator(((s.getDenominator() / this.getDenominator()) *  this.getNumerator()) + ((s.getDenominator() / f2.getDenominator()) * f2.getNumerator()));
			s.reduce();
			return s;
		}
		else return null;
	}
	
	public Rational opposite(){
		if(this.getValidity()){
			Rational opp = new Rational(-this.getNumerator(),this.getDenominator());
			return opp;
		}
		return null;
	}
	
	public Rational subtract(Rational f2){
		return this.sum(f2.opposite());
	}
	
	public Rational multiply(Rational f2){
		if(this.getValidity() && f2.getValidity()){
			Rational m = new Rational((this.getNumerator() * f2.getNumerator()), (this.getDenominator() * f2.getDenominator()));
			m.reduce();
			return m;
		}
		else return null;
	}
	
	public Rational inverse(){
		Rational inv;
		if (this.getNumerator()!=0){
			inv = new Rational(this.getDenominator(),this.getNumerator());
			return inv;
		}
		else return null;
	}
	
	public Rational divide(Rational f2){
		return this.multiply(f2.inverse());
	}
	
	
	public double toDouble(){
		return ((double)numerator/(double)denominator);
	}

    @Override
    public int intValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long longValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float floatValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double doubleValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}