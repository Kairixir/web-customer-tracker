package com.sevcikondrej.DAO;

import com.sevcikondrej.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query and order by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);

        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();


        //return the results

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //save the customer
        currentSession.save(theCustomer);

    }

}


