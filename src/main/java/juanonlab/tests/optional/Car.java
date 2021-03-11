package juanonlab.tests.optional;

import java.util.Optional;

import lombok.Data;

@Data
public class Car {

	Optional<Tyre> tyre;
	
	String model;
	
	public Car (String model) {		
			this.model = model;
			tyre = Optional.empty();
	}
	
}
