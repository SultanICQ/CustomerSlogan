package com.mango.customer.controller;

import com.mango.customer.domain.Customer;
import com.mango.customer.dto.CustomerDto;
import com.mango.customer.dto.UpdateCustomerDto;
import io.restassured.RestAssured;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(MockitoExtension.class)
class UpdateCustomerControllerTest {
	private static final UsernamePasswordAuthenticationToken AUTHENTICATION = new UsernamePasswordAuthenticationToken("username1", "", null);

	private static final String USERNAME = "username1";
	private static final String PASSWORD = "user1Pass";
	private static final String ENDPOINT = "/updateUser";
	private final Customer CUSTOMER = new Customer("username1", "Name", "LastName", "Address", "City", "Email", true);
	private final CustomerDto CUSTOMER_DTO = new CustomerDto("Name", "LastName", "Address", "City", "Email", true);
	private final UpdateCustomerDto UPDATE_CUSTOMER_DTO = new UpdateCustomerDto("Name",
		"LastName",
		"Address",
		"City",
		"Email");

	@Test
	void that_when_updating_user_data_without_user_is_unauthorized_status() {
		RestAssured.given()
			.when()
			.post(ENDPOINT)
			.then()
			.statusCode(401);
	}
	@Test
	void that_when_updating_valid_user_data_response_is_ok() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("name", "Pepe");

		CustomerDto result = RestAssured.given()
			.header("Content-Type", "application/json")
			.auth().basic(USERNAME, PASSWORD)
			.when()
			.body(json.toString())
			.post(ENDPOINT)
			.then()
			.statusCode(200)
			.extract()
			.as(CustomerDto.class);

		assertThat(result.getName()).isEqualTo("Pepe");
	}
}
