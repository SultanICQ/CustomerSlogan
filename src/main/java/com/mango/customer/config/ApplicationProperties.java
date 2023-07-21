package com.mango.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class ApplicationProperties {

	private static final String SLOGANS_MAX_PERMITTED = "slogans.max_permitted";

	@Bean
	public int MAX_SLOGANS(Environment env) {
		if ( env.getProperty(SLOGANS_MAX_PERMITTED) == null )
		{
			return 0;
		}
		return Integer.parseInt(env.getProperty(SLOGANS_MAX_PERMITTED));
	}
}
