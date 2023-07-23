package com.mango.customer.repository;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;
import com.mango.customer.infra.InMemoryCustomerRepository;
import org.junit.jupiter.api.Test;

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
	private static final Short NO_CUSTOMER = null;
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
		Customer result = sut.find(USERNAME);

		assertEquals(CUSTOMER, result);
	}

	@Test
	void that_getting_non_existing_username_returns_null() {
		Customer result = sut.find(NOT_FOUND_USERNAME);

		assertEquals(NO_CUSTOMER, result);
	}

	@Test
	void that_updating_valid_user_returns_updated_customer() {
		Customer result = sut.update(USERNAME, UPDATE_CUSTOMER_DTO);

		assertEquals(UPDATED_CUSTOMER, result);
	}

	@Test
	void that_updating_non_existing_user_returns_null() {
		Customer result = sut.update(NOT_FOUND_USERNAME, UPDATE_CUSTOMER_DTO);

		assertEquals(NO_CUSTOMER, result);
	}


}
