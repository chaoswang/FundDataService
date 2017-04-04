package com.chaoswang.fund.service;

import com.chaoswang.fund.service.health.TemplateHealthCheck;
import com.chaoswang.fund.service.resources.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FundDataServiceApplication extends Application<FundDataServiceConfiguration> {

	public static void main(final String[] args) throws Exception {
		new FundDataServiceApplication().run(args);
	}

	@Override
	public String getName() {
		return "FundDataService";
	}

	@Override
	public void initialize(final Bootstrap<FundDataServiceConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final FundDataServiceConfiguration configuration, final Environment environment) {
		final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(),
				configuration.getDefaultName());
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
	}

}
