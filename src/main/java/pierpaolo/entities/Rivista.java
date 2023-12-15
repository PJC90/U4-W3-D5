package pierpaolo.entities;

public class Rivista extends Metadati{
    private Periodicità periodicità;

    public Rivista() {
    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

   
}
