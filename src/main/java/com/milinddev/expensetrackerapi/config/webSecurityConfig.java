package com.milinddev.expensetrackerapi.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class webSecurityConfig extends webSecurityConfigureAdapter{ //webSecurityConfigureAdapter are depressiated in 3.5
	
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
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("milind").password("12345").authorities("admin")
		.and()
		.withUser("pant").password("12345").authorities("user")
		.and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
}
