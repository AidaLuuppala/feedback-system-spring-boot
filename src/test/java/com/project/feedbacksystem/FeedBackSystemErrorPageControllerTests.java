package com.project.feedbacksystem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.project.feedbacksystem.web.ErrorPageController;
import com.project.feedbacksystem.web.FeedbackSystemController;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedBackSystemErrorPageControllerTests extends TestCase {

	
	private MockMvc mockMvc;	
	private ErrorPageController errorcontroller;
	
	@Before
	public void setup() {
		errorcontroller = new ErrorPageController();
		mockMvc = MockMvcBuilders.standaloneSetup(errorcontroller).build();
	}
	
	@Test
	public void errorPageOpens() throws Exception {
	mockMvc.perform(get("/error/")).andExpect(MockMvcResultMatchers.view().name("error"));
	}
}