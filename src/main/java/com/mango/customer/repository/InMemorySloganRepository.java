package com.mango.customer.repository;

import com.mango.customer.domain.Slogan;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemorySloganRepository implements SloganRepository {
	private HashMap<String, List<Slogan>> data;

	public InMemorySloganRepository() {
		this.data = new HashMap<>();
	}

	@Override
	public List<Slogan> get(String userName) {
		return this.data.get(userName);
	}

	@Override
	public void add(String userName, Slogan slogan) {
		List<Slogan> slogans = this.data.get(userName);
		if (slogans == null) {
			slogans = Collections.emptyList();
		}
		slogans.add(slogan);
		this.data.put(userName, slogans);
	}
}


