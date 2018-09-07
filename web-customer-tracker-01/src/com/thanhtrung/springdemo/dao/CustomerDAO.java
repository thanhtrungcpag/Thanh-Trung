package com.thanhtrung.springdemo.dao;

import java.util.List;

import com.thanhtrung.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);	
}
