package pierpaolo.dao;

import pierpaolo.entities.Metadati;
import pierpaolo.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MetadatiDao {
    private final EntityManager em;

    public MetadatiDao(EntityManager em) {
        this.em = em;
    }
    public void save(Metadati metadati) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(metadati);
        transaction.commit();
        System.out.println("metadati " + metadati.getTitolo() + " aggiunto al db");
    }
    public Metadati findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Metadati.class, id); // Primo parametro è l'Entity, secondo l'id da ricercare
    }
    public void findByIdAndDelete(long id) {
        Metadati found = this.findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("metadati " + found.getTitolo() + " eliminato correttamente!");
        } else {
            // 3. Se non c'è --> "Non trovato"
            System.out.println("metadati di id " + id + " non è stato trovato");
        }
    }
}
