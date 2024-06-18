package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class DemoConfigurations {
     @Bean
     SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception{
    	 http.authorizeHttpRequests(
    			 requests -> requests.requestMatchers(
    					 
    			))
    
    	 return http.build();
     }
}
