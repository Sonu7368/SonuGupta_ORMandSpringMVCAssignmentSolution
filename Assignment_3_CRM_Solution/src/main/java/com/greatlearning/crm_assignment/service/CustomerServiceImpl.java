package com.greatlearning.crm_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.crm_assignment.dao.CustomerDAO;
import com.greatlearning.crm_assignment.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	

	@Override
	public List<Customer> getCustomerList() {
		return customerDAO.getCustomerList();
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	public void delete(int id) {
		customerDAO.delete(id);
	}

	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

}
