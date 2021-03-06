package com.codemerchant.sufficient365;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CropRestTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAuthentication() throws Exception {
		// testing authentication using correct login details

		this.mockMvc.perform(post("/login").content("{\"username\":\"admin\", \"password\":\"admin\"}")).andDo(print())
				.andExpect(status().isOk());

		// testing authentication using incorrect login details
		this.mockMvc.perform(post("/login").content("{\"username\":\"admin\", \"password\":\"wrongpassword\"}"))
		.andDo(print()).andExpect(status().is4xxClientError());

	}

}
