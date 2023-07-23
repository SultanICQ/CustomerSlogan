package com.mango.customer.domain;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;

public interface CustomerRepository {
	public Customer find(String userName);
	public Customer update(String username, UpdateCustomerDto updateCustomer);
}
