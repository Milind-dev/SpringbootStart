package com.milinddev.expensetrackerapi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.milinddev.expensetrackerapi.security.CustomUserDetailsService;

@Configuration
public class webSecurityConfig extends webSecurityConfigureAdapter{ //webSecurityConfigureAdapter are depressiated in 3.5
	
	
	private CustomUserDetailsService userDetailsService;
	
	@Overide
	protected void configure(Httpsecurity http) throws Exception{
		http
		   .csrf().disable()
		   .autorizeRequest()
		   .anyMatchers("/login","/register").permitAll()
		   .anyRequest().authenticate()
		   .and()
		   .httpBasics();
	}
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		UserDetails user1 = User.withUsername("milind").password("12345").authorities("admin").build();
//		UserDetails user2 = User.withUsername("pant").password("12345").authorities("user").build();
//		userDetailsService.createUser(user1);
//		userDetailsService.createUser(user2);
//		auth.userDetailsService(userDetailsService);
////		auth.inMemoryAuthentication()
////		.withUser("milind").password("12345").authorities("admin")
////		.and()
////		.withUser("pant").password("12345").authorities("user")
////		.and()
////		.passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}
//	

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		
	}

	@Bean
	public PasswordEncoder passwordEndEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
