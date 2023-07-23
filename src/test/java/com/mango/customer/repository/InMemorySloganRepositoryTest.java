package com.mango.customer.repository;

import com.mango.customer.domain.Slogan;
import com.mango.customer.infra.InMemorySloganRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemorySloganRepositoryTest {

	private static final String USERNAME = "username";
	private static final String SLOGAN_VALUE = "lorem";
	private static final Slogan SLOGAN = new Slogan(SLOGAN_VALUE);

	private InMemorySloganRepository sut = new InMemorySloganRepository();

	@Test
	void that_get_slogans_for_non_existing_user_returns_empty_collection() {
		List<Slogan> result = sut.get(USERNAME);

		assertEquals(Collections.emptyList(), result);
	}

	@Test
	void that_adding_slogans_work() {
		sut.add(USERNAME, SLOGAN);

		List<Slogan> result = sut.get(USERNAME);

		assertEquals(1, result.size());
	}
}
