package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateConfigs {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
		.route(p -> p.path("/comments/**")
                .uri("lb://comment-service/comments"))
		.route(p -> p.path("/posts/**")
				.uri("lb://data-service/posts"))
		.build();
				
	}

}
// localhost:8765/comments/all