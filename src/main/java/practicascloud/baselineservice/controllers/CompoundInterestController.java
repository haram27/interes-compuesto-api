package practicascloud.baselineservice.controllers;

import org.springframework.web.bind.annotation.*;
import practicascloud.baselineservice.models.CalculationInput;
import practicascloud.baselineservice.models.TotalCalculation;
import practicascloud.baselineservice.services.CompoundInterestService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api/v1/interest")
public class CompoundInterestController {

    private final CompoundInterestService compoundInterestService;

    public CompoundInterestController(CompoundInterestService compoundInterestService) {
        this.compoundInterestService = compoundInterestService;
    }

    @PostMapping("/calculate")
    public TotalCalculation calculateCompoundInterest(@RequestBody @Valid CalculationInput input) {
        System.out.println(input);
        return compoundInterestService.calculate(input);
    }

}
