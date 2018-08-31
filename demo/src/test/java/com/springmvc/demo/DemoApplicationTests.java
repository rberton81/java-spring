package com.springmvc.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springmvc.demo.controller.BaseController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
public class DemoApplicationTests {


	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}
	
	@Test
	public void contextLoads() {
//		mvc
//		.perform(get("/admin").with(user("admin").password("pass").roles("USER","ADMIN")))
	}
	
	@Test
	public void simple() throws Exception {
		standaloneSetup(new BaseController()).build()
			.perform(get("/"))
			.andExpect(status().isOk());
//			.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
//			.andExpect(content().string("Hello world!"));
	}

	@Test
	public void simpleNotExists() throws Exception {
		standaloneSetup(new BaseController()).build()
			.perform(get("/PageNotExists"))
			.andExpect(status().isNotFound());
//			.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
//			.andExpect(content().string("Hello world!"));
	}
	
	

}
