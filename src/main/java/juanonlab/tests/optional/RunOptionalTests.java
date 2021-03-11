package juanonlab.tests.optional;

import java.util.Optional;

public class RunOptionalTests {

	// See: https://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
	// For more info.

	private static final int YEAR_DEFAULT = 1980;
	
	private static final String NO_NAME = "No Name";
	
	public static void main(String[] args) {
		testOptional();
	}

	/**
	 * testOptional
	 */
	public static void testOptional() {

		// Set components to Opel Corsa
		Car car = new Car("Opel Corsa");
		car.setTyre(Optional.of(Utils.buildDTyre("Dunlop Sport", 2017, "A")));
		Optional<Car> theCar = Optional.of(car);		
		showInfo(theCar);

		// Set components to Opel Kadett
		car = new Car("Opel Kadett");
		theCar = Optional.of(car);
		showInfo(theCar);

		// Set components to Lada Niva
		car = new Car("Lada Niva");
		theCar = Optional.of(car);
		car.setTyre(Optional.of(Utils.buildDTyre("Basic Model", 1998, "C")));
		showInfo(theCar);

	}



	/**
	 * 
	 * showInfo
	 * 
	 * @param tyreToProcess
	 * @param theCar
	 */
	private static void showInfo(final Optional<Car> theCar) {
		// NO!
		// if (theCar.get() != null) {
		//  System.out.println(" Car --> " + theCar.get().getModel());
		// } else {
		//  System.out.println(" Car --> No name");
		// }

		// NO!
		// System.out.println(" Car --> " + (theCar.isPresent() ?
		// theCar.get().getModel() : NO_NAME));

		// Yes! :-)
		System.out.println(" \nCar --> " + theCar.map(Car::getModel).orElse(NO_NAME));
		System.out.println(" Tyre Name --> " + getBrandTyreName(theCar));
		System.out.println(" Tyre Year --> " + getBrandTyreYear(theCar));
		lowQualityTyres(theCar);
	}

	/**
	 * 
	 * getBrandTyreName
	 * 
	 * @param theCar
	 * @return
	 */
	private static String getBrandTyreName(final Optional<Car> theCar) {
		return theCar.flatMap(Car::getTyre).flatMap(Tyre::getBrand).flatMap(BrandTyre::getBrandTyreInfo)
				.map(BrandTyreInfo::getName).orElse(NO_NAME);
	}

	/**
	 * 
	 * getBrandTyreYear
	 * 
	 * @param theCar
	 * @return
	 */
	private static int getBrandTyreYear(final Optional<Car> theCar) {
		return theCar.flatMap(Car::getTyre).flatMap(Tyre::getBrand).flatMap(BrandTyre::getBrandTyreInfo)
				.map(BrandTyreInfo::getYear).orElse(YEAR_DEFAULT);
	}

	/**
	 * lowQualityTyres
	 * 
	 * @param theCar
	 */
	private static void lowQualityTyres(final Optional<Car> theCar) {
		theCar.flatMap(Car::getTyre).filter(tyre -> "C".equals(tyre.getQuality()))
				.ifPresent(tyre -> System.out.println(" Car with low Quality tyres"));
	}

	/**
	 * getBrandTyreYearOldSchool (incorrect use of optional)
	 * 
	 * @param theCar
	 * @return
	 */
//	private static String getBrandTyreYearOldSchool(final Optional<Car> theCar) {
//		
//		// Check car
//		if (theCar.get()!=null) {
//			if (theCar.get().getTyre() != null) {
//				if (theCar.get().getTyre().get().getBrand()!=null) {
//					if (theCar.get().getTyre().get().getBrand().get().getBrandTyreInfo() !=null) {
//						String tyreName = theCar.get().getTyre().get().getBrand().get().getBrandTyreInfo().get().getName();
//						if (theCar.get().getTyre().get().getBrand().get().getBrandTyreInfo().get().getName() != null) {
//							return tyreName;
//						} else {
//							return NO_NAME;
//						}
//					} else {
//						return NO_NAME;
//					}
//				}
//				else {
//					return NO_NAME;
//				}
//			} else {
//				return NO_NAME;
//			}
//		} else {
//			return NO_NAME;
//		}					
//	}

}
