package com.mango.customer.domain;

import java.util.Objects;

public class Customer {
	private String userName;
	private String name;
	private String lastName;
	private String address;
	private String city;
	private String email;
	private boolean termsAndConditions;

	public Customer(String userName, String name, String lastName, String address, String city, String email, boolean termsAndConditions) {
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.email = email;
		this.termsAndConditions = termsAndConditions;
	}

	public String getUserName() {
		return userName;
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

	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return termsAndConditions == customer.termsAndConditions && Objects.equals(userName, customer.userName) && Objects.equals(name, customer.name) && Objects.equals(lastName, customer.lastName) && Objects.equals(address, customer.address) && Objects.equals(city, customer.city) && Objects.equals(email, customer.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName, name, lastName, address, city, email, termsAndConditions);
	}
}
