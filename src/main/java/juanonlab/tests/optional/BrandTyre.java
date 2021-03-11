package juanonlab.tests.optional;

import java.util.Optional;

import lombok.Data;

@Data
public class BrandTyre {
	
	Optional<BrandTyreInfo> brandTyreInfo;

	public BrandTyre(BrandTyreInfo data)  {
		brandTyreInfo = Optional.of(data);
	}

}
