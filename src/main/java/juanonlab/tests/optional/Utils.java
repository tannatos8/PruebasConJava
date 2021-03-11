package juanonlab.tests.optional;

public class Utils {

	/**
	 * 
	 * BuildTyre
	 * 
	 * @param model
	 * @param year
	 * @param quality
	 * @return a Tyre
	 */
	public static Tyre buildDTyre(final String model, final int year, final String quality) {
		BrandTyre brandTyre = new BrandTyre(new BrandTyreInfo(model, year));
		return new Tyre(brandTyre, quality);
	}
}
