package com.mango.customer.dto;

import com.mango.customer.domain.Customer;

import java.util.Objects;

public class CustomerDto {
	private String name;
	private String lastName;
	private String address;
	private String city;
	private String email;
	private boolean termsAndConditions;

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	public CustomerDto(String name, String lastName, String address, String city, String email, boolean termsAndConditions) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.email = email;
		this.termsAndConditions = termsAndConditions;
	}

	public static CustomerDto from(Customer customer) {
		return new CustomerDto(customer.getName(),
			customer.getLastName(),
			customer.getAddress(),
			customer.getCity(),
			customer.getEmail(),
			customer.isTermsAndConditions());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerDto that = (CustomerDto) o;
		return termsAndConditions == that.termsAndConditions && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, lastName, address, city, email, termsAndConditions);
	}
}
