package com.chaoswang.fund.service;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class FundDataServiceConfiguration extends Configuration {
	@NotEmpty
	@JsonProperty
	private String template;

	@NotEmpty
	@JsonProperty
	private String defaultName = "Stranger";

	public String getDefaultName() {
		return defaultName;
	}

	public String getTemplate() {
		return template;
	}
}
