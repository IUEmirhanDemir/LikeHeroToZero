package EmissionPackage;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


public class EmissionDAO implements Serializable {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public EmissionDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("HeroProjectPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<EmissionsDate> getAllEmissionsData() {
        String query = "SELECT e FROM EmissionsDate e";
        TypedQuery<EmissionsDate> typedQuery = entityManager.createQuery(query, EmissionsDate.class);
        return typedQuery.getResultList();
    }

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
