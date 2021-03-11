package juanonlab.tests.optional;


import lombok.Data;

@Data
public class BrandTyreInfo {
	public String name;
	public int year;

	public BrandTyreInfo(String name, int year) {
		this.name = name;
		this.year = year;
	}
}