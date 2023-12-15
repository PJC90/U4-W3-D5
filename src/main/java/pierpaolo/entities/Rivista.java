package pierpaolo.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends Metadati{
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista() {
    }

    public Rivista(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                "} " + super.toString();
    }
}
