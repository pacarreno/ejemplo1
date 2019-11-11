package cl.ejemplo_tdd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue
	private Long id;
	String name;
	String type;

	public Car(String name, String type) {
		this.name = name;
		this.type = type;
	}
}
