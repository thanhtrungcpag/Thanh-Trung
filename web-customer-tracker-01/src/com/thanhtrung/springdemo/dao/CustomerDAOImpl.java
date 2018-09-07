package com.thanhtrung.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thanhtrung.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get sesson
		Session session = sessionFactory.getCurrentSession();
		// activity
		
		Query<Customer> theQuery = 
				session.createQuery("from Customer order by lastName", Customer.class);
		// Execute query and get result list
		
		List<Customer> customer = theQuery.getResultList();
		
			return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get session
		Session session = sessionFactory.getCurrentSession();
		
		// save
		
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
