package cl.ejemplo_tdd.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ejemplo_tdd.domain.Car;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository reposotory;
	
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void getCar_returnsCarDetails() throws Exception {
		
		Car savedCar = entityManager.persistFlushFind(new Car("prius","hybrid"));
		//Car savedCar = entityManager.persistAndFlush(new Car("prius","hybrid"));
		Car car = reposotory.findByName("prius");
		
		Assertions.assertThat(car.getName()).isEqualTo(savedCar.getName());
		Assertions.assertThat(car.getType()).isEqualTo(savedCar.getType());
	}

}
