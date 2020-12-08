package de.applicity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.application.WeatherSpringBootApplication;
import de.application.entities.Weatherdata;
import de.application.repositories.WeatherRepository;
import de.application.services.WeatherService;

// Hier die Integration Tests
@RunWith(SpringRunner.class)
// @ExtendWith(SpringExtension.class)
// lorsque je vois cette Annotation alors, je fais des tests d'integration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WeatherSpringBootApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class WeatherRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WeatherRepository repository;

	@Autowired
	private WeatherService service;

	@Autowired
	private ObjectMapper objMapper;

	@Ignore
	@Test
	public void allWeather() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/listAllWeather")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andReturn();

		System.out.println("ALLE STÄDTE: " + result.getResponse().getContentAsString());
	}

	@Ignore
	@Test
	public void testWeatherName() throws Exception {

		mvc.perform(
				get("/api/weathercityName?name=Hanau").contentType(org.springframework.http.MediaType.APPLICATION_JSON))

				.andExpect(status().isOk());

		Weatherdata data = repository.findByCityName("Hanau");
		assertThat(data.getName()).isEqualTo("Hanau");

	}

	@Ignore
	@Test
	public void testSaveWeatherdata() throws Exception {

		Weatherdata data = service.findCityWithName("Nevada");

		MvcResult result = mvc
				.perform(post("/api/saveWeatherdata").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
						.content(objMapper.writeValueAsString(data)))
				.andExpect(status().isOk()).andReturn();

		System.out.println("Save the City : " + result.getResponse().getContentAsString());

	}
}