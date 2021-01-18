package com.lpa.manning.cakeshop;

import com.lpa.manning.cakeshop.controller.IndexController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.lpa.manning.cakeshop.model.PastryDTO;
import com.lpa.manning.cakeshop.service.PastryService;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(IndexController.class)
class IndexControllerTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	WebClient webClient;
	
	@MockBean
	PastryService pastryService;
	
	static List<PastryDTO> pastries;
	
	@BeforeAll
	static void prepare() {
		pastries = new ArrayList<>();
		pastries.add(new PastryDTO("abcr", "All Butter Croissant", 0.75));
		pastries.add(new PastryDTO("ccr", "Chocolate Croissant", 0.95));
		pastries.add(new PastryDTO("b", "Fresh Baguette", 1.60));
		pastries.add(new PastryDTO("rv", "Red Velvet", 3.95));
		pastries.add(new PastryDTO("vs", "Victoria Sponge", 5.45));
		pastries.add(new PastryDTO("cc", "Carrot Cake", 3.45));
	}
	
	@Test
	@DisplayName("index page returns the landing page")
	void returnsLandingPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
	}
	
	@Test
	void getIndex() throws Exception {
		given(this.pastryService.getPastries())
		.willReturn(pastries);
		
		HtmlPage page = this.webClient.getPage("/");
		assertThat(page.getBody().getTextContent()).contains("abcr");
		
	}

}
