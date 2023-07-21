package com.mango.customer.controller;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.CustomerDto;
import com.mango.customer.dto.UpdateCustomerDto;
import com.mango.customer.service.UpdateCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerControllerTest {
	private static final UsernamePasswordAuthenticationToken AUTHENTICATION = new UsernamePasswordAuthenticationToken("username1", "", null);

	private static final String USERNAME = "username1";
	private final Customer CUSTOMER = new Customer("username1", "Name", "LastName", "Address", "City", "Email", true);
	private final CustomerDto CUSTOMER_DTO = new CustomerDto("Name", "LastName", "Address", "City", "Email", true);
	private final UpdateCustomerDto UPDATE_CUSTOMER_DTO = new UpdateCustomerDto("Name",
		"LastName",
		"Address",
		"City",
		"Email");

	@Mock
	private UpdateCustomerService service;
	private UpdateCustomerController sut;

	@BeforeEach
	void setUp() {
		sut = new UpdateCustomerController(service);
	}


	@Test
	void update_user_returns_updated_data() {
		given(service.execute(USERNAME, UPDATE_CUSTOMER_DTO)).willReturn(CUSTOMER);
		ResponseEntity<CustomerDto> response = sut.updateUser(AUTHENTICATION, UPDATE_CUSTOMER_DTO);

		assertThat(response).isEqualTo(ResponseEntity.ok(CUSTOMER_DTO));
	}
}
