package olson.grant.fdsum;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FactorialDigitSumService {
	
	public FactorialDigitSumResponse calculate(int n) {	
		if ((n < 1) || (n > 100)) throw new InputRangeException("n must be an integer between 1 and 100, inclusive");
		BigInteger nFactorial = factorial(n);
		log.debug("nFactorial: {}", nFactorial.toString());
		String nFactorialString = nFactorial.toString();
		int sumOfDigits = nFactorialString.codePoints()
										  .mapToObj(c -> String.valueOf((char) c))
										  .mapToInt(Integer::valueOf)
										  .reduce(0, (subTotal, element) -> subTotal + element);
		return FactorialDigitSumResponse.builder().n(n).nFactorial(nFactorial).factorialDigitSum(sumOfDigits).build();
	}
	
	private static BigInteger factorial(int n) {
		BigInteger f = BigInteger.ONE;		
		for (int i = 2; i <= n; i++) {
			f = f.multiply(BigInteger.valueOf(i));
		}
		return f;
	}

}
