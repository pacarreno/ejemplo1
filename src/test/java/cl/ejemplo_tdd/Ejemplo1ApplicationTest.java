package cl.ejemplo_tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ejemplo_tdd.domain.Car;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT )
class Ejemplo1ApplicationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getCar_returnsCarDetails() {
		
		//arrange
		
		//act
		ResponseEntity<Car> reponse = restTemplate.getForEntity("/cars/prius", Car.class);
		
		//assert
		assertThat(reponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(reponse.getBody().getName()).isEqualTo("prius");
		assertThat(reponse.getBody().getType()).isEqualTo("hybrid");
		
	}

}
