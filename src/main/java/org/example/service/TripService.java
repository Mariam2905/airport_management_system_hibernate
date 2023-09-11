package org.example.service;

import org.example.domain_models.Trip;

import java.util.List;


public interface TripService {

    Trip getById(long id);
    List<Trip> getAll();
    List<Trip> get(int offset, int perPage, String sort);
    Trip save(Trip passenger);
    Trip update(Trip passenger, int id);
    void delete(long tripId);
    List<Trip> getTripsFrom(String city);
    List<Trip> getTripsTo(String city);


}