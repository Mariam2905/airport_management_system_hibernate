package org.example.domain_models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "pass_in_trip")
public class Pass_in_trip {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;


    @OneToMany(mappedBy="pass_in_trip")
    private java.util.Set<Trip> trips;

    @OneToMany(mappedBy="pass_in_trip")
    private Set<Passenger> passengers;

    @Column
    private Timestamp date;


    @Column
    private String place;


    public Pass_in_trip(int id, Set<Trip> trips, Set<Passenger> passengers, Timestamp date, String place) {


        this.id = id;
        this.trips = trips;
        this.passengers = passengers;
        this.date = date;
        this.place = place;
    }

    public Pass_in_trip(){
    }

    public int getId() {
        return id;
    }
    public void setId(int id ) {
        this.id = id;
    }



    public Set<Trip> getTrips() {
        return trips;
    }
    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }



    public Set<Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }



    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }



    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }



    @Override
    public String toString() {
        return "Pass_in_trip{" +
                "trip_id=" + trips +
                ", passengers=" + passengers +
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pass_in_trip that = (Pass_in_trip) o;
        return id == that.id && trips.equals(that.trips) && passengers.equals(that.passengers) && date.equals(that.date) && place.equals(that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trips, passengers, date, place);
    }
}