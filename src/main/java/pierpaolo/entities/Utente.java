package pierpaolo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class Utente {
    @Id
    @GeneratedValue
    private long id;
    private long numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    public Utente() {
    }

    public Utente(long numeroTessera, String nome, String cognome, LocalDate dataNascita) {
        this.numeroTessera = numeroTessera;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public long getId() {
        return id;
    }
    public long getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
