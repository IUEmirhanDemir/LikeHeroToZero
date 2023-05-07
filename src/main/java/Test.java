
import java.sql.*;
import org.h2.*;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:/Users/emir/Desktop/HeroProject/src/main/resources/DatabaseCO2");
            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM CO2_Table";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String countryName = rs.getString("country_name");
                String countryCode = rs.getString("country_code");
                String indicatorName = rs.getString("indicator_name");
                int date = rs.getInt("date");
                double amountValue = rs.getDouble("amount_value");

                System.out.printf("%s (%s), %s, %d, %.2f%n", countryName, countryCode, indicatorName, date, amountValue);
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

