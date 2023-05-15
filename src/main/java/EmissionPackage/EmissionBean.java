package EmissionPackage;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EmissionBean implements Serializable {

    @Inject
    private EmissionDAO emissionDAO;
    private List<EmissionsDate> emissionsDates;

    public List<EmissionsDate> getEmissionsDates() {
        return emissionsDates;
    }

    private EmissionsDate emissionsDate = new EmissionsDate();

    public EmissionDAO getEmissionController() {
        return emissionDAO;
    }

    public void setEmissionController(EmissionDAO emissionDAO) {
        this.emissionDAO = emissionDAO;
    }

    public EmissionsDate getEmissionsDate() {
        return emissionsDate;
    }

    public void setEmissionsDate(EmissionsDate emissionsDate) {
        this.emissionsDate = emissionsDate;
    }

    public void setEmissionsDates(List<EmissionsDate> emissionsDates) {
        this.emissionsDates = emissionsDates;
    }


    // Initialisierungsmethode zur Vorbereitung der Emissionsdatenliste nach der Bean-Erzeugung
    //Speziell für die Test-Klasse
    @PostConstruct
    public void initEmissionsDates() {
        try {
            this.emissionsDates = emissionDAO.getAllEmissionsData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Methode zum Löschen einer Emissionsdate-Objekts
    public void delete(EmissionsDate emissionsDate) {
        emissionDAO.deleteFromTable(emissionsDate);
        this.emissionsDates = emissionDAO.getAllEmissionsData();

    }


    // Methode zum Hinzufügen einer Emissionsdate-Objekts
    public void add() {
        emissionDAO.addNewDataToDataTable(emissionsDate);
        this.emissionsDates = emissionDAO.getAllEmissionsData();
        this.emissionsDate = new EmissionsDate();
    }


    // Methode zum Aktualisieren einer Emissionsdate-Objekts
    public void update() {
        emissionDAO.updateData(emissionsDate);
        this.emissionsDates = emissionDAO.getAllEmissionsData();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update Erfolgreich "));
    }


}
