package org.example.hibernate_util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This is a utility class for getting hibernate session object.
 */
public class HibernateUtil {
    public static SessionFactory factory;
//to disallow creating objects by other classes.

    private HibernateUtil() {
    }
// Hibernate SessionFactory object as singleton

    public static synchronized SessionFactory getSessionFactory() {

        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return factory;
    }

}