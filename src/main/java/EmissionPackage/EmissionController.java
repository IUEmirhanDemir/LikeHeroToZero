package EmissionPackage;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform;
public class EmissionController {
    @PersistenceContext
    private EntityManager entityManager;

    public EmissionController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        entityManager = emf.createEntityManager();
    }

    public List<EmissionsDate> getCountries() {
        List<EmissionsDate> countryList = new ArrayList<>();

        String query = "SELECT DISTINCT e.country_name FROM EmissionsDate e";
        TypedQuery<String> typedQuery = entityManager.createQuery(query, String.class);
        List<String> countries = typedQuery.getResultList();

        for (String country : countries) {
            EmissionsDate emissionsDate = new EmissionsDate();
            emissionsDate.setCountry_name(country);
            countryList.add(emissionsDate);
        }

        return countryList;
    }



    public List<EmissionsDate> filterEmssionsDaten(String countryName) {
        String query = "SELECT e FROM EmissionsDate e WHERE e.country_name = :country_name ORDER BY e.date";
        TypedQuery<EmissionsDate> typedQuery = entityManager.createQuery(query, EmissionsDate.class);
        typedQuery.setParameter("country_name", countryName);
        List<EmissionsDate> emissionsDates = typedQuery.getResultList();

        return emissionsDates;
    }
}
