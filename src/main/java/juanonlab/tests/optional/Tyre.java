package juanonlab.tests.optional;

import java.util.Optional;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Tyre {
	
	Optional<BrandTyre> brand;
	String quality;
	
	public Tyre (BrandTyre brand, String quality) {
		this.brand = Optional.of(brand);	
		this.quality = quality;
	}

}
