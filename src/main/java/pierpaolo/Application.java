package pierpaolo;

import pierpaolo.dao.MetadatiDao;
import pierpaolo.dao.PrestitoDao;
import pierpaolo.dao.UtenteDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5project");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);
        MetadatiDao metadatiDao = new MetadatiDao(em);

        System.out.println("Hello World!");
    }
}
