package com.EStockMarketApp.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
		.route( p-> p.path("/company/**").uri("lb://company-info-service"))
		.route(p-> p.path("/stock/**").uri("lb://stock-info-services"))
		.route(p-> p.path("/market/**").uri("lb://e-stock-market-app"))
		.build();
	}
}
