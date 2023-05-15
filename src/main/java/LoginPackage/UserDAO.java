package LoginPackage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HeroProjectPU");

    public userBean auslesenDerAnmeldedatenausDatenbank(String benutzername, String passwort) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<userBean> query = entityManager.createQuery(
                "SELECT u FROM userBean u WHERE u.benutzername = :benutzername AND u.passwort = :passwort", userBean.class);
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

