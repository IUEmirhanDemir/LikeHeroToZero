package EmissionPackage;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

// EmissionDAO-Klasse zur Durchführung von Datenbankoperationen auf den CO2-Emissionsdaten
public class EmissionDAO implements Serializable {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    // Standardkonstruktor, der die Erstellung des EntityManager und EntityManagerFactory handhabt
    public EmissionDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("HeroProjectPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Methode zum Abrufen aller Emissionsdaten aus der Datenbank
    public List<EmissionsDate> getAllEmissionsData() {
        String query = "SELECT e FROM EmissionsDate e";
        TypedQuery<EmissionsDate> typedQuery = entityManager.createQuery(query, EmissionsDate.class);
        return typedQuery.getResultList();
    }

    // Methode zum Löschen eines bestimmten Emissionsdatum-Eintrags aus der Datenbank
    public void deleteFromTable(EmissionsDate emissionsDate){
        try {
            entityManager.getTransaction().begin();
            EmissionsDate emissionsDateToDelete = entityManager.find(EmissionsDate.class, emissionsDate.getId());
            if (emissionsDateToDelete != null){
                entityManager.remove(emissionsDateToDelete);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }

    // Methode zum Hinzufügen neuer Emissionsdaten zur Datenbank
    public void addNewDataToDataTable(EmissionsDate emissionsDate){
        EmissionsDate newEmissionData = new EmissionsDate();

        newEmissionData.setDate(emissionsDate.getDate());
        newEmissionData.setAmount_value(emissionsDate.getAmount_value());
        newEmissionData.setCountry_name(emissionsDate.getCountry_name());
        newEmissionData.setCountry_code(emissionsDate.getCountry_code());
        newEmissionData.setIndicator_name(emissionsDate.getIndicator_name());

        try {
            entityManager.getTransaction().begin();
            this.entityManager.persist(newEmissionData);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    // Methode zur Aktualisierung von bestehenden Emissionsdaten in der Datenbank
    public void updateData(EmissionsDate emissionsDate){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(emissionsDate);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

}
