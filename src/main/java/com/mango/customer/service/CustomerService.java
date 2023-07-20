package com.mango.customer.service;

import com.mango.customer.domain.Customer;
import com.mango.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer find(String userName) {
		return customerRepository.find(userName);
	}
}
