package com.mango.customer.controller;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.CustomerDto;
import com.mango.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SignInControllerTest {
	private static final String USERNAME = "username1";
	private static final String PASSWORD = "user1Pass";

	private final CustomerDto CUSTOMER_DTO = new CustomerDto(
		"David",
		"Garcia",
		"Mango Street 1",
		"Palau de Plegamans",
		"david.garcia@mango.com",
		true);

	@Test
	void that_when_requesting_signin_data_is_ok_status() {
		given()
			.auth().basic(USERNAME, PASSWORD)
		.when()
			.get("/signin")
		.then()
			.statusCode(200);
	}
	@Test
	void that_when_requesting_signin_data_is_valid_customer_data() {
		CustomerDto result = given()
			.auth().basic(USERNAME, PASSWORD)
		.when()
			.get("/signin")
		.then()
			.extract()
			.as(CustomerDto.class);

		assertThat(result).isEqualTo(CUSTOMER_DTO);
	}
	@Test
	void that_when_requesting_signin_data_without_user_is_unauthorized_status() {
		given()
		.when()
			.get("/signin")
		.then()
			.statusCode(401);
	}

}
