package com.mango.customer.service;

import com.mango.customer.domain.Customer;
import com.mango.customer.exceptions.CustomerNotExistsException;
import com.mango.customer.domain.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer find(String userName) {
		Customer customer = customerRepository.find(userName);
		if (customer == null) {
			throw new CustomerNotExistsException();
		}
		return customer;
	}
}
