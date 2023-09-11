package org.example.domain_models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;



/**
 * This class represents a persistent class for Company.
 */

@Entity
@Table(name= "trip")
public class Trip {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int trip_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id",
            insertable = false, updatable = false)
    private Company company_id;




    @Column
    private String trip_organizer;
    @Column
    private String departure_city;
    @Column
    private String destination_city;
    @Column
    private Timestamp time_departure;
    @Column
    private Timestamp time_arrival;

//    @OneToMany(mappedBy = "trip")
//    @JoinColumn(name = "trip_id")
//    private Set<Pass_in_trip> pass_in_tripSet;



    // Constructor with all members
    public Trip(int trip_id, Company company_id, String trip_organizer, String departure_city,
                String destination_city, Timestamp time_departure, Timestamp time_arrival) {
        this.trip_id = trip_id;
        this.company_id = company_id;
        this.trip_organizer = trip_organizer;
        this.departure_city = departure_city;
        this.destination_city = destination_city;
        this.time_departure = time_departure;
        this.time_arrival = time_arrival;
    }



    //no-argument constructor
    public Trip(){}


    //getter and setter methods


    public int getTrip_id() {
        return trip_id;
    }
    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }



    public Company getCompany_id() {
        return company_id;
    }
    public void setCompany_id(Company company_id) {
        this.company_id = company_id;
    }

    public String getTrip_organizer() {
        return trip_organizer;
    }
    public void setTrip_organizer(String trip_organizer) {
        this.trip_organizer = trip_organizer;
    }

    public String getDeparture_city() {
        return departure_city;
    }
    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getDestination_city() {
        return destination_city;
    }
    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    public Timestamp getTime_departure() {
        return time_departure;
    }
    public void setTime_departure(Timestamp time_departure) {
        this.time_departure = time_departure;
    }

    public Timestamp getTime_arrival() {
        return time_arrival;
    }
    public void setTime_arrival(Timestamp time_arrival) {
        this.time_arrival = time_arrival;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "trip_id=" + trip_id +
                ", company_id=" + company_id +
                ", trip_organizer='" + trip_organizer + '\'' +
                ", departure_city='" + departure_city + '\'' +
                ", destination_city='" + destination_city + '\'' +
                ", time_departure=" + time_departure +
                ", time_arrival=" + time_arrival +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return trip_id == trip.trip_id && company_id == trip.company_id && trip_organizer.equals(trip.trip_organizer) && departure_city.equals(trip.departure_city) && destination_city.equals(trip.destination_city) && time_departure.equals(trip.time_departure) && time_arrival.equals(trip.time_arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trip_id, company_id, trip_organizer, departure_city, destination_city, time_departure, time_arrival);
    }
}