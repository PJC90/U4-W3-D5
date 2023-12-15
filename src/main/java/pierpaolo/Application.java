package pierpaolo;

import com.github.javafaker.Faker;
import pierpaolo.dao.MetadatiDao;
import pierpaolo.dao.PrestitoDao;
import pierpaolo.dao.UtenteDao;
import pierpaolo.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5project");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);
        MetadatiDao metadatiDao = new MetadatiDao(em);
        // *****************************************************      CREAZIONE Utenti, Libri e Riviste
        Utente u1 = new Utente(123123125,"Aldo", "Baglio", LocalDate.of(1961,9,26));
        Utente u2 = new Utente(123123125,"Massimiliano", "Allegri", LocalDate.of(1941,4,2));
        Utente u3 = new Utente(123123125,"Giorgia", "Meloni", LocalDate.of(1931,4,1));
        Libri sapiens = new Libri("790a565ae4", "Sapiens",2019 ,332,"Yuval Noha Harari","Storico");
        Libri homoDeus = new Libri("1540a565ae4", "Homo Deus",2021 ,452,"Yuval Noha Harari","Storico");
        Libri seneca = new Libri("aa478xs5ae4", "Imparare a vivere",750 ,192,"Seneca","Filosofico");
        Rivista nature = new Rivista("123456","Nature",2023,98, Periodicità.MENSILE);
        Rivista focus = new Rivista("123456","Focus",2023,148, Periodicità.SETTIMANALE);
        // ******************************************************       AGGIUNTA PRESTITI
        Utente giorgiaDB = utenteDao.findById(3);
        Metadati giorgiaFocus = metadatiDao.findById(8);
        Prestito giorgiaPrestito = new Prestito(giorgiaDB,giorgiaFocus,LocalDate.of(2023,12,12));
//        prestitoDao.save(giorgiaPrestito);
        Utente aldoDB = utenteDao.findById(1);
        Metadati aldoSapiens = metadatiDao.findById(4);
        Prestito aldoDBPrestito = new Prestito(aldoDB,aldoSapiens,LocalDate.of(2023,6,2));
//        prestitoDao.save(aldoDBPrestito);
        Utente massimilianoDB = utenteDao.findById(2);
        Metadati massimilianoHomo = metadatiDao.findById(5);
        Prestito massimilianoPrestito = new Prestito(massimilianoDB,massimilianoHomo,LocalDate.of(2023,1,20));
//        prestitoDao.save(massimilianoPrestito);


        System.out.println("***************************************     Aggiunta elementi al catalogo");
//        utenteDao.save(u2);
//        utenteDao.save(u3);
//        metadatiDao.save(homoDeus);
//        metadatiDao.save(seneca);
//        metadatiDao.save(nature);
//        metadatiDao.save(focus);

        System.out.println("Hello World!");
        em.close();
        emf.close();
    }
}
