package olson.grant.fdsum;

import java.math.BigInteger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactorialDigitSumResponse {
	
	private Integer n;
	private BigInteger nFactorial;
	private Integer factorialDigitSum;

}
