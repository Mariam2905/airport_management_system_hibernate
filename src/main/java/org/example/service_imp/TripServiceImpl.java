package org.example.service_imp;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import org.example.domain_models.Trip;
import org.example.hibernate_util.HibernateUtil;
import org.example.service.TripService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class TripServiceImpl implements TripService {
    List tripList = new ArrayList<>();

    /**
     * Method gets the trip data by trip_id.
     * @return trip data
     */
    @Override
    public Trip getById(long id) {
        Trip trip;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            trip = session.get(Trip.class, id);
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return trip;
    }


    /**
     * Method gets all trips data from trip table.
     * @return all information about all the trips from entity trip.
     */
    @Override
    public List<Trip> getAll() {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            List<Trip> tripList = session.createQuery("FROM Trip ").list();
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return tripList;
    }

    /**
     * Method gets trip data by pages.
     * @param offset from which trip should be shown the page.
     * @param perPage how many trips are being shown in a page
     * @param sort by which column of the trip table
     * @return the sorted trip data from some point to some point.
     */
    @Override
    public List<Trip> get(int offset, int perPage, String sort) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String query = "select t from Trip t where t.trip_id >= :offset order by t." + sort;
            TypedQuery<Trip> typedQuery = session.createQuery(query,Trip.class);
            typedQuery.setParameter("offset", offset);
            typedQuery.setMaxResults(perPage);
            List<Trip> tripList = typedQuery.getResultList();
            session.getTransaction().commit();
        }catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return tripList;
    }


    /**
     * Saves a new trip into our passenger entity.
     * @param trip will be saved
     * @return saves trip
     */
    @Override
    public Trip save(Trip trip) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.persist(trip);
            transaction.commit();
        }
        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return trip;
    }


    /**
     * Updates trip by its id
     * @param trip
     * @return the updated trip
     */
    @Override
    public Trip update(Trip trip, int id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            trip.setTrip_id(id);
            session.merge(trip);
            transaction.commit();
        }
        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return trip;
    }


    /**
     * Deletes a trip from an entity by trip_id
     * @param tripId
     */
    @Override
    public void delete(long tripId) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.remove(session.get(Trip.class, tripId));
            transaction.commit();
        }
        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
    }


    /**
     * Gets all the trips by departure city
     * @param city from which the trip begins
     * @return trips list
     */
    @Override
    public List<Trip> getTripsFrom(String city) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("Select t FROM Trip t WHERE t.departure_city = :city");
            query.setParameter("city", city);
            List<Trip> tripList = query.getResultList();
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return tripList;
    }


    /**
     * Gets all the trips by destination city
     * @param city from which the trip ends
     * @return trips list
     */
    @Override
    public List<Trip> getTripsTo(String city) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("Select t FROM Trip t WHERE t.destination_city = :city");
            query.setParameter("city", city);
            List<Trip> tripList = query.getResultList();
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return tripList;
    }
}