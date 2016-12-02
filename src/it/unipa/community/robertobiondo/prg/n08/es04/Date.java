package it.unipa.community.robertobiondo.prg.n08.es04;

import java.util.Calendar;

/**
 *
 * @author Bob
 */
public class Date implements Comparable<Date> {

    private int giorno = 1;
    private int mese = 1;
    private int anno = 1970;

    public Date() {
    }

    public Date(int giorno, int mese, int anno) throws MyIllegalDateException {
        this.setGiorno(giorno);
        this.setMese(mese);
        this.setAnno(anno);
    }

    public Date(String date) throws MyIllegalDateException {
        try {
            String[] dateSplitted = date.split("/");
            if (dateSplitted.length == 3) {
                this.setAnno(Integer.parseInt(dateSplitted[2]));
                this.setMese(Integer.parseInt(dateSplitted[1]));
                this.setGiorno(Integer.parseInt(dateSplitted[0]));

            } else {
                throw new MyIllegalDateException();
            }
        } catch (NumberFormatException exc) {
            throw new MyIllegalDateException();
        }

    }

    public Date(int giornoDellAnno, int anno) throws MyIllegalDateException {
        this(1, 1, anno);
        this.setGiornoEMese(giornoDellAnno);
    }

    public Date(int giorno, String mese, int anno) throws MyIllegalDateException {
        this(giorno, 1, anno);
        int m;
        mese = mese.toLowerCase();
        for (m = 1; m <= 12; m++) {
            if (getNomeMese(m).toLowerCase().equals(mese)) {
                this.setMese(m);
                break;
            }
        }

    }

    public void setGiorno(int giorno) throws MyIllegalDateException {
        if (this.validaGiornoEMese(giorno, this.mese)) {
            this.giorno = giorno;
        } else {
            throw new MyIllegalDateException("Giorno non valido!");
        }
    }

    public void setMese(int mese) throws MyIllegalDateException {
        if (this.validaGiornoEMese(this.giorno, mese)) {
            this.mese = mese;
        } else {
            throw new MyIllegalDateException("Mese non valido!");
        }
    }

    public void setAnno(int anno) throws MyIllegalDateException {
        if (anno >= 0 && anno <= 3000) {
            this.anno = anno;
        } else {
            throw new MyIllegalDateException("Anno non valido!");
        }
    }

    private void setGiornoEMese(int giornoDellAnno) throws MyIllegalDateException {
        if (giornoDellAnno > 365 || giornoDellAnno < 0) {
            throw new MyIllegalDateException("Giorno dell'anno non valido!");
        }
        int contaGiorni = 0;
        int meseDaImpostare = 1;
        while (contaGiorni + getGiorniDelMese(meseDaImpostare) < giornoDellAnno) {
            contaGiorni += getGiorniDelMese(meseDaImpostare);
            meseDaImpostare++;
        }
        this.setMese(meseDaImpostare);
        this.setGiorno(giornoDellAnno - contaGiorni);
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
        return this.toString("GG/MM/AAAA");
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
        Date d = null;
        try {
            d = new Date(calendario.get(Calendar.DATE), calendario.get(Calendar.MONTH) + 1, calendario.get(Calendar.YEAR));
        } catch (MyIllegalDateException exc) {
        }

        return d;
    }

    public Date aggiungiGiorni(int giorni) {
        int anniDaAggiungere = giorni / 365;
        int giornoDaImpostare = this.getGiornoDellAnno() + giorni - (anniDaAggiungere * 365);
        if (giornoDaImpostare > 365) {
            giornoDaImpostare -= 365;
            anniDaAggiungere++;
        }
        Date d = null;
        try {
            d = new Date(giornoDaImpostare, this.getAnno() + anniDaAggiungere);
        } catch (MyIllegalDateException exc) {
        }
        return d;
    }

    public Date aggiungiAnni(int anni) {
        Date d = null;
        try {
            d = new Date(this.getGiorno(), this.getMese(), this.getAnno() + anni);
        } catch (MyIllegalDateException exc) {
        }
        return d;
    }

    public int giorniDallAnnoZero() {
        return this.getAnno() * 365 + this.getGiornoDellAnno();
    }

    @Override
    public Date clone() {
        Date clone = null;
        try {
            clone = new Date(this.getGiorno(), this.getMese(), this.getAnno());
        } catch (MyIllegalDateException exc) {
        }
        return clone;
    }

    @Override
    public int compareTo(Date date) {
        if (date != null) {
            return this.giorniDallAnnoZero() - date.giorniDallAnnoZero();
        } else {
            throw new NullPointerException();
        }
    }
}
