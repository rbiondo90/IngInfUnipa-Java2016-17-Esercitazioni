package it.unipa.community.robertobiondo.prg.n09.es06;


/**
 *
 * @author Roberto Biondo
 */
public interface Aritmetica<T extends Numero> {

    public T somma(T elemento2);

    public T sottrai(T elemento2);

    public T moltiplica(T elemento2);

    public T dividi(T elemento2);

}
