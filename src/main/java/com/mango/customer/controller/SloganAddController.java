package com.mango.customer.controller;

import com.mango.customer.service.SloganAddService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SloganAddController {

	private SloganAddService sloganService;

	public SloganAddController(SloganAddService sloganService) {
		this.sloganService = sloganService;
	}

	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody String slogan) {
		sloganService.execute("username1", slogan);
		return ResponseEntity.ok("");
	}


}
