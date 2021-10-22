package olson.grant.fdsum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculations")
public class CalculationController {
	
	private final FactorialDigitSumService calculatorService;
	
	public CalculationController(FactorialDigitSumService factorialDigitSumService) {
		this.calculatorService = factorialDigitSumService;
	}
	
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/factorialdigitsum/{n}")
    public FactorialDigitSumResponse getFactorialDigitSum(@PathVariable Integer n) {
    	return calculatorService.calculate(n);
    }
    
    
}
