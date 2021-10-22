package olson.grant.fdsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialDigitSumServiceTest {
	
	FactorialDigitSumService calculatorService = new FactorialDigitSumService();

	@Test
	void calculateForInput10() {
		FactorialDigitSumResponse response = calculatorService.calculate(10);
		Assertions.assertEquals(response.getFactorialDigitSum(), 27);
	}
	
	@Test
	void seeExceptionForInput0() {
		Exception exception = Assertions.assertThrows(InputRangeException.class, 
				() -> calculatorService.calculate(0));
		Assertions.assertNotNull(exception);
		Assertions.assertNotNull(exception.getMessage());
	}

	@Test
	void calculateForInput100() {
		FactorialDigitSumResponse response = calculatorService.calculate(100);
		Assertions.assertEquals(response.getFactorialDigitSum(), 648);
	}
	
	@Test
	void seeExceptionForInput101() {
		Exception exception = Assertions.assertThrows(InputRangeException.class, 
				() -> calculatorService.calculate(101));
		Assertions.assertNotNull(exception);
		Assertions.assertNotNull(exception.getMessage());
	}	
	
}
