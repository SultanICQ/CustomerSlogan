package com.mango.customer.service;

import com.mango.customer.domain.Slogan;
import com.mango.customer.exceptions.MaxSlogansReachedForCustomer;
import com.mango.customer.repository.SloganRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SloganAddServiceTest {

	private static final String USERNAME = "username";
	private static final String SLOGAN_VALUE = "lorem ipsum";
	private static final Slogan SLOGAN = new Slogan(SLOGAN_VALUE);
	private static final int MAX_SLOGANS = 3;

	@Mock
	private SloganRepository repository;
	private SloganAddService sut;

	@BeforeEach
	void setUp() {
		sut = new SloganAddService(repository, MAX_SLOGANS);
	}

	@Test
	void that_first_added_slogan_is_added_without_problem() {
		given(repository.get(USERNAME)).willReturn(Collections.emptyList());

		sut.execute(USERNAME, SLOGAN_VALUE);
	}

	@Test
	void that_try_to_add_more_slogans_than_permitted_3_throw_an_exception() {
		given(repository.get(USERNAME)).willReturn(List.of(SLOGAN, SLOGAN, SLOGAN));

		assertThrows( MaxSlogansReachedForCustomer.class, () -> {
			sut.execute(USERNAME, SLOGAN_VALUE);
		});
	}

}
