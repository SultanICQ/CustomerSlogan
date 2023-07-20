package com.mango.customer.repository;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;

public interface SloganRepository {
	public Customer add(String userName, String slogan);
}
