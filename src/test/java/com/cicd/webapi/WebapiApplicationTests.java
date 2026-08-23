package com.cicd.webapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebapiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void checkHealthyResponse() throws Exception {
		mockMvc.perform(get("/health")
				.accept(MediaType.TEXT_PLAIN)) 
				.andExpect(status().isOk())
				.andExpect(content().string("Server Health OK"));
	}

	@Test
	void checkDateResponse() throws Exception {
		mockMvc.perform(get("/date")
				.accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Current server Date " + java.time.LocalDate.now()));
				//.andExpect(content().string("current Server date:" + java.time.LocalDateTime.now()));

	}
}
