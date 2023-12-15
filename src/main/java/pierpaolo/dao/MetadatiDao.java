package pierpaolo.dao;

import pierpaolo.entities.Metadati;
import pierpaolo.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public void findByIsbnAndDelete(String ISBN){
        TypedQuery<Metadati> findByIsbn = em.createQuery("SELECT a FROM Metadati a WHERE a.ISBN = :isbn", Metadati.class);
        findByIsbn.setParameter("isbn", ISBN);
        Metadati found = findByIsbn.getSingleResult();
        if( found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Metadati con titolo: " + found.getTitolo() + " eliminato!");
        } else {
            System.out.println("Metadati ISBN: " + ISBN + "non esiste nel database!");
        }
    }
    public Metadati findByIsbn(String ISBN) {
        TypedQuery<Metadati> findByIsbn = em.createNamedQuery("ricercaMetadatiISBN", Metadati.class);
        findByIsbn.setParameter("ISBN", ISBN);
        return findByIsbn.getSingleResult();
    }
    public List<Metadati> findByANNO(int annoPubblicazione) {
        TypedQuery<Metadati> findByIsbn = em.createNamedQuery("ricercaMetadatiANNO", Metadati.class);
        findByIsbn.setParameter("annoPubblicazione", annoPubblicazione);
        return findByIsbn.getResultList();
    }
}
