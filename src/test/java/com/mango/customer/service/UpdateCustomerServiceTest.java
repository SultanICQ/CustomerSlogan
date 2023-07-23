package com.mango.customer.service;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.UpdateCustomerDto;
import com.mango.customer.exceptions.CustomerNotExistsException;
import com.mango.customer.domain.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerServiceTest {

	private static final String USERNAME = "username1";
	private static final Customer NO_CUSTOMER = null;
	private final Customer CUSTOMER = new Customer("username1", "Name", "LastName", "Address", "City", "Email", true);
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

	@Mock
	private static CustomerRepository repository;

	private static UpdateCustomerService sut;

	@BeforeEach
	void setUp() {
		sut = new UpdateCustomerService(repository);
	}

	@Test
	void that_update_existing_user_modify_data() {
		given(repository.find(USERNAME)).willReturn(CUSTOMER);
		given(repository.update(USERNAME, UPDATE_CUSTOMER_DTO)).willReturn(UPDATED_CUSTOMER);

		Customer updated = sut.execute(USERNAME, UPDATE_CUSTOMER_DTO);

		assertEquals(UPDATED_CUSTOMER, updated);
	}

	@Test
	void that_update_non_existing_user_throwns_exception() {
		given(repository.find(USERNAME)).willReturn(NO_CUSTOMER);

		assertThrows(CustomerNotExistsException.class, () -> sut.execute(USERNAME, UPDATE_CUSTOMER_DTO) );
	}
}
