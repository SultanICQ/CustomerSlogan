package com.mango.customer.service;

import com.mango.customer.domain.Customer;
import com.mango.customer.exceptions.CustomerNotExistsException;
import com.mango.customer.domain.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	private static final String USERNAME = "username";
	private final Customer CUSTOMER = new Customer("username1", "Name", "LastName", "Address", "City", "Email", true);
	@Mock
	private CustomerRepository repository;

	private CustomerService sut;

	@BeforeEach
	void setUp() {
		sut = new CustomerService(repository);
	}

	@Test
	void that_asking_for_existing_user_returns_data() {
		given(repository.find(USERNAME)).willReturn(Optional.of(CUSTOMER));

		Customer result = sut.find(USERNAME);

		assertEquals(CUSTOMER, result);
	}

	@Test
	void that_asking_for_non_existing_user_throws_exception() {
		given(repository.find(USERNAME)).willReturn(Optional.empty());

		assertThrows(CustomerNotExistsException.class, ()-> sut.find(USERNAME));
	}
}
