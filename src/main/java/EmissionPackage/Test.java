package EmissionPackage;


public class Test {
    public static void main(String[] args) {
        EmissionDAO controller = new EmissionDAO();

        // Erstellen Sie eine Instanz von EmissionBean
        EmissionBean bean = new EmissionBean();
        bean.setEmissionController(controller);

        // Aufruf der init Methode
        bean.initializierenEmissionsDates();

        // Test der getAllEmissionsData Methode
        System.out.println("Test von getAllEmissionsData:");
        bean.getEmissionsDates().forEach(emission -> System.out.println(emission.getCountry_name() + ", " + emission.getAmount_value()));

        // Erstellen Sie eine Instanz von EmissionsDate zum Hinzufügen
        EmissionsDate newEmission = new EmissionsDate("TestLand", "TL", "TestIndikator", 2023, 100.0);
        bean.add();

        System.out.println("TestLand hinzugefügt.");

        // Test der addNewDatetoTable Methode
        System.out.println("Test von addNewDatetoTable:");
        bean.getEmissionsDates().forEach(emission -> System.out.println(emission.getCountry_name() + ", " + emission.getAmount_value()));

        // Test der delete Methode
        System.out.println("Test von delete:");
        bean.delete(newEmission);
        bean.getEmissionsDates().forEach(emission -> System.out.println(emission.getCountry_name() + ", " + emission.getAmount_value()));
    }
}
