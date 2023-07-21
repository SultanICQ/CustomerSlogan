package com.mango.customer.controller;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.CustomerDto;
import com.mango.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {

	private CustomerService customerService;

	public SignInController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/signin")
	public ResponseEntity<CustomerDto> signin(Authentication authentication) {
		Customer customer = customerService.find(authentication.getName());
		return ResponseEntity.ok( CustomerDto.from(customer) );
	}

}
