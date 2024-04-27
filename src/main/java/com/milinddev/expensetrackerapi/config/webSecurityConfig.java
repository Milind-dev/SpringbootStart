package com.milinddev.expensetrackerapi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.milinddev.expensetrackerapi.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {
	
	
	private CustomUserDetailsService userDetailsService;
//	private AuthenticationManager authenticationManager;
	
//	@Overide
//	protected void configure(Httpsecurity http) throws Exception{
//		http
//		   .csrf().disable()
//		   .autorizeRequest()
//		   .anyMatchers("/login","/register").permitAll()
//		   .anyRequest().authenticate()
//		   .and()
//		   .httpBasics();
//	}
	

	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http
//	        .csrf().disable()
//	        .authorizeRequests()
//	            .requestMatchers("/login", "/register").permitAll()
//	            .anyRequest().authenticated()
//	        .and()
//	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	        .and()
//	        .httpBasic();
//	    return http.build();
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http
//		.csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers("/login", "/register").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//		http.httpBasic();
//		return http.build();
//	}
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

//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}

	@Bean
	public PasswordEncoder passwordEndEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();	
	}
	
//	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEndEncoder());
		
		return authProvider;
	}
	
//	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
}
