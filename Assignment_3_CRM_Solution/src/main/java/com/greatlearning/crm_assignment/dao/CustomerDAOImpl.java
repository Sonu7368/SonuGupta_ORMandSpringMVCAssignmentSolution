package com.greatlearning.crm_assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.crm_assignment.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	private Session getSessionViaFactory() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (Exception ex) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@Override
	public List<Customer> getCustomerList() {
		Session session = getSessionViaFactory();
		session.beginTransaction();
		
		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		session.getTransaction().commit();
		
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = getSessionViaFactory();
		session.beginTransaction();

		Customer customer = session.get(Customer.class, id);
		session.getTransaction().commit();

		return customer;
	}

	@Override
	public void delete(int id) {
		Session session = getSessionViaFactory();
		session.beginTransaction();

		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void save(Customer customer) {
		Session session = getSessionViaFactory();
		session.beginTransaction();

		session.saveOrUpdate(customer);
		session.getTransaction().commit();

	}
}
