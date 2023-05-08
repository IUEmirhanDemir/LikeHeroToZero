package EmissionPackage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        EmissionController emissionController = new EmissionController();

        // Aufrufen der getCountries()-Methode, um eine Liste der Länder zu erhalten
        List<EmissionsDate> countries = emissionController.getCountries();

        System.out.println("Liste der Länder:");
        for (EmissionsDate country : countries) {
            System.out.println(country.getCountry_name());
        }
        System.out.println();

        // Beispielaufruf der filterEmssionsDaten()-Methode für ein bestimmtes Land
        String countryName = "Germany";
        List<EmissionsDate> emissionsData = emissionController.filterEmssionsDaten(countryName);

        System.out.println("Emissionsdaten für " + countryName + ":");

        for (EmissionsDate data : emissionsData) {
            System.out.println("ID: " + data.getId());
            System.out.println("Country Name: " + data.getCountry_name());
            System.out.println("Country Code: " + data.getCountry_code());
            System.out.println("Indicator Name: " + data.getIndicator_name());
            System.out.println("Date: " + data.getDate());
            System.out.println("Amount Value: " + data.getAmount_value());
            System.out.println();
        }
    }
}