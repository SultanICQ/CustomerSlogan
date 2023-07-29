package com.mango.customer.infra;

import com.mango.customer.domain.Customer;
import com.mango.customer.domain.CustomerRepository;
import com.mango.customer.dto.UpdateCustomerDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

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
	public Optional<Customer> find(String userName) {
		return Optional.ofNullable(data.get(userName));
	}

	@Override
	public Optional<Customer> update(String username, UpdateCustomerDto updateCustomer) {
		Optional<Customer> oldCustomer = find(username);
		if ( oldCustomer.isEmpty()) { return Optional.empty(); }

		Customer newCustomer = new Customer(
			oldCustomer.get().getUserName(),
			updateCustomer.getName(),
			updateCustomer.getLastName(),
			updateCustomer.getAddress(),
			updateCustomer.getCity(),
			updateCustomer.getEmail(),
			oldCustomer.get().isTermsAndConditions()
		);

		this.data.put(username, newCustomer);

		return Optional.of(newCustomer);
	}
}
