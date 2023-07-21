package com.mango.customer.service;

import com.mango.customer.domain.Slogan;
import com.mango.customer.exceptions.MaxSlogansReachedForCustomer;
import com.mango.customer.repository.SloganRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SloganAddService {
	private int MAX_SLOGANS = 3;
	private final SloganRepository repository;

	public SloganAddService(SloganRepository repository, int MAX_SLOGANS) {
		this.repository = repository;
		this.MAX_SLOGANS = MAX_SLOGANS;
	}

	public void execute(String userName, String value) {
		List<Slogan> slogans = repository.get(userName);
		if (slogans.size() >= MAX_SLOGANS) {
			throw new MaxSlogansReachedForCustomer();
		}
		repository.add(userName, new Slogan(value));
	}
}
