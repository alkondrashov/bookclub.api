package com.bookclub;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BookClubApp.class)
@ActiveProfiles("mvc")
public class BookClubAppTests {

	private static final String CLIENT_ID = "testjwtclientid";
	private static final String CLIENT_SECRET = "XY7kmzoNzl100";
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	private static final String JWTPASS = "jwtpass";
	private static final String ADMIN_USER = "admin";
	private static final Integer MERCHANT_ID = 1;
	private static final String MICHAEL = "Michael";
	private static final String AYDIN = "Aydin";

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
	}

	private String obtainAccessToken(String username, String password) throws Exception {
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "password");
		params.add("client_id", CLIENT_ID);
		params.add("username", username);
		params.add("password", password);

		ResultActions result = mockMvc
				.perform(post("/oauth/token").params(params).with(httpBasic(CLIENT_ID, CLIENT_SECRET))
						.accept(CONTENT_TYPE))
				.andExpect(status().isOk()).andExpect(content().contentType(CONTENT_TYPE));

		String resultString = result.andReturn().getResponse().getContentAsString();

		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString).get("access_token").toString();
	}

	@Test
	public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
		mockMvc.perform(get("/api/transactions")).andExpect(status().isUnauthorized());
	}

	@Test
	public void givenToken_whenPostGetSecureRequestTransactions_thenOk() throws Exception {
		final String accessToken = obtainAccessToken(ADMIN_USER, JWTPASS);

		MvcResult result = mockMvc.perform(
				get("/api/transactions").header("Authorization", "Bearer " + accessToken).contentType(CONTENT_TYPE))
				.andReturn();

		mockMvc.perform(asyncDispatch(result)).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].merchantId", is(MERCHANT_ID)));

	}


}