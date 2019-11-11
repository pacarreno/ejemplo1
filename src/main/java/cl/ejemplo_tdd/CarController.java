package cl.ejemplo_tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.ejemplo_tdd.domain.Car;
import cl.ejemplo_tdd.services.CarService;
import cl.ejemplo_tdd.services.exceptions.CarNotFoundException;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/cars/{name}")
	private Car getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void carNotFoundHandler(CarNotFoundException ex) {}
}
