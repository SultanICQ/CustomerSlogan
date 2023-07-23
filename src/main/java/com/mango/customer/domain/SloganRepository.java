package com.mango.customer.domain;

import com.mango.customer.domain.Slogan;

import java.util.List;

public interface SloganRepository {
	List<Slogan> get(String userName);
	void add(String userName, Slogan slogan);
}
