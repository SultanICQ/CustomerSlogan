package com.mango.customer.service;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;
import com.mango.customer.exceptions.CustomerNotExistsException;
import com.mango.customer.domain.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

	private final CustomerRepository customerRepository;

	public UpdateCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer execute(String username, UpdateCustomerDto updateCustomer) {
		Customer customer = customerRepository.find(username);
		if ( customer == null ) {
			throw new CustomerNotExistsException();
		}

		return customerRepository.update(username, updateCustomer);
	}

}
