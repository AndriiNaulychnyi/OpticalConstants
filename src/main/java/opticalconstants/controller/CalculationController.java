package opticalconstants.controller;

import opticalconstants.model.CalculationInput;
import opticalconstants.service.CalculationParam;
import opticalconstants.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CalculationController {

    private static final Logger log = LoggerFactory.getLogger(CalculationController.class);
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/")
    public String showInputPage() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@Valid CalculationInput input) {
        log.info("Received calculation request. Input: {}", input);
        List<CalculationParam> results = calculationService.calculate(input);
        return "results";
    }
}
