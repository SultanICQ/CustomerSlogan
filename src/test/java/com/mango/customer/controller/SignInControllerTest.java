package com.mango.customer.controller;

import com.mango.customer.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SignInControllerTest {
	private static final String USERNAME = "username1";
	private static final String PASSWORD = "user1Pass";
	private static final String ENDPOINT = "/signin";

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
			.get(ENDPOINT)
		.then()
			.statusCode(200);
	}
	@Test
	void that_when_requesting_signin_data_is_valid_customer_data() {
		CustomerDto result = given()
			.auth().basic(USERNAME, PASSWORD)
		.when()
			.get(ENDPOINT)
		.then()
			.extract()
			.as(CustomerDto.class);

		assertThat(result).isEqualTo(CUSTOMER_DTO);
	}
	@Test
	void that_when_requesting_signin_data_without_user_is_unauthorized_status() {
		given()
		.when()
			.get(ENDPOINT)
		.then()
			.statusCode(401);
	}

}
