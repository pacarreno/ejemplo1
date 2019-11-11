package cl.ejemplo_tdd.services;

import org.springframework.stereotype.Service;

import cl.ejemplo_tdd.domain.Car;
import cl.ejemplo_tdd.repositories.CarRepository;
import cl.ejemplo_tdd.services.exceptions.CarNotFoundException;

@Service
public class CarService {

	private CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public Car getCarDetails(String name) {
		Car car = carRepository.findByName(name);
		if( car == null )
			throw new CarNotFoundException();
		return car;
	}

}
