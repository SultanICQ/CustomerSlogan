package com.mango.customer.controller;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.CustomerDto;
import com.mango.customer.dto.UpdateCustomerDto;
import com.mango.customer.service.UpdateCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCustomerController {

	private UpdateCustomerService updateCustomerService;

	public UpdateCustomerController(UpdateCustomerService updateCustomerService) {
		this.updateCustomerService = updateCustomerService;
	}

	@PostMapping("/updateUser")
	public ResponseEntity<CustomerDto> updateUser(Authentication authentication, @RequestBody UpdateCustomerDto updateCustomer) {
		Customer customer = updateCustomerService.execute(authentication.getName(), updateCustomer);
		return ResponseEntity.ok( CustomerDto.from(customer) );
	}


}
