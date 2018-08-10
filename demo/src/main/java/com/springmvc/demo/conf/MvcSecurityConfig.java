package com.springmvc.demo.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 DataSource dataSource;
	 private static String REALM="MY_TEST_REALM";

	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery(
	   "select username,password, enabled from users where username=?")
	  .authoritiesByUsernameQuery(
	   "select username, role from user_roles where username=?");
	 } 
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
        .authorizeRequests()
        .antMatchers("/login/logintest").authenticated()
        .antMatchers("/**").permitAll()
//            .antMatchers("/login*").permitAll()
//            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
		
        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
        httpSecurity.csrf().disable()
        .authorizeRequests()
//        .antMatchers("/user/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("USER")
//        .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.;
	}

//	 @Bean
//	    public BasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
//	        return new BasicAuthenticationEntryPoint();
//	    }
	
	@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = 
        		 User.withDefaultPasswordEncoder()
		.username("user")
		.password("password")
		.roles("USER")
                .build();
        
//        auth.inMemoryAuthentication()
//        .passwordEncoder(passwordEncoder())
//        .withUser("user").password(ENCODED_PASSWORD).roles("USER");

        return new InMemoryUserDetailsManager(user);
    }

}
