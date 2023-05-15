package LoginPackage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HeroProjectPU");

    // Liest mithilfe von userDate Klasse aus der Datenbank nach Benutzername und Passwort und gibt es zurück.
    public userDate readFromDatabase(String benutzername, String passwort) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<userDate> query = entityManager.createQuery(
                "SELECT u FROM userDate u WHERE u.benutzername = :benutzername AND u.passwort = :passwort", userDate.class);
        query.setParameter("benutzername", benutzername);
        query.setParameter("passwort", passwort);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
    }
}

