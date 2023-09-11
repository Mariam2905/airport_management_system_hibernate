package org.example.service;

import org.example.domain_models.Passenger;
import org.example.domain_models.Trip;

import java.util.List;


public interface PassengerService {
    Passenger getById(long id);
    List<Passenger> getAll();
    List<Passenger> get(int offset, int perPage, String sort);
    Passenger save(Passenger passenger);
    Passenger update(Passenger passenger, long id);
    void delete(long passengerId);
    List<Passenger> getPassengersOfTrip(long tripNumber);
    void registerTrip(Trip trip, Passenger passenger);
    void cancelTrip(long passengerId, long tripNumber);
}