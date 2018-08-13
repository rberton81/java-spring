package com.springmvc.demo.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
//@ComponentScan("com.springmvc.demo.conf")
public class MvcSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
		
	private static String REALM = "MY_TEST_REALM";

//	@Autowired
//	private CustomAuthenticationProvider authProvider;

//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("DEBUT DS");
//		System.out.println(dataSource.getConnection().getMetaData());
//		System.out.println(dataSource.getConnection().getClientInfo());
//		System.out.println(dataSource.getConnection().getCatalog());
//		System.out.println(dataSource.getConnection().getSchema());
//		System.out.println("FIN DS");
//		auth.authenticationProvider(authProvider);
//	   auth.jdbcAuthentication().dataSource(dataSource)
//	  .usersByUsernameQuery(
//	   "select name,password from user where name=?");
//	  .authoritiesByUsernameQuery(
//	   "select firstname from user where firstname=?");
//	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.headers().frameOptions().disable();
		
		httpSecurity.authorizeRequests().antMatchers("/login/logintest").authenticated().antMatchers("/**").permitAll()
				.and().formLogin().loginPage("/login/login").permitAll().and().logout().permitAll();
		
		
		httpSecurity.csrf().disable().authorizeRequests()
				.antMatchers("/user/**").hasRole("USER")
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);// We don't need
																									// sessions to be
																									// created.;
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();

//        auth.inMemoryAuthentication()
//        .passwordEncoder(passwordEncoder())
//        .withUser("user").password(ENCODED_PASSWORD).roles("USER");

		return new InMemoryUserDetailsManager(user);
	}

}
