package com.mango.customer.dto;

import com.mango.customer.domain.Customer;

import java.util.Objects;

public class UpdateCustomerDto {
	private String name;
	private String lastName;
	private String address;
	private String city;
	private String email;

	public UpdateCustomerDto(String name, String lastName, String address, String city, String email) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.email = email;
	}

	public static UpdateCustomerDto from(Customer customer) {
		return new UpdateCustomerDto(customer.getName(),
			customer.getLastName(),
			customer.getAddress(),
			customer.getCity(),
			customer.getEmail());
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UpdateCustomerDto that = (UpdateCustomerDto) o;
		return Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, lastName, address, city, email);
	}
}
