package com.gestion.empleados.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gestion.empleados.service.UserServiceImpl;
import com.gestion.empleados.util.CustomSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/users/**").permitAll()
			.antMatchers("/mascotas/**").permitAll()
			.antMatchers("/medicos/**").permitAll()
			.antMatchers("/servicios/**").permitAll()
			.antMatchers("/citas/**").permitAll()
			.antMatchers("/historiales/**").permitAll()
			.and().csrf().disable();
	}
}
