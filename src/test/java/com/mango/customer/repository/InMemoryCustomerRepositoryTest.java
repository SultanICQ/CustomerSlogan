package com.mango.customer.repository;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;
import com.mango.customer.infra.InMemoryCustomerRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerRepositoryTest {

	private static final Customer CUSTOMER = new Customer(
		"username1",
		"David",
		"Garcia",
		"Mango Street 1",
		"Palau de Plegamans",
		"david.garcia@mango.com",
		true);
	private static final String USERNAME = "username1";
	private static final String NOT_FOUND_USERNAME = "notexists";
	private static final Customer NO_CUSTOMER = null;
	private static final UpdateCustomerDto UPDATE_CUSTOMER_DTO = new UpdateCustomerDto("NameModified",
		"LastNameModified",
		"AddressModified",
		"CityModified",
		"EmailModified");

	private final Customer UPDATED_CUSTOMER = new Customer("username1",
		"NameModified",
		"LastNameModified",
		"AddressModified",
		"CityModified",
		"EmailModified",
		true);

	private final InMemoryCustomerRepository sut = new InMemoryCustomerRepository();


	@Test
	void that_getting_valid_username_returns_customer() {
		Optional<Customer> result = sut.find(USERNAME);

		assertTrue(result.isPresent());
		assertEquals(CUSTOMER, result.get());
	}

	@Test
	void that_getting_non_existing_username_returns_null() {
		Optional<Customer> result = sut.find(NOT_FOUND_USERNAME);

		assertTrue(result.isEmpty());
	}

	@Test
	void that_updating_valid_user_returns_updated_customer() {
		Optional<Customer> result = sut.update(USERNAME, UPDATE_CUSTOMER_DTO);

		assertTrue(result.isPresent());
		assertEquals(UPDATED_CUSTOMER, result.get());
	}

	@Test
	void that_updating_non_existing_user_returns_null() {
		Optional<Customer> result = sut.update(NOT_FOUND_USERNAME, UPDATE_CUSTOMER_DTO);

		assertTrue(result.isEmpty());
	}


}
