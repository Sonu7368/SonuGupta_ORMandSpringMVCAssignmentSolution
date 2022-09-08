package com.greatlearning.crm_assignment.service;

import java.util.List;

import com.greatlearning.crm_assignment.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomerList();
	public Customer getCustomer(int id);
	public void delete(int id);
	public void save(Customer customer);
}
