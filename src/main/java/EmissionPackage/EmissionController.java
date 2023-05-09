package EmissionPackage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmissionController {
    @PersistenceContext
    private EntityManager entityManager;

    public EmissionController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        entityManager = emf.createEntityManager();
    }



    public List<EmissionsDate> getAllEmissionsData() {
        String query = "SELECT e FROM EmissionsDate e";
        TypedQuery<EmissionsDate> typedQuery = entityManager.createQuery(query, EmissionsDate.class);
        return typedQuery.getResultList();
    }
}
