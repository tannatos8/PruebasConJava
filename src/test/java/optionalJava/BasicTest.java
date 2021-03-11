package optionalJava;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import juanonlab.tests.optional.Car;
import juanonlab.tests.optional.Utils;

class BasicTest {
	
	@Test
	void checkCarBuild() {		
		Car car = new Car("Opel Corsa");
		car.setTyre(Optional.of(Utils.buildDTyre("Dunlop Sport", 2017, "A")));
		Optional<Car> theCar = Optional.of(car);	
		assertTrue(theCar.isPresent());	
	}
}
