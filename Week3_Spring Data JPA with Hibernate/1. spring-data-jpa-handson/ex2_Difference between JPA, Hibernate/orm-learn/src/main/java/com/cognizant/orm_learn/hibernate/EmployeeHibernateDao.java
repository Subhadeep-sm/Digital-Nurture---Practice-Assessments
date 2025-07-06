package com.cognizant.orm_learn.hibernate;

import com.cognizant.orm_learn.model.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeHibernateDao {
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(employee); // Replaces deprecated save()
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
