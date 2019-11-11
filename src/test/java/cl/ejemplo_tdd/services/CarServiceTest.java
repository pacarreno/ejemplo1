package cl.ejemplo_tdd.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import cl.ejemplo_tdd.domain.Car;
import cl.ejemplo_tdd.repositories.CarRepository;
import cl.ejemplo_tdd.services.exceptions.CarNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
	
	@Mock
	private CarRepository carRepository;
	
	private CarService carService;
	
	@Before
	public void setUp() throws Exception {
		carService = new CarService(carRepository);
	}
	
	@Test
	public void getCarDetails_returnsCarInfo() {
		BDDMockito.given(carRepository.findByName("prius")).willReturn(new Car("prius","hybrid"));
		
		Car car = carService.getCarDetails("prius");
		
		assertThat(car.getName()).isEqualTo("prius");
		assertThat(car.getType()).isEqualTo("hybrid");
		
	}
	
	@Test(expected = CarNotFoundException.class)
	public void getCarDetails_whenCarNotFound() throws Exception {
		BDDMockito.given(carRepository.findByName("prius")).willReturn(null);
		
		carService.getCarDetails("prius");
	}

}
