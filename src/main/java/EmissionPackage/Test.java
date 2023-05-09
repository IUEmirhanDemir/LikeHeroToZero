package EmissionPackage;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        EmissionBean bean = new EmissionBean();

        // Test der getCountries-Methode
        List<EmissionsDate> countries = bean.getEmissionsDates();
        for (EmissionsDate country : countries) {
            System.out.println("Country Name: " + country.getCountry_name());
            System.out.println("Country Code: " + country.getCountry_code());
            System.out.println("Indicator: " + country.getIndicator_name());
            System.out.println("Year: " + country.getDate());
            System.out.println("CO2 Emissions: " + country.getAmount_value());
            System.out.println("-----------------------------");
        }



    }
}
