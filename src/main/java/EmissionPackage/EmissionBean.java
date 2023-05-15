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

    @PostConstruct
    public void initializierenEmissionsDates() {
        try {
            this.emissionsDates = emissionDAO.getAllEmissionsData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(EmissionsDate emissionsDate) {
        emissionDAO.deleteFromTable(emissionsDate);
        this.emissionsDates = emissionDAO.getAllEmissionsData();

    }

    public void add() {
        emissionDAO.addNewDataToDataTable(emissionsDate);
        this.emissionsDates = emissionDAO.getAllEmissionsData();
        this.emissionsDate = new EmissionsDate();
    }

    public void update() {
        emissionDAO.updateData(emissionsDate);
        this.emissionsDates = emissionDAO.getAllEmissionsData();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update Erfolgreich "));
    }


}
