package org.example.service_imp;


import jakarta.persistence.TypedQuery;

import org.example.domain_models.Passenger;
import org.example.domain_models.Trip;
import org.example.hibernate_util.HibernateUtil;
import org.example.service.PassengerService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PassengerServiceImpl implements PassengerService {
    List passengerList = new ArrayList<>();


    /**
     * Method gets the passenger data by passenger_id.
     * @return passenger data
     */
    @Override
    public Passenger getById(long id) {
        Passenger passenger;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            passenger = session.get(Passenger.class, id);
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return passenger;
    }
    /**
     * Method gets all passenger data from passenger table.
     * @return all information about all the passengers from table passenger.
     */
    @Override
    public List<Passenger> getAll() {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            List<Passenger> passengerList = session.createQuery("FROM Passenger ").list();
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return passengerList;
    }


    /**
     * Method gets passenger data by pages.
     * @param offset from which passenger should be shown the page.
     * @param perPage how many passengers are being shown in a page
     * @param sort by which column of the passenger table
     * @return the sorted passenger data from some point to some point.
     */
    @Override
    public List<Passenger> get(int offset, int perPage, String sort) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String query = "select p from Passenger p where p.passenger_id >= :offset order by p." + sort;
            TypedQuery<Passenger> typedQuery = session.createQuery(query,Passenger.class);
            typedQuery.setParameter("offset", offset);
            typedQuery.setMaxResults(perPage);
            List<Passenger> passengerList = typedQuery.getResultList();
            session.getTransaction().commit();
        }catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return passengerList;
    }


    /**
     * Saves a new passenger into our passenger entity.
     * @param passenger will be saved
     * @return saves passenger
     */
    @Override
    public Passenger save(Passenger passenger) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.persist(passenger);
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
        return passenger;
    }


    /**
     * Updates passenger by its id
     * @param passenger
     * @return the updated passenger
     */
    @Override
    public Passenger update(Passenger passenger, long id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            passenger.setPassenger_id(id);
            session.merge(passenger);
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
        return passenger;
    }


    /**
     * Deletes a passenger from an entity by passenger_id
     * @param passengerId
     */
    @Override
    public void delete(long passengerId) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.remove(session.get(Passenger.class, passengerId));
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

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {
    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}