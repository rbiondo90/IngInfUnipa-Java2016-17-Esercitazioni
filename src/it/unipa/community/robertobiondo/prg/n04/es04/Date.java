package it.unipa.community.robertobiondo.prg.n04.es04;

import java.util.Calendar;

/**
 *
 * @author Bob
 */
public class Date implements Comparable<Date> {

    private int giorno;
    private int mese;
    private int anno;
    private boolean dataValida = false;

    public Date() {
        this.giorno = 1;
        this.mese = 1;
        this.anno = 1970;
        this.dataValida = true;
    }

    public Date(int giorno, int mese, int anno) {
        this();
        this.dataValida = (this.setGiorno(giorno) && this.setMese(mese) && this.setAnno(anno));
    }

    public Date(String date) {
        this();
        String[] dateSplitted = date.split("/");
        if (dateSplitted.length == 3) {
            this.dataValida = (this.setAnno(Integer.parseInt(dateSplitted[2])) && this.setMese(Integer.parseInt(dateSplitted[1]))
                    && this.setGiorno(Integer.parseInt(dateSplitted[0])));
        } else {
            this.dataValida = false;
        }
    }

    public Date(int giornoDellAnno, int anno) {
        this(1, 1, anno);
        this.dataValida = this.setGiornoEMese(giornoDellAnno);
    }

    public Date(int giorno, String mese, int anno) {
        this(giorno, 1, anno);
        if (this.getValidita()) {
            this.dataValida = false;
            int m;
            mese = mese.toLowerCase();
            for (m = 1; m <= 12; m++) {
                if (getNomeMese(m).toLowerCase().equals(mese)) {
                    this.dataValida = this.setMese(m);
                    break;
                }
            }
        }

    }

    public boolean setGiorno(int giorno) {
        if (this.validaGiornoEMese(giorno, this.mese)) {
            this.giorno = giorno;
            return true;
        } else {
            this.giorno = 1;
            this.mese = 1;
            return false;
        }
    }

    public boolean setMese(int mese) {
        if (this.validaGiornoEMese(this.giorno, mese)) {
            this.mese = mese;
            return true;
        } else {
            this.giorno = 1;
            this.mese = 1;
            return false;
        }
    }

    public boolean setAnno(int anno) {
        if (anno >= 0 && anno <= 3000) {
            this.anno = anno;
            return true;
        } else {
            this.anno = 1970;
            return false;
        }
    }

    private boolean setGiornoEMese(int giornoDellAnno) {
        if (giornoDellAnno > 365) {
            return false;
        }
        int contaGiorni = 0;
        int mese = 1;
        while (contaGiorni + getGiorniDelMese(mese) < giornoDellAnno) {
            contaGiorni += getGiorniDelMese(mese);
            mese++;
        }
        this.setMese(mese);
        this.setGiorno(giornoDellAnno - contaGiorni);
        return true;
    }

    public int getGiorno() {
        return this.giorno;
    }

    public int getMese() {
        return this.mese;
    }

    public int getAnno(String formato) {
        if (formato.equals("AAAA")) {
            return this.anno;
        }
        if (formato.equals("AA")) {
            StringBuilder a = new StringBuilder(this.anno);
            return (a.charAt(2) * 10 + a.charAt(3));
        } else {
            return 0;
        }
    }

    public int getAnno() {
        return this.getAnno("AAAA");
    }

    public String toString(String formato) {
        String s;
        if (formato.equals("GGG AAAA")) {
            return (String.format("%03d", this.getGiornoDellAnno()) + " "
                    + String.format("%04d", this.getAnno()));
        }
        if (formato.equals("GG/MM/AA")) {
            return (String.format("%02d", this.getGiorno())
                    + "/" + String.format("%02d", this.getMese()) + "/"
                    + String.format("%04d", this.getAnno()));
        }
        if (formato.equals("GG MMMM AAAA")) {
            return (this.getGiorno() + " " + this.getNomeMese() + " " + this.getAnno());
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return this.toString("GG/MM/AA");
    }

    public void stampa(String formato) {
        System.out.println(this.toString(formato));
    }

    public void stampa() {
        this.stampa("GG/MM/AA");
    }

    private int getGiornoDellAnno() {
        int giornoDellAnno = this.getGiorno();
        for (int m = 1; m < this.getMese(); m++) {
            giornoDellAnno += Date.getGiorniDelMese(m);
        }
        return giornoDellAnno;
    }

    private static int getGiorniDelMese(int mese) {
        if (mese <= 0 || mese > 12) {
            return 0;
        }
        switch (mese) {
            case 2:
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private int getGiorniDelMese() {
        return Date.getGiorniDelMese(this.getMese());
    }

    private boolean validaGiornoEMese(int giorno, int mese) {
        return (getGiorniDelMese(mese) != 0 && giorno <= getGiorniDelMese(mese));
    }

    public boolean getValidita() {
        return this.dataValida;
    }

    private static String getNomeMese(int mese) {
        switch (mese) {
            case 1:
                return "Gennaio";
            case 2:
                return "Febbraio";
            case 3:
                return "Marzo";
            case 4:
                return "Aprile";
            case 5:
                return "Maggio";
            case 6:
                return "Giugno";
            case 7:
                return "Luglio";
            case 8:
                return "Agosto";
            case 9:
                return "Settembre";
            case 10:
                return "Ottobre";
            case 11:
                return "Novembre";
            case 12:
                return "Dicembre";
            default:
                return "";
        }
    }

    private String getNomeMese() {
        return Date.getNomeMese(mese);
    }

    public int giorniPassati(Date d2) {
        return ((d2.getAnno() - this.getAnno()) * 365) + (d2.getGiornoDellAnno() - this.getGiornoDellAnno());
    }

    public int anniPassati(Date d2) {
        return this.giorniPassati(d2) / 365;
    }

    public static Date ottieniDataCorrente() {
        Calendar calendario = Calendar.getInstance();
        return new Date(calendario.get(Calendar.DATE), calendario.get(Calendar.MONTH) + 1, calendario.get(Calendar.YEAR));
    }

    public Date aggiungiGiorni(int giorni) {
        int anniDaAggiungere = giorni / 365;
        int giornoDaImpostare = this.getGiornoDellAnno() + giorni - (anniDaAggiungere * 365);
        if (giornoDaImpostare > 365) {
            giornoDaImpostare -= 365;
            anniDaAggiungere++;
        }
        return new Date(giornoDaImpostare, this.getAnno() + anniDaAggiungere);
    }

    public Date aggiungiAnni(int anni) {
        return new Date(this.getGiorno(), this.getMese(), this.getAnno() + anni);
    }

    public int giorniDallAnnoZero() {
        return this.getAnno() * 365 + this.getGiornoDellAnno();
    }

    @Override
    public Date clone() {
        Date clone = new Date(this.getGiorno(), this.getMese(), this.getAnno());
        return clone;
    }

    public static void main(String args[]) {
        Date d = new Date("12/04/2016");
        d.stampa();
        d.stampa("GGG AAAA");
        d.stampa("GG MMMM AAAA");
        Date d2 = new Date(12, "aprile", 1990);
        d2.stampa();
        d2.stampa("GGG AAAA");
        d2.stampa("GG MMMM AAAA");
        Date d3 = new Date(365, 1986);
        d3.stampa("GG MMMM AAAA");
        System.out.println("Tra " + d + " e " + d2 + " ci sono " + d2.giorniPassati(d) + " giorni di differenza.");
        Date dataCorrente = Date.ottieniDataCorrente();
        dataCorrente.stampa();
        System.out.println("Tra 365 giorni sarà il " + Date.ottieniDataCorrente().aggiungiGiorni(365));
        System.out.println("Dal " + d + " al " + d2 + "sono passati " + d.anniPassati(d2) + " anni.");
        System.out.println("d1 compare(d2) = " + d.compareTo(new Date("12/04/2015")));
    }

    @Override
    public int compareTo(Date date) {
        if (date != null && this.getValidita() && date.getValidita()) {
            return this.giorniDallAnnoZero() - date.giorniDallAnnoZero();
        } else {
            throw new NullPointerException();
        }
    }
}
