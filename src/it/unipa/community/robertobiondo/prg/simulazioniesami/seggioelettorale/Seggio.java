/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.simulazioniesami.seggioelettorale;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author Roberto Biondo
 */
public class Seggio {

    private Collection<Studente> studenti;
    private Map<Candidato, Integer> candidati;
    private Collection<Studente> votanti;
    private int schedeBianche;
    private int schedeNulle;

    public Seggio() {
        studenti = new ArrayList<>();
        votanti = new ArrayList<>();
        candidati = new TreeMap<>();
        studenti.add(new Studente("Mario", "Rossi", 1, 1));
        studenti.add(new Studente("Luigi", "Rossi", 2, 2));
        studenti.add(new Studente("Carlo", "Bianchi", 3, 3));
        studenti.add(new Studente("Gianfranco", "Neri", 4, 4));
        studenti.add(new Studente("Pino", "Verdi", 5, 5));
        studenti.add(new Studente("Giuseppe", "Rosa", 6, 6));
        studenti.add(new Studente("Salvatore", "Bianchi", 7, 7));
        studenti.add(new Studente("Emanuele", "Blu", 8, 8));
        studenti.add(new Studente("Roberto", "Gialli", 9, 9));
        studenti.add(new Studente("Arcibaldo", "Arcobaleno", 10, 10));
        candidati.put(new Candidato("Silvio", "Berlusconi", 11, 11, "Forza Italia"), 0);
        candidati.put(new Candidato("Matteo", "Renzi", 12, 12, "Partito Democratico"), 0);
        candidati.put(new Candidato("Matteo", "Salvini", 13, 13, "Lega Nord"), 0);
    }

    public Studente studenteAbilitato(long matricola, long codiceDiControllo) {
        if (matricola <= 0) {
            throw new IllegalArgumentException("La matricola di uno studente non può essere minore o uguale a 0!");
        }
        Iterator<Studente> iteratore = studenti.iterator();
        Studente studente;
        while (iteratore.hasNext()) {
            studente = iteratore.next();
            if (studente.getMatricola() == matricola && studente.getCodiceDiControllo() == codiceDiControllo) {
                return studente;
            }
        }
        return null;
    }

    public boolean giaVotato(Studente studente) {
        if (Objects.isNull(studente)) {
            throw new IllegalArgumentException("Oggetto studente non inizializzato!");
        }
        if (studenti.contains(studente)) {
            if (votanti.contains(studente)) {
                return true;
            }
        }
        return false;
    }

    public void registraVoto(Studente votante, long matricolaDaVotare) {
        if (Objects.isNull(votante)) {
            throw new IllegalArgumentException("Oggetto studente non inizializzato!");
        }
        if (!giaVotato(votante)) {
            if (matricolaDaVotare != 0) {
                Candidato votato = null;
                Iterator<Candidato> iteratore = candidati.keySet().iterator();
                while (iteratore.hasNext() && votato == null) {
                    Candidato candidato = iteratore.next();
                    if (candidato.getMatricola() == matricolaDaVotare) {
                        votato = candidato;
                    }
                }
                if (votato != null) {
                    candidati.put(votato, candidati.get(votato) + 1);
                } else {
                    schedeNulle++;
                }
            } else {
                schedeBianche++;
            }
            votanti.add(votante);
        } else {
            System.out.println("Lo studente " + votante.getCognome() + " " + votante.getNome() + "ha già votato!");
        }
    }

    public void stampaCandidati(boolean mostraVoti) {
        Iterator<Candidato> iteratore = candidati.keySet().iterator();
        System.out.println("LISTA CANDIDATI:\n--------------------------------------------------------");
        while (iteratore.hasNext()) {
            Candidato candidato = iteratore.next();
            System.out.println(candidato.getMatricola() + ")" + candidato.getCognome() + " " + candidato.getNome() + " | " + candidato.getLista()
                    + ((mostraVoti) ? " | Voti ricevuti: " + candidati.get(candidato) : ""));
        }
        System.out.println("--------------------------------------------------------");
    }

    public void spoglio() {
        int numeroVotanti = votanti.size();
        int percentualeVotanti = (int) ((double) numeroVotanti / studenti.size() * 100);
        System.out.println("SPOGLIO DEL SEGGIO ELETTORALE");
        System.out.println("Numero votanti: " + numeroVotanti
                + "\nPercentuale votanti: " + percentualeVotanti + "%"
                + "\nSchede nulle: " + schedeNulle
                + "\nSchede bianche: " + schedeBianche);
        stampaCandidati(true);
        System.out.println();
    }
}
