package org.example.domain_models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passenger_id;


    @Column
    private String passenger_name;

    @Column
    private String pass_phone;

    @Column
    private String pass_country;

    @Column
    private String pass_city;


//    @OneToMany(mappedBy = "passenger")
//    @JoinColumn(name = "passenger_id")
//    private Set<Pass_in_trip> pass_in_tripSet;

    public Passenger(Long passenger_id, String passenger_name, String pass_phone, String pass_country, String pass_city) {
        this.passenger_id = passenger_id;
        this.passenger_name = passenger_name;
        this.pass_phone = pass_phone;
        this.pass_country = pass_country;
        this.pass_city = pass_city;
    }

    public Passenger() {
    }

    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPass_phone() {
        return pass_phone;
    }

    public void setPass_phone(String pass_phone) {
        this.pass_phone = pass_phone;
    }

    public String getPass_country() {
        return pass_country;
    }

    public void setPass_country(String pass_country) {
        this.pass_country = pass_country;
    }

    public String getPass_city() {
        return pass_city;
    }

    public void setPass_city(String pass_city) {
        this.pass_city = pass_city;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passenger_id=" + passenger_id +
                ", passenger_name='" + passenger_name + '\'' +
                ", pass_phone='" + pass_phone + '\'' +
                ", pass_country='" + pass_country + '\'' +
                ", pass_city='" + pass_city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return passenger_id.equals(passenger.passenger_id) && passenger_name.equals(passenger.passenger_name) && pass_phone.equals(passenger.pass_phone) && pass_country.equals(passenger.pass_country) && pass_city.equals(passenger.pass_city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger_id, passenger_name, pass_phone, pass_country, pass_city);
    }
}