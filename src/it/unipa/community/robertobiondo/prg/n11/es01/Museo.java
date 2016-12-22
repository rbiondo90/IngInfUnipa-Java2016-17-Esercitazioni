package it.unipa.community.robertobiondo.prg.n11.es01;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Museo {

    private String nome;
    private String indirizzo;
    private Map<String, OperaDArte> opere;

    public Museo(String nome, String indirizzo) {
        this.setNome(nome);
        this.setIndirizzo(indirizzo);
        this.opere = new HashMap<>();
    }

    public void setNome(String nome) {
        if (Objects.isNull(nome) || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome del museo non valido!");
        }
        this.nome = nome;
    }

    public void setIndirizzo(String indirizzo) {
        if (Objects.isNull(indirizzo) || indirizzo.isEmpty()) {
            throw new IllegalArgumentException("Indirizzo del museo non valido!");
        }
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public boolean aggiungiOpera(OperaDArte opera) {
        if (Objects.isNull(opera)) {
            return false;
        }

        return (this.opere.putIfAbsent(opera.getTitolo(), opera) == null) ? true : false;
    }

    public boolean rimuoviOpera(String titoloOpera) {
        return (opere.remove(titoloOpera) != null) ? true : false;
    }

    public OperaDArte ottieniOpera(String titoloOpera) {
        return this.opere.get(titoloOpera);
    }

    public void stampaListaOpere() {
        Iterator iteratoreMuseo = this.opere.values().iterator();
        System.out.println("Lista opere contenute al museo " + this.getNome() + ", situato in " + this.getIndirizzo() + ":");
        while (iteratoreMuseo.hasNext()) {
            System.out.println("--------------------------------------------"
                    + "\n" + iteratoreMuseo.next());
        }
        System.out.println("--------------------------------------------");
    }

}
