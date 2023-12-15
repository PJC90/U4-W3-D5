package pierpaolo.dao;

import pierpaolo.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {
    private final EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }
    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("utente " + utente.getNome() + " aggiunto al db");
    }
    public Utente findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Utente.class, id); // Primo parametro è l'Entity, secondo l'id da ricercare
    }
    public void findByIdAndDelete(long id) {
        Utente found = this.findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Utente " + found.getNome() + " eliminato correttamente!");
        } else {
            // 3. Se non c'è --> "Non trovato"
            System.out.println("Utente con l'id " + id + " non è stato trovato");
        }
    }
}
