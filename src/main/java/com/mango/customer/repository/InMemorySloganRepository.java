package com.mango.customer.repository;

import com.mango.customer.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class InMemorySloganRepository implements SloganRepository {

	private HashMap<String, List<String>> data;

	public InMemorySloganRepository() {
		this.data = new HashMap<>();
	}

	@Override
	public Customer add(String userName, String slogan) {
		if ( this.data.get(userName).size() > 3 ) throw RuntimeException();

	}
}
