package com.mango.customer.service;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;
import com.mango.customer.exceptions.CustomerNotExistsException;
import com.mango.customer.domain.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCustomerService {

	private final CustomerRepository customerRepository;

	public UpdateCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer execute(String username, UpdateCustomerDto updateCustomer) {
		Optional<Customer> customer = customerRepository.find(username);
		if ( customer.isEmpty() ) {
			throw new CustomerNotExistsException();
		}

		Optional<Customer> updatedCustomer = customerRepository.update(username, updateCustomer);
		if ( updatedCustomer.isEmpty() ) {
			throw new CustomerNotExistsException();
		}

		return updatedCustomer.get();
	}

}
