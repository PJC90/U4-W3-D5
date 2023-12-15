package pierpaolo.entities;

import java.util.Random;

public abstract class Metadati {
    private long ISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public Metadati() {
    }
    public Metadati(String titolo, int annoPubblicazione, int numeroPagine) {
        Random rm = new Random();
        this.ISBN = rm.nextInt(0, 100000000);
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

}
