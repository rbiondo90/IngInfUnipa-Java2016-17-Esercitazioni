/*Questo esercizio mi ha causato non pochi dubbi su quale potesse essere una corretta implementazione di quanto richiesto.
Creare un'interfaccia "Aritmetica" che definisca le principali operazioni aritmetiche sulle classi che la implementano, infatti richiede poi svariati cast in queste, 
cosa non proprio bella a livello di struttura del programma. In ogni caso, per quanto possa sembrare poco sensato, ho lasciato i relativi metodi già esistenti per queste classi,
e ho fatto in modo che i metodi in overload dati dall'interfaccia chiamassero questi.
*/
package it.unipa.community.robertobiondo.prg.n07.es04;

/**
 *
 * @author Roberto Biondo
 */
public interface Aritmetica {

    public Aritmetica somma(Aritmetica elemento2);

    public Aritmetica sottrai(Aritmetica elemento2);

    public Aritmetica moltiplica(Aritmetica elemento2);

    public Aritmetica dividi(Aritmetica elemento2);
    
    public void stampa();
    
}
