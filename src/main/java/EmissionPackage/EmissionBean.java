package EmissionPackage;


import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

import java.util.List;

@Named
@ViewScoped
public class EmissionBean implements Serializable{

    private final EmissionController emissionController;
    private final List<EmissionsDate> emissionsDates;


    public EmissionBean(){
        emissionController = new EmissionController();
        emissionsDates = emissionController.getAllEmissionsData();
    }

    public List<EmissionsDate> getEmissionsDates(){
        return emissionsDates;
    }



}
