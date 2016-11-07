
package it.unipa.community.robertobiondo.prg.n04.es03;

/**
 *
 * @author Bob
 */
public class Stack {
    private char[] stack;
    private int index = -1;
    private int dim;
    
    public Stack(int dim){
        if(this.setDim(dim)){
        this.stack = new char[dim];  
        }  
    }
    
    public Stack(){
        this(100);
    }
    
    private boolean setDim(int dim){
        if(dim>0){
            this.dim=dim;
            return true;
        }
        else return false;
    }
    
    public void push(char c){
        if(!this.isFull()){
            this.stack[++index]=c;
            System.out.println("Inserito il carattere " + c + ".");
        }
        else {
            System.out.println("Errore! Stack pieno!");
        }
    }
    
    public char pop(){
        if(!this.isEmpty()){
            System.out.println("Estratto il carattere " + this.stack[index] + ".");
            return this.stack[index--];
        }
        else {
            System.out.println("Errore! Stack vuoto!");
            return ' ';
        }
    }
    
    private boolean isEmpty(){
        return this.index==-1;
    }
    
    private boolean isFull(){
        return this.index==this.dim-1;
    }
}
