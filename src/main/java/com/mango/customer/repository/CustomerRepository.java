package com.mango.customer.repository;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;

public interface CustomerRepository {
	public Customer find(String userName);
	public Customer update(String username, UpdateCustomerDto updateCustomer);
}
