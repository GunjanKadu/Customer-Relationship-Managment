package com.gk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gk.entity.Customer;

// Always applied to DAO implementation
@Repository
public class CustomerDAOImpl implements CustomerDao {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	// Using Transaction so that we dont need to start and end the session
	@Override
	public List<Customer> getCustomers() {

		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query...sort by lastname
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer to the db
		currentSession.save(theCustomer);

	}

	@Override
	public Customer getCustomers(int theId) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get the data from the db based on the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

}
