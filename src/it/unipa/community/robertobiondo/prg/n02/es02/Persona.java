package it.unipa.community.robertobiondo.prg.n02.es02;

/**
 * Classe contenente le generalità di una persona
 */
public class Persona {

    /**
     * Nome della persona in formato stringa
     */
    public String nome;
    /**
     * Cognome della persona in formato stringa
     */
    public String cognome;
    /**
     * Et� anagrafica della persona in formato byte
     */
    public byte eta;

    /**
     * Genera una stringa contenente nome, cognome ed età della persona
     */
    public String dettagli() {
        String s = "\nNome: " + nome + "\nCognome: " + cognome + "\nEt�: " + eta;
        return s;
    }
}
