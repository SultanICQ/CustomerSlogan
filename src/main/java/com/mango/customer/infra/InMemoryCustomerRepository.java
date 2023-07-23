package com.mango.customer.infra;

import com.mango.customer.domain.Customer;
import com.mango.customer.domain.CustomerRepository;
import com.mango.customer.dto.UpdateCustomerDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private HashMap<String, Customer> data;

	public InMemoryCustomerRepository() {
		this.data = new HashMap<>();
		this.data.put("username1", new Customer(
			"username1",
			"David",
			"Garcia",
			"Mango Street 1",
			"Palau de Plegamans",
			"david.garcia@mango.com",
			true));
	}

	@Override
	public Customer find(String userName) {
		return data.get(userName);
	}

	@Override
	public Customer update(String username, UpdateCustomerDto updateCustomer) {
		Customer oldCustomer = find(username);
		if ( oldCustomer == null ) { return null; }

		Customer newCustomer = new Customer(
			oldCustomer.getUserName(),
			updateCustomer.getName(),
			updateCustomer.getLastName(),
			updateCustomer.getAddress(),
			updateCustomer.getCity(),
			updateCustomer.getEmail(),
			oldCustomer.isTermsAndConditions()
		);

		this.data.put(username, newCustomer);

		return newCustomer;
	}
}
