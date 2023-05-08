package EmissionPackage;

import EmissionPackage.EmissionController;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "CO2_TABLE")
public class EmissionsDate implements Serializable {


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getIndicator_name() {
        return indicator_name;
    }

    public void setIndicator_name(String indicator_name) {
        this.indicator_name = indicator_name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getAmount_value() {
        return amount_value;
    }

    public void setAmount_value(double amount_value) {
        this.amount_value = amount_value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String country_name;

    private String country_code;
    private String indicator_name;
    private int date;
    private double amount_value;


}
