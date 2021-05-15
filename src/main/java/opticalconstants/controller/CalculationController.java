package opticalconstants.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import opticalconstants.model.CalculationInput;
import opticalconstants.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    private static final Logger log = LoggerFactory.getLogger(CalculationController.class);
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculate")
    public void calculate(@RequestBody CalculationInput input) throws JsonProcessingException {
        log.info("Received calculation request. Input: {}", input);
        calculationService.calculate(input);
    }
}
