package com.mango.customer.domain;

import com.mango.customer.dto.UpdateCustomerDto;

import java.util.Optional;

public interface CustomerRepository {
	public Optional<Customer> find(String userName);
	public Optional<Customer> update(String username, UpdateCustomerDto updateCustomer);
}
