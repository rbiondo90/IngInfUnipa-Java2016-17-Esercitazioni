package it.unipa.community.robertobiondo.prg.n03.es06;

public class Auto{
	private String scuderia;
	private Pilota pilota;
	public Auto(String scuderia, Pilota pilota){
		setScuderia(scuderia);
		setPilota(pilota);
	}
	public String dammiDettagli(){
		return pilota.getNome() + " della scuderia " + scuderia;
	}
	
	public void setScuderia(String scuderia){
		this.scuderia = scuderia;
	}
	
	public void setPilota(Pilota pilota){
		this.pilota = pilota;
	}
	
	public String getScuderia(){
		return scuderia;
	}
	
	public Pilota getPilota(){
		return pilota;
	}
}