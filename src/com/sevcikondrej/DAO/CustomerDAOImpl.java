package com.sevcikondrej.DAO;

import com.sevcikondrej.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.Queryable;
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
        //save/update the customer
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //get customer
        Customer theCustomer = currentSession.get(Customer.class,theId);
        //send customer to the service

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //delete customer
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        //executing the update
        theQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;
        //query list of customers using name
        if (theSearchName!= null && theSearchName.trim().length()>0){
            theQuery = currentSession.createQuery("from Customer where lower(firstName) LIKE :searchName " +
                    "OR lower(lastName) LIKE :searchName",Customer.class );

        theQuery.setParameter("searchName","%"+theSearchName.toLowerCase()+"%");
        //get list of customers LIKE name
        }
        else{
            //the search name is empty so just get all the customers
            theQuery = currentSession.createQuery("from Customer",Customer.class);
        }
        List<Customer> customers = theQuery.getResultList();


        return customers;
    }

}


