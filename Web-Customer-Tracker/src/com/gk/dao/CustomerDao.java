package com.gk.dao;

import java.util.List;

import com.gk.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
