package com.mango.customer.controller;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.CustomerDto;
import com.mango.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SignInControllerTest {
	private static final UsernamePasswordAuthenticationToken AUTHENTICATION = new UsernamePasswordAuthenticationToken("username1", "", null);
	@Mock
	private CustomerService service;

	private SignInController sut;

	private final Customer CUSTOMER = new Customer("username1", "Name", "LastName", "Address", "City", "Email", true);
	private final CustomerDto CUSTOMER_DTO = new CustomerDto("Name", "LastName", "Address", "City", "Email", true);

	@BeforeEach
	void setUp() {
		 sut = new SignInController(service);
	}

	@Test
	void signin_returns_customer_data() throws Exception {
		given(service.find(any())).willReturn(CUSTOMER);
		ResponseEntity<CustomerDto> response = sut.signin(AUTHENTICATION);

		assertThat(response).isEqualTo(ResponseEntity.ok(CUSTOMER_DTO));
	}
}
