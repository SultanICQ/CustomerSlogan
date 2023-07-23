package com.mango.customer.infra;

import com.mango.customer.domain.Slogan;
import com.mango.customer.domain.SloganRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
		List<Slogan> slogans = this.data.get(userName);
		if (slogans == null) {
			slogans = new ArrayList<>();
		}
		return slogans;
	}

	@Override
	public void add(String userName, Slogan slogan) {
		List<Slogan> slogans = this.get(userName);
		slogans.add(slogan);
		this.data.put(userName, slogans);
	}
}


