package it.unipa.community.robertobiondo.prg.n05.es02;

import it.unipa.community.robertobiondo.prg.n04.es04.Date;
import it.unipa.community.robertobiondo.prg.n05.es01.Persona;

/**
 *
 * @author Bob
 */
public class Professore extends Persona {

    private Date dataAssunzione;
    private String ruolo = "";
    private String dipartimento = "";
    private int salario = -1;
    private boolean validitàRecord = true;

    public Professore(Persona professore, Date dataAssunzione, String ruolo, String dipartimento, int salario) {
        super(professore);
        if (super.getValiditàRecord()) {
            this.validitàRecord = this.setDataAssunzione(dataAssunzione) && this.setRuolo(ruolo) && this.setDipartimento(dipartimento) && this.setSalario(salario);
        } else {
            this.validitàRecord = false;
        }
    }

    public Professore(Persona professore, String dataAssunzione, String ruolo, String dipartimento, int salario) {
        this(professore, new Date(dataAssunzione), ruolo, dipartimento, salario);
    }

    public Professore(Date dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap,
            Date dataAssunzione, String ruolo, String dipartimento, int salario) {
        this(new Persona(dataDiNascita, nome, cognome, codiceFiscale, indirizzo, città, cap), dataAssunzione, ruolo, dipartimento, salario);
    }

    public Professore(String dataDiNascita, String nome, String cognome, String codiceFiscale, String indirizzo, String città, String cap,
            String dataAssunzione, String ruolo, String dipartimento, int salario) {
        this(new Persona(new Date(dataDiNascita), nome, cognome, codiceFiscale, indirizzo, città, cap), new Date(dataAssunzione), ruolo, dipartimento, salario);
    }

    private boolean setDataAssunzione(Date dataAssunzione) {
        if (dataAssunzione != null && this.getDataDiNascita().anniPassati(dataAssunzione) >= 25) {
            this.dataAssunzione = dataAssunzione.clone();
            this.updateValiditàRecord();
            return true;
        } else {
            this.dataAssunzione = null;
            return validitàRecord = false;
        }
    }

    private boolean setRuolo(String ruolo) {
        if (ruolo.toLowerCase().equals("professore associato") || ruolo.toLowerCase().equals("pa")) {
            this.ruolo = "Professore Associato";
            this.updateValiditàRecord();
            return true;
        } else if (ruolo.toLowerCase().equals("professore ordinario") || ruolo.toLowerCase().equals("po") || ruolo.isEmpty()) {
            this.ruolo = "Professore Ordinario";
            this.updateValiditàRecord();
            return true;
        } else if (ruolo.toLowerCase().equals("ricercatore") || ruolo.toLowerCase().equals("r")) {
            this.ruolo = "Ricercatore";
            this.updateValiditàRecord();
            return true;
        } else {
            this.ruolo = "";
            return validitàRecord = false;
        }
    }

    private boolean setDipartimento(String dipartimento) {
        if (!dipartimento.isEmpty()) {
            this.dipartimento = dipartimento.substring(0, Math.min(dipartimento.length(), 20));
            this.updateValiditàRecord();
            return true;
        } else {
            this.dipartimento = "";
            return validitàRecord = false;
        }
    }

    private boolean setSalario(int salario) {
        if (salario >= 0) {
            this.salario = salario;
            this.updateValiditàRecord();
            return true;
        } else {
            this.salario = -1;
            return validitàRecord = false;
        }
    }

    public void updateValiditàRecord() {
        this.validitàRecord = super.getValiditàRecord() && this.getDataAssunzione() != null && !this.getDipartimento().isEmpty() && !this.getRuolo().isEmpty()
                && this.getSalario() >= 0;
    }

    public Date getDataAssunzione() {
        return this.dataAssunzione;
    }

    public String getDipartimento() {
        return this.dipartimento;
    }

    public String getRuolo() {
        return this.ruolo;
    }

    private int getSalario() {
        return this.salario;
    }

    @Override
    public boolean getValiditàRecord() {
        return this.validitàRecord;
    }

    @Override
    public String toString() {
        if (this.getValiditàRecord()) {
            StringBuilder s = new StringBuilder(super.toString());
            s.insert(0, "\nSCHEDA PROFESSORE");
            s.append("\nData di assunzione: ").append(this.getDataAssunzione());
            s.append("\nRuolo: ").append(this.getRuolo());
            s.append("\nDipartimento: ").append(this.getDipartimento());
            s.append("\nSalario: ").append(this.getSalario()).append("€");
            return s.toString();
        } else {
            return "Record non valido!";
        }
    }

    @Override
    public void stampaDati() {
        System.out.println(this);
    }

}
