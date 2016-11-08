package it.unipa.community.robertobiondo.prg.n01.es07;


public class TestMacchina {

    public static void main(String args[]) {
        Macchina automobile = new Macchina();
        automobile.Cammina(40);
        automobile.Monitora();
        automobile.Revisione();
        automobile.Monitora();
    }
}
