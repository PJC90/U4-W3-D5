package pierpaolo.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Prestito {
    private long id;
    private Utente utente;
    private Metadati prestitoLibroRivista;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzione30;
    private LocalDate getDataRestituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, Metadati prestitoLibroRivista, LocalDate dataInizioPrestito, LocalDate dataRestituzione30) {
        this.utente = utente;
        this.prestitoLibroRivista = prestitoLibroRivista;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzione30 = dataRestituzione30.plusDays(30);
    }

    public long getId() {
        return id;
    }
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Metadati getPrestitoLibroRivista() {
        return prestitoLibroRivista;
    }

    public void setPrestitoLibroRivista(Metadati prestitoLibroRivista) {
        this.prestitoLibroRivista = prestitoLibroRivista;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzione30() {
        return dataRestituzione30;
    }

    public void setDataRestituzione30(LocalDate dataRestituzione30) {
        this.dataRestituzione30 = dataRestituzione30;
    }

    public LocalDate getGetDataRestituzioneEffettiva() {
        return getDataRestituzioneEffettiva;
    }

    public void setGetDataRestituzioneEffettiva(LocalDate getDataRestituzioneEffettiva) {
        this.getDataRestituzioneEffettiva = getDataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", prestitoLibroRivista=" + prestitoLibroRivista +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzione30=" + dataRestituzione30 +
                ", getDataRestituzioneEffettiva=" + getDataRestituzioneEffettiva +
                '}';
    }
}
