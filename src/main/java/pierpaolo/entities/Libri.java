package pierpaolo.entities;

public class Libri extends Metadati{
    private String autore;
    private String genere;

    public Libri() {
    }

    public Libri(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

}
