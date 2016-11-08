
package it.unipa.community.robertobiondo.prg.n04.es05;

import it.unipa.community.robertobiondo.prg.n04.es04.Date;

/**
 *
 * @author Bob
 */
public class Studente {
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private Date dataDiImmatricolazione;
    private int matricola;
    
    private static int contatoreMatricola=1;
    
    public Studente(String nome,String cognome,Date dataDiNascita,Date dataDiImmatricolazione){
        this.setDataDiNascita(dataDiNascita);
        if(this.setDataDiImmatricolazione(dataDiImmatricolazione)){
            this.setNome(nome);
            this.setCognome(cognome);
            this.setMatricola();    
        }
        else{
            this.setNome("");
            this.setCognome("");
            this.setDataDiNascita(null);
            }
    }
    
    public Studente(String nome, String cognome, String dataDiNascita, String dataDiImmatricolazione){
        this(nome,cognome,new Date(dataDiNascita),new Date(dataDiImmatricolazione));
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Date getDataDiImmatricolazione() {
        return dataDiImmatricolazione;
    }

    public boolean setDataDiImmatricolazione(Date dataDiImmatricolazione) {
        if(dataDiImmatricolazione.anniPassati(this.dataDiNascita)>18){
            this.dataDiImmatricolazione = dataDiImmatricolazione;
            return true;
        }
        else {
            System.out.println("Impossibile immatricolare uno studente minorenne");
            return false;
        }
    }

    public int getMatricola() {
        return this.matricola;
    }

    private void setMatricola() {
        this.matricola = contatoreMatricola++;
    }
    
    private void stampaDettagli(){
        System.out.println("Nome studente: " + this.getNome() + " " + this.getCognome());
        System.out.println("Nato il " + this.getDataDiNascita());
        System.out.println("Immatricolato il " + this.getDataDiImmatricolazione());
        System.out.println("Numero di matricola: " + String.format("%04d",this.getMatricola()));
    }
    
    public static void main(String args[]){
        Studente a = new Studente("Mario","Bruno","10/12/1992","10/10/2015");
        a.stampaDettagli();
        Studente b = new Studente("Pino","Scotto","10/10/2000","10/10/2016");
        b.stampaDettagli();
    }
}
