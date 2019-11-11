package cl.ejemplo_tdd.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.ejemplo_tdd.domain.Car;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>{

	Car findByName(String string);

}
