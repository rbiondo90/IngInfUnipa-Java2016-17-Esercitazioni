package it.unipa.community.robertobiondo.prg.n08.es08;

import java.util.Calendar;

/**
 *
 * @author Bob
 */
public class Date implements Comparable<Date> {

    public enum Mese {
        GENNAIO(1, 31), FEBBRAIO(2, 28), MARZO(3, 31), APRILE(4, 30), MAGGIO(5, 31), GIUGNO(6, 30), LUGLIO(7, 31), AGOSTO(8, 31), SETTEMBRE(9, 30),
        OTTOBRE(10, 31), NOVEMBRE(11, 30), DICEMBRE(12, 31);
        private int indice;
        private int giorni;

        private Mese(int indice, int giorni) {
            this.indice = indice;
            this.giorni = giorni;
        }

        public int getIndice() {
            return this.indice;
        }

        public static Mese meseDaIndice(int indice) throws MyIllegalDateException {
            if (indice > 12 || indice < 1) {
                throw new MyIllegalDateException("L'indice di un mese deve essere compreso tra 1 e 12!");
            }
            return Mese.values()[indice - 1];
        }

        public int getGiorniDelmese() {
            return this.giorni;
        }

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }
    private int giorno = 1;
    private Mese mese = Mese.GENNAIO;
    private int anno = 1970;

    public Date() {
    }

    public Date(int giorno, Mese mese, int anno) throws MyIllegalDateException {
        this.setGiorno(giorno);
        this.setMese(mese);
        this.setAnno(anno);
    }

    public Date(int giorno, int mese, int anno) throws MyIllegalDateException {
        this(giorno, Mese.meseDaIndice(mese), anno);
    }

    public Date(String date) throws MyIllegalDateException {
        try {
            String[] dateSplitted = date.split("/");
            if (dateSplitted.length == 3) {
                this.setAnno(Integer.parseInt(dateSplitted[2]));
                this.setMese(Mese.meseDaIndice(Integer.parseInt(dateSplitted[1])));
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
        this.setMese(Mese.valueOf(mese.toUpperCase()));
    }

    public void setGiorno(int giorno) throws MyIllegalDateException {
        if (this.validaGiornoEMese(giorno, this.mese)) {
            this.giorno = giorno;
        } else {
            throw new MyIllegalDateException("Giorno non valido!");
        }
    }

    public void setMese(Mese mese) throws MyIllegalDateException {
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
        while (contaGiorni + Mese.meseDaIndice(meseDaImpostare).getGiorniDelmese() < giornoDellAnno) {
            contaGiorni += Mese.meseDaIndice(meseDaImpostare).getGiorniDelmese();
            meseDaImpostare++;
        }
        this.setMese(Mese.meseDaIndice(meseDaImpostare));
        this.setGiorno(giornoDellAnno - contaGiorni);
    }

    public int getGiorno() {
        return this.giorno;
    }

    public Mese getMese() {
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
                    + "/" + String.format("%02d", this.getMese().indice) + "/"
                    + String.format("%04d", this.getAnno()));
        }
        if (formato.equals("GG MMMM AAAA")) {
            return (this.getGiorno() + " " + this.getMese() + " " + this.getAnno());
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
        try {
            for (int m = 1; m < this.getMese().getIndice(); m++) {
                giornoDellAnno += Mese.meseDaIndice(m).getGiorniDelmese();
            }
        } catch (MyIllegalDateException exc) {

        }
        return giornoDellAnno;
    }

    private boolean validaGiornoEMese(int giorno, Mese mese) {
        return (giorno <= mese.getGiorniDelmese());
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
