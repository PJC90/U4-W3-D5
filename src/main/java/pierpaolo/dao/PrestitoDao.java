package pierpaolo.dao;

import pierpaolo.entities.Metadati;
import pierpaolo.entities.Prestito;
import pierpaolo.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PrestitoDao {
    private final EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }
    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("elemento prestato " + prestito.getPrestitoLibroRivista().getTitolo() + " aggiunto al db");
    }
    public Prestito findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Prestito.class, id); // Primo parametro è l'Entity, secondo l'id da ricercare
    }
    public void findByIdAndDelete(long id) {
        Prestito found = this.findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("elemento prestato " + found.getPrestitoLibroRivista().getTitolo() + " eliminato correttamente!");
        } else {
            // 3. Se non c'è --> "Non trovato"
            System.out.println("elemento prestato di id " + id + " non è stato trovato");
        }
    }
//    public List<Metadati> findByTessera(long numeroTessera) {
//        TypedQuery<Metadati> findByIsbn = em.createNamedQuery("ricercaPrestitiDaTessera", Metadati.class);
//        findByIsbn.setParameter("numeroTessera", numeroTessera);
//        return findByIsbn.getResultList();
//    }
}
