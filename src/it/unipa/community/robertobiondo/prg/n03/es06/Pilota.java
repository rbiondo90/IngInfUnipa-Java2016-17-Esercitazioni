package it.unipa.community.robertobiondo.prg.n03.es06;

public class Pilota{
	private String nome;
	public Pilota(String nome){
		setNome(nome);
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
}